#!/usr/bin/env python3
"""
Auto-generates README.md files from folder structure.
- Main README: Stats, topics, usage guide
- Difficulty READMEs: Problem tables per difficulty

Run after adding a new problem.
"""

import re
from pathlib import Path

REPO_ROOT = Path(__file__).parent.parent
DIFFICULTIES = ["easy", "medium", "hard"]


def parse_problem_folder(folder_name: str) -> tuple[str, str]:
    """Extract problem number and slug from folder name."""
    match = re.match(r"(\d+)-(.+)", folder_name)
    if match:
        return match.group(1), match.group(2)
    return "", folder_name


def get_tags_from_approach(approach_path: Path) -> list[str]:
    """Extract tags from approach.md file."""
    if not approach_path.exists():
        return []
    
    content = approach_path.read_text()
    match = re.search(r"\*\*Tags:\*\*\s*(.+)", content)
    if not match:
        match = re.search(r"Tags:\s*(.+)", content)
    
    if match:
        tags_str = match.group(1)
        tags = re.findall(r"`([^`]+)`", tags_str)
        return tags
    return []


def get_problem_title(problem_path: Path) -> str:
    """Extract problem title from problem.md."""
    if not problem_path.exists():
        return ""
    
    content = problem_path.read_text()
    match = re.match(r"#\s*(.+)", content)
    if match:
        title = match.group(1).strip()
        title = re.sub(r"\s*\(.*\)\s*$", "", title)
        return title
    return ""


def scan_problems() -> dict:
    """Scan all problem folders and collect metadata."""
    problems_by_difficulty = {"easy": [], "medium": [], "hard": []}
    all_tags = set()
    counts = {"easy": 0, "medium": 0, "hard": 0}
    
    for difficulty in DIFFICULTIES:
        diff_path = REPO_ROOT / difficulty
        if not diff_path.exists():
            continue
        
        for folder in sorted(diff_path.iterdir()):
            if not folder.is_dir() or folder.name.startswith("."):
                continue
            
            number, slug = parse_problem_folder(folder.name)
            if not number:
                continue
            
            problem_md = folder / "problem.md"
            approach_md = folder / "approach.md"
            solution_py = folder / "solution.py"
            solution_java = folder / "solution.java"
            
            title = get_problem_title(problem_md) or slug.replace("-", " ").title()
            tags = get_tags_from_approach(approach_md)
            all_tags.update(tags)
            
            problems_by_difficulty[difficulty].append({
                "number": number,
                "slug": slug,
                "title": title,
                "difficulty": difficulty.capitalize(),
                "tags": tags,
                "has_python": solution_py.exists(),
                "has_java": solution_java.exists(),
            })
            
            counts[difficulty] += 1
    
    # Sort each difficulty by problem number
    for difficulty in DIFFICULTIES:
        problems_by_difficulty[difficulty].sort(key=lambda p: int(p["number"]))
    
    return {
        "problems_by_difficulty": problems_by_difficulty,
        "tags": sorted(all_tags),
        "counts": counts,
        "total": sum(counts.values()),
    }


def generate_main_readme(data: dict) -> str:
    """Generate main README with stats, topics, and links."""
    counts = data["counts"]
    total = data["total"]
    tags = data["tags"]
    
    progress = f"""| Difficulty | Solved | Problems |
|------------|--------|----------|
| Easy       | {counts['easy']}      | [View](easy/README.md) |
| Medium     | {counts['medium']}      | [View](medium/README.md) |
| Hard       | {counts['hard']}      | [View](hard/README.md) |
| **Total**  | **{total}**  | |"""

    if tags:
        topics_list = "\n".join(f"- {topic}" for topic in sorted(tags))
    else:
        topics_list = "_No topics yet. Add problems to see topics here._"

    readme = f"""# LeetCode Problems

Personal collection of LeetCode problem solutions with detailed approaches and explanations.

## Progress

{progress}

## Topics Covered

{topics_list}

## Quick Start

### Add a New Problem

```bash
python scripts/new_problem.py <number> <slug> <difficulty>

# Examples:
python scripts/new_problem.py 1 two-sum easy
python scripts/new_problem.py 347 top-k-frequent-elements medium
python scripts/new_problem.py 42 trapping-rain-water hard
```

### Push Changes

```bash
python scripts/push.py
```

This will:
1. Detect added/modified problems
2. Auto-update all READMEs
3. Generate commit message
4. Commit and push

## Repository Structure

```
leetcode-problems/
├── README.md                 # This file (stats & topics)
├── scripts/
│   ├── new_problem.py        # Create new problem folder
│   ├── update_readme.py      # Auto-generate READMEs
│   └── push.py               # Auto-commit and push
├── easy/
│   ├── README.md             # Easy problems table
│   └── <number>-<slug>/
│       ├── problem.md
│       ├── approach.md
│       ├── solution.py
│       └── solution.java
├── medium/
│   ├── README.md             # Medium problems table
│   └── ...
└── hard/
    ├── README.md             # Hard problems table
    └── ...
```

## File Conventions

Each problem folder contains:

| File | Purpose |
|------|---------|
| `problem.md` | Problem statement, examples, constraints |
| `approach.md` | Intuition, approach, complexity, edge cases |
| `solution.py` | Python implementation |
| `solution.java` | Java implementation |

### approach.md Format

```markdown
# Approach

**Tags:** `Array`, `Hash Table`, `Two Pointers`

## Intuition
## Solution
## Complexity
## Edge Cases
```

Tags are auto-parsed and displayed in the problem tables.
"""
    
    return readme


def generate_difficulty_readme(difficulty: str, problems: list, total_count: int) -> str:
    """Generate README for a specific difficulty folder."""
    diff_title = difficulty.capitalize()
    
    if problems:
        table_rows = []
        for p in problems:
            tags_str = ", ".join(f"`{t}`" for t in p["tags"]) if p["tags"] else "-"
            py_link = f"[✓]({p['number']}-{p['slug']}/solution.py)" if p["has_python"] else "-"
            java_link = f"[✓]({p['number']}-{p['slug']}/solution.java)" if p["has_java"] else "-"
            
            row = f"| {p['number']} | [{p['title']}]({p['number']}-{p['slug']}/problem.md) | {tags_str} | {py_link} | {java_link} |"
            table_rows.append(row)
        
        solutions_table = """| #   | Problem | Tags | Python | Java |
|-----|---------|------|--------|------|
""" + "\n".join(table_rows)
    else:
        solutions_table = """| #   | Problem | Tags | Python | Java |
|-----|---------|------|--------|------|
| -   | No problems yet | - | - | - |"""

    readme = f"""# {diff_title} Problems

[← Back to main README](../README.md)

**Total:** {len(problems)} problems

## Problems

{solutions_table}
"""
    
    return readme


def main():
    data = scan_problems()
    
    # Generate main README
    main_readme = generate_main_readme(data)
    (REPO_ROOT / "README.md").write_text(main_readme)
    
    # Generate difficulty READMEs
    for difficulty in DIFFICULTIES:
        diff_path = REPO_ROOT / difficulty
        diff_path.mkdir(exist_ok=True)
        
        problems = data["problems_by_difficulty"][difficulty]
        diff_readme = generate_difficulty_readme(difficulty, problems, data["counts"][difficulty])
        (diff_path / "README.md").write_text(diff_readme)
    
    # Remove .gitkeep files if README exists
    for difficulty in DIFFICULTIES:
        gitkeep = REPO_ROOT / difficulty / ".gitkeep"
        if gitkeep.exists():
            gitkeep.unlink()
    
    print(f"READMEs updated!")
    print(f"  Total: {data['total']} problems")
    print(f"  Easy: {data['counts']['easy']}, Medium: {data['counts']['medium']}, Hard: {data['counts']['hard']}")


if __name__ == "__main__":
    main()
