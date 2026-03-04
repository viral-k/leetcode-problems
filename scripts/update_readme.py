#!/usr/bin/env python3
"""
Auto-generates README.md from folder structure.
Run after adding a new problem.
"""

import os
import re
from pathlib import Path
from collections import defaultdict

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
        # Remove common suffixes
        title = re.sub(r"\s*\(.*\)\s*$", "", title)
        return title
    return ""


def scan_problems() -> dict:
    """Scan all problem folders and collect metadata."""
    problems = []
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
            
            problems.append({
                "number": number,
                "slug": slug,
                "title": title,
                "difficulty": difficulty.capitalize(),
                "tags": tags,
                "has_python": solution_py.exists(),
                "has_java": solution_java.exists(),
            })
            
            counts[difficulty] += 1
    
    return {
        "problems": problems,
        "tags": sorted(all_tags),
        "counts": counts,
        "total": sum(counts.values()),
    }


def generate_readme(data: dict) -> str:
    """Generate README content."""
    counts = data["counts"]
    total = data["total"]
    problems = data["problems"]
    tags = data["tags"]
    
    # Progress table
    progress = f"""| Difficulty | Solved |
|------------|--------|
| Easy       | {counts['easy']}      |
| Medium     | {counts['medium']}      |
| Hard       | {counts['hard']}      |
| **Total**  | **{total}**  |"""

    # Topics (only show tags that are actually used in problems)
    if tags:
        topics_list = "\n".join(f"- {topic}" for topic in sorted(tags))
    else:
        topics_list = "_No topics yet. Add problems to see topics here._"
    
    # Solutions table
    if problems:
        table_rows = []
        for p in problems:
            tags_str = ", ".join(f"`{t}`" for t in p["tags"]) if p["tags"] else "-"
            py_link = f"[✓]({p['difficulty'].lower()}/{p['number']}-{p['slug']}/solution.py)" if p["has_python"] else "-"
            java_link = f"[✓]({p['difficulty'].lower()}/{p['number']}-{p['slug']}/solution.java)" if p["has_java"] else "-"
            
            row = f"| {p['number']} | {p['title']} | {p['difficulty']} | {tags_str} | {py_link} | {java_link} |"
            table_rows.append(row)
        
        solutions_table = """| #   | Problem | Difficulty | Tags | Python | Java |
|-----|---------|------------|------|--------|------|
""" + "\n".join(table_rows)
    else:
        solutions_table = """| #   | Problem | Difficulty | Tags | Python | Java |
|-----|---------|------------|------|--------|------|
| -   | -       | -          | -    | -      | -    |"""

    readme = f"""# LeetCode Problems

Personal collection of LeetCode problem solutions with detailed approaches and explanations.

## Progress

{progress}

## Topics Covered

{topics_list}

## Solutions

{solutions_table}

## Repository Structure

```
leetcode-problems/
├── README.md
├── easy/
│   └── <number>-<problem-slug>/
│       ├── problem.md
│       ├── approach.md
│       ├── solution.py
│       └── solution.java
├── medium/
│   └── ...
└── hard/
    └── ...
```

## File Conventions

Each problem folder contains:
- `problem.md` - Problem statement and examples
- `approach.md` - Solution intuition, approach, complexity analysis, and edge cases
- `solution.py` - Python implementation
- `solution.java` - Java implementation
"""
    
    return readme


def main():
    data = scan_problems()
    readme_content = generate_readme(data)
    
    readme_path = REPO_ROOT / "README.md"
    readme_path.write_text(readme_content)
    
    print(f"README.md updated!")
    print(f"  Total: {data['total']} problems")
    print(f"  Easy: {data['counts']['easy']}, Medium: {data['counts']['medium']}, Hard: {data['counts']['hard']}")


if __name__ == "__main__":
    main()
