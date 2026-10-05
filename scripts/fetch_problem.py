#!/usr/bin/env python3
"""
Scaffold a problem folder from a LeetCode URL or slug.

Pulls the title, number, difficulty, description and method stubs from
LeetCode's public GraphQL endpoint, converts the description HTML into the
repo's problem.md format, and drops the real signatures into solution.py and
solution.java.

Usage:
    python scripts/fetch_problem.py <url-or-slug> [--force]
    python scripts/fetch_problem.py https://leetcode.com/problems/two-sum/
    python scripts/fetch_problem.py two-sum
    python scripts/fetch_problem.py --daily

approach.md is left as a skeleton with LeetCode's topic tags pre-filled,
filtered to the tag names this repo already uses. The remaining sections are
for you (or Claude) to write.
"""

import argparse
import html
import json
import re
import sys
import urllib.error
import urllib.request
from pathlib import Path

REPO_ROOT = Path(__file__).parent.parent
GRAPHQL_URL = "https://leetcode.com/graphql"
DIFFICULTY_DIRS = {"Easy": "easy", "Medium": "medium", "Hard": "hard"}

QUESTION_QUERY = """
query question($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    questionFrontendId
    title
    titleSlug
    difficulty
    isPaidOnly
    content
    topicTags { name }
    codeSnippets { lang code }
  }
}
"""

DAILY_QUERY = """
query daily {
  activeDailyCodingChallengeQuestion {
    question { titleSlug }
  }
}
"""


def graphql(query: str, variables: dict | None = None) -> dict:
    payload = json.dumps({"query": query, "variables": variables or {}}).encode()
    request = urllib.request.Request(
        GRAPHQL_URL,
        data=payload,
        headers={
            "Content-Type": "application/json",
            # LeetCode rejects requests without a browser-like agent
            "User-Agent": "Mozilla/5.0",
            "Referer": "https://leetcode.com/",
        },
    )
    try:
        with urllib.request.urlopen(request, timeout=20) as response:
            body = json.load(response)
    except urllib.error.HTTPError as exc:
        sys.exit(f"Error: LeetCode returned HTTP {exc.code}")
    except urllib.error.URLError as exc:
        sys.exit(f"Error: could not reach LeetCode ({exc.reason})")

    if body.get("errors"):
        sys.exit(f"Error: {body['errors'][0].get('message', 'GraphQL error')}")
    return body["data"]


def slug_from_input(text: str) -> str:
    """Accept a full URL, a /problems/... path, or a bare slug."""
    match = re.search(r"/problems/([a-z0-9-]+)", text)
    if match:
        return match.group(1)
    return text.strip().strip("/").lower()


# --- HTML -> markdown -------------------------------------------------------

def inline(fragment: str) -> str:
    """Convert inline markup, then unescape entities."""
    fragment = re.sub(r"<sup>(.*?)</sup>", r"^\1", fragment, flags=re.S)
    fragment = re.sub(r"<sub>(.*?)</sub>", r"_\1", fragment, flags=re.S)
    fragment = re.sub(r"<code>(.*?)</code>", r"`\1`", fragment, flags=re.S)
    fragment = re.sub(r"<img[^>]*src=\"([^\"]+)\"[^>]*>", r"![image](\1)", fragment)
    fragment = re.sub(r"<br\s*/?>", "\n", fragment)
    fragment = re.sub(r"<[^>]+>", "", fragment)
    fragment = html.unescape(fragment).replace("\xa0", " ")
    # LeetCode sprinkles zero-width characters through some statements
    fragment = re.sub(r"[\u200b\u200e\u200f\u2060\ufeff]", "", fragment)
    # collapse runs of spaces but keep newlines; <br /><br /> would
    # otherwise leave a run of three
    fragment = re.sub(r"[ \t]+", " ", fragment)
    fragment = re.sub(r"\n{3,}", "\n\n", fragment)
    return fragment.strip()


def pre_text(fragment: str) -> str:
    """A <pre> block keeps its line breaks; only tags and entities go."""
    fragment = re.sub(r"<sup>(.*?)</sup>", r"^\1", fragment, flags=re.S)
    fragment = re.sub(r"<br\s*/?>", "\n", fragment)
    fragment = re.sub(r"<[^>]+>", "", fragment)
    fragment = html.unescape(fragment).replace("\xa0", " ")
    fragment = re.sub(r"[\u200b\u200e\u200f\u2060\ufeff]", "", fragment)
    return fragment.strip("\n")


def split_blocks(content: str):
    """Yield ('p'|'ul'|'pre', inner_html) in document order.

    Text sitting outside any block tag is yielded as a paragraph. LeetCode
    does that for trailing notes (two-sum's follow-up is a bare <strong>),
    and skipping it loses real content.
    """
    pattern = re.compile(
        r"<(p|ul|ol|pre|blockquote)\b[^>]*>(.*?)</\1>", re.S | re.I
    )
    def meaningful(fragment: str) -> bool:
        # an <img>-only gap carries content even though it has no text
        if re.search(r"<img\b", fragment, re.I):
            return True
        return bool(re.sub(r"<[^>]+>|&nbsp;|\s", "", fragment))

    cursor = 0
    for match in pattern.finditer(content):
        gap = content[cursor:match.start()]
        if meaningful(gap):
            yield "p", gap
        tag = match.group(1).lower()
        yield ("ul" if tag == "blockquote" else tag), match.group(2)
        cursor = match.end()

    tail = content[cursor:]
    if meaningful(tail):
        yield "p", tail


def list_items(inner_html: str, ordered: bool) -> list[str]:
    """Rendered list items, numbered for <ol> and bulleted for <ul>."""
    raw = re.findall(r"<li\b[^>]*>(.*?)</li>", inner_html, re.S | re.I)
    texts = [text for text in (inline(item) for item in raw) if text]
    if ordered:
        return [f"{i}. {text}" for i, text in enumerate(texts, start=1)]
    return [f"- {text}" for text in texts]


def build_problem_md(question: dict) -> tuple[str, list[str]]:
    """Return (markdown, warnings)."""
    title = question["title"]
    slug = question["titleSlug"]
    difficulty = question["difficulty"]
    warnings = []

    description: list[str] = []
    # each example: {"images": [markdown], "lines": [text]} so that an
    # illustration renders above the fenced block instead of inside it
    examples: list[dict] = []
    constraints: list[str] = []
    follow_ups: list[str] = []

    section = "description"

    for kind, inner in split_blocks(question["content"]):
        if kind == "pre":
            block = pre_text(inner)
            if not block:
                continue
            if section == "example" and examples:
                examples[-1]["lines"].append(block)
            else:
                # a <pre> before any "Example N:" heading still belongs
                # with the examples
                examples.append({"images": [], "lines": [block]})
                section = "example"
            continue

        if kind in ("ul", "ol"):
            items = list_items(inner, ordered=(kind == "ol"))
            if not items:
                continue
            # a list is one block: its items must stay on consecutive lines
            block = "\n".join(items)
            if section == "constraints":
                constraints.extend(items)
            elif section == "example" and examples:
                examples[-1]["lines"].append(block)
            else:
                description.append(block)
            continue

        text = inline(inner)
        if not text or text == "\xa0":
            continue

        if re.fullmatch(r"Example\s*\d*\s*:?", text, re.I):
            examples.append({"images": [], "lines": []})
            section = "example"
            continue
        if re.fullmatch(r"Constraints\s*:?", text, re.I):
            section = "constraints"
            continue
        if re.match(r"Follow[- ]?up\s*:", text, re.I):
            follow_ups.append(text)
            section = "followup"
            continue

        images = re.findall(r"!\[image\]\([^)]+\)", text)
        if images and section == "example" and examples:
            examples[-1]["images"].extend(images)
            remainder = re.sub(r"!\[image\]\([^)]+\)", "", text).strip()
            if remainder:
                examples[-1]["lines"].append(remainder)
            continue

        if section == "description":
            description.append(text)
        elif section == "example" and examples:
            examples[-1]["lines"].append(text)
        elif section == "constraints":
            constraints.append(f"- {text}")
        else:
            follow_ups.append(text)

    if "![image](" in question["content"] or "<img" in question["content"]:
        warnings.append("description contains an image; check it renders usefully")
    if "<table" in question["content"]:
        warnings.append("description contains a table; reformat it by hand")
    if not examples:
        warnings.append("no examples found; paste them in by hand")
    if not constraints:
        warnings.append("no constraints found; paste them in by hand")

    parts = [
        f"# {title}",
        "",
        f"**Difficulty:** {difficulty}  ",
        f"**LeetCode Link:** [{title}](https://leetcode.com/problems/{slug}/)",
        "",
        "## Description",
        "",
    ]
    parts.append("\n\n".join(description) if description else "<!-- see LeetCode -->")
    parts.append("")

    parts.extend(["## Examples", ""])
    for index, example in enumerate(examples, start=1):
        parts.append(f"### Example {index}")
        for image in example["images"]:
            parts.extend(["", image])
        parts.append("```")
        parts.append("\n".join(example["lines"]))
        parts.extend(["```", ""])

    parts.extend(["## Constraints", ""])
    parts.extend(constraints if constraints else ["- "])
    parts.append("")

    for note in follow_ups:
        # match the hand-written style: bold the label, keep it after constraints
        note = re.sub(r"^(Follow[- ]?up\s*:)", r"**\1**", note, flags=re.I)
        parts.extend([note, ""])

    return "\n".join(parts), warnings


# --- stubs ------------------------------------------------------------------

def snippet(question: dict, lang: str) -> str | None:
    for item in question["codeSnippets"] or []:
        if item["lang"] == lang:
            return item["code"].replace("\r\n", "\n").rstrip()
    return None


def build_solution_py(question: dict, number: str) -> tuple[str, list[str]]:
    code = snippet(question, "Python3")
    warnings = []
    header = f'        """\n        {number}. {question["title"]}\n        Time: O()\n        Space: O()\n        """\n        pass\n'

    if not code:
        warnings.append("no Python3 stub from LeetCode; write the signature by hand")
        return f'class Solution:\n    def solve(self):\n{header}', warnings

    lines = code.split("\n")
    # the method signature is the last "def " line (definition comments above
    # it, e.g. TreeNode, stay where LeetCode put them)
    def_index = max(
        (i for i, line in enumerate(lines) if line.lstrip().startswith("def ")),
        default=None,
    )
    if def_index is None:
        warnings.append("could not locate the method in the Python stub")
        return code + "\n", warnings

    body = lines[: def_index + 1] + [header.rstrip("\n")]
    text = "\n".join(body) + "\n"

    imports = []
    if re.search(r"\b(List|Optional|Dict|Set|Tuple)\b", code):
        needed = sorted({m for m in ("List", "Optional", "Dict", "Set", "Tuple")
                         if re.search(rf"\b{m}\b", code)})
        imports.append(f"from typing import {', '.join(needed)}")
    if imports:
        text = "\n".join(imports) + "\n\n\n" + text
    return text, warnings


def build_solution_java(question: dict, number: str) -> tuple[str, list[str]]:
    code = snippet(question, "Java")
    warnings = []
    javadoc = f"/**\n * {number}. {question['title']}\n * Time: O()\n * Space: O()\n */"

    if not code:
        warnings.append("no Java stub from LeetCode; write the signature by hand")
        return javadoc + "\nclass Solution {\n    \n}\n", warnings

    # the javadoc goes directly above `class Solution`, below any
    # "Definition for ..." block LeetCode put in the stub
    lines = code.split("\n")
    class_index = next(
        (i for i, line in enumerate(lines) if line.startswith("class ")
         or line.startswith("public class ")),
        None,
    )
    if class_index is None:
        warnings.append("could not locate the class in the Java stub")
        return javadoc + "\n" + code + "\n", warnings

    before = lines[:class_index]
    if before and before[-1].strip():
        before.append("")  # blank line after a definition block
    return "\n".join(before + [javadoc] + lines[class_index:]) + "\n", warnings


# --- tags -------------------------------------------------------------------

def repo_tag_vocabulary() -> set[str]:
    """Every tag name already used in an approach.md, so new folders stay
    consistent with the generated README tables."""
    vocabulary: set[str] = set()
    for path in REPO_ROOT.glob("*/*/approach.md"):
        for line in path.read_text(errors="replace").split("\n"):
            if line.startswith("**Tags:**"):
                vocabulary.update(re.findall(r"`([^`]+)`", line))
                break
    return vocabulary


def build_approach_md(question: dict) -> tuple[str, list[str]]:
    leetcode_tags = [tag["name"] for tag in question["topicTags"] or []]
    vocabulary = repo_tag_vocabulary()
    kept = [tag for tag in leetcode_tags if tag in vocabulary]
    dropped = [tag for tag in leetcode_tags if tag not in vocabulary]

    warnings = []
    if dropped:
        warnings.append(
            f"tags not used elsewhere in this repo were dropped: {', '.join(dropped)}"
        )
    if not kept:
        warnings.append("no tags matched the repo vocabulary; fill in **Tags:** by hand")

    tag_line = ", ".join(f"`{tag}`" for tag in kept) if kept else "``"
    return (
        f"""# Approach

**Tags:** {tag_line}

## Intuition

<!-- What's the first thought when you see this problem? -->

## Approach

<!-- Step-by-step explanation -->

## Complexity

- **Time:** O()
- **Space:** O()

## Edge Cases

-
""",
        warnings,
    )


def has_own_work(path: Path, generated: str) -> bool:
    """True when the file on disk has been filled in, rather than being the
    skeleton this script writes (or a close variant of it)."""
    try:
        current = path.read_text()
    except OSError:
        return False
    if not current.strip() or current.strip() == generated.strip():
        return False

    # markers that only survive in an untouched skeleton
    untouched = {
        "approach.md": "<!-- What's the first thought",
        "solution.py": "Time: O()",
        "solution.java": "Time: O()",
    }.get(path.name)
    return untouched is None or untouched not in current


# --- main -------------------------------------------------------------------

def main() -> None:
    parser = argparse.ArgumentParser(
        description="Scaffold a problem folder from a LeetCode URL or slug."
    )
    parser.add_argument("target", nargs="?", help="LeetCode URL or problem slug")
    parser.add_argument("--daily", action="store_true",
                        help="use today's daily challenge")
    parser.add_argument("--force", action="store_true",
                        help="overwrite an existing folder")
    args = parser.parse_args()

    if args.daily:
        data = graphql(DAILY_QUERY)
        slug = data["activeDailyCodingChallengeQuestion"]["question"]["titleSlug"]
        print(f"Daily challenge: {slug}")
    elif args.target:
        slug = slug_from_input(args.target)
    else:
        parser.error("pass a URL/slug, or --daily")

    question = graphql(QUESTION_QUERY, {"titleSlug": slug})["question"]
    if not question:
        sys.exit(f"Error: no problem found for slug '{slug}'")
    if question["isPaidOnly"]:
        sys.exit(
            f"Error: '{question['title']}' is premium-locked, so the description "
            "is not available. Paste it in manually."
        )

    number_raw = int(question["questionFrontendId"])
    # folders pad below 1000 so they sort; docstrings use the plain number
    folder_number = str(number_raw).zfill(3) if number_raw < 1000 else str(number_raw)
    display_number = str(number_raw)
    difficulty_dir = DIFFICULTY_DIRS[question["difficulty"]]
    folder = REPO_ROOT / difficulty_dir / f"{folder_number}-{question['titleSlug']}"

    folder_existed = folder.exists()
    if folder_existed and not args.force:
        sys.exit(f"Error: {folder.relative_to(REPO_ROOT)} already exists "
                 "(pass --force to refresh problem.md)")

    problem_md, warnings = build_problem_md(question)
    approach_md, approach_warnings = build_approach_md(question)
    solution_py, py_warnings = build_solution_py(question, display_number)
    solution_java, java_warnings = build_solution_java(question, display_number)
    warnings += approach_warnings + py_warnings + java_warnings

    folder.mkdir(parents=True, exist_ok=True)
    existed = folder_existed

    written, kept = [], []
    for name, text in (
        ("problem.md", problem_md),
        ("approach.md", approach_md),
        ("solution.py", solution_py),
        ("solution.java", solution_java),
    ):
        path = folder / name
        # problem.md is generated wholesale, so refreshing it is safe. The
        # other three may hold real work; never overwrite that, even with
        # --force, which is meant for re-pulling a statement.
        if name != "problem.md" and path.exists() and has_own_work(path, text):
            kept.append(name)
            continue
        path.write_text(text)
        written.append(name)

    print(f"{'Updated' if existed else 'Created'}: {folder.relative_to(REPO_ROOT)}")
    print(f"  {display_number}. {question['title']} ({question['difficulty']})")
    for name in written:
        print(f"  - {name}")
    for name in kept:
        print(f"  - {name} (kept, already written)")

    if warnings:
        print("\nCheck these:")
        for warning in warnings:
            print(f"  ! {warning}")

    todo = [name for name in ("approach.md", "solution.py", "solution.java")
            if name in written]
    if todo:
        print(f"\nStill to write: {', '.join(todo)}.")


if __name__ == "__main__":
    main()
