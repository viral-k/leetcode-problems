#!/usr/bin/env python3
"""
Create a new problem folder with template files.

Usage:
    python scripts/new_problem.py <number> <slug> <difficulty>
    python scripts/new_problem.py 347 top-k-frequent-elements medium
    python scripts/new_problem.py 1 two-sum easy
"""

import sys
import shutil
from pathlib import Path

REPO_ROOT = Path(__file__).parent.parent
TEMPLATES_DIR = REPO_ROOT / "_templates"
VALID_DIFFICULTIES = {"easy", "medium", "hard"}


def create_problem(number: str, slug: str, difficulty: str) -> None:
    difficulty = difficulty.lower()
    
    if difficulty not in VALID_DIFFICULTIES:
        print(f"Error: difficulty must be one of {VALID_DIFFICULTIES}")
        sys.exit(1)
    
    # Normalize slug
    slug = slug.lower().replace(" ", "-").replace("_", "-")
    
    # Zero-pad number for sorting (001, 002, etc. for < 1000)
    number = str(int(number)).zfill(3) if int(number) < 1000 else str(int(number))
    
    folder_name = f"{number}-{slug}"
    folder_path = REPO_ROOT / difficulty / folder_name
    
    if folder_path.exists():
        print(f"Error: {folder_path} already exists")
        sys.exit(1)
    
    folder_path.mkdir(parents=True, exist_ok=True)
    
    # Copy and customize templates
    title = slug.replace("-", " ").title()
    leetcode_url = f"https://leetcode.com/problems/{slug}/"
    
    # problem.md
    problem_content = f"""# {title}

**Difficulty:** {difficulty.capitalize()}  
**LeetCode Link:** [{title}]({leetcode_url})

## Description

<!-- Copy problem description here -->

## Examples

### Example 1
```
Input: 
Output: 
Explanation: 
```

### Example 2
```
Input: 
Output: 
```

## Constraints

- 
"""
    (folder_path / "problem.md").write_text(problem_content)
    
    # approach.md
    approach_content = f"""# Approach

**Tags:** ``, ``

## Intuition

<!-- What's the first thought when you see this problem? -->

## Approach

<!-- Step-by-step explanation -->

## Complexity

- **Time:** O()
- **Space:** O()

## Edge Cases

- 
"""
    (folder_path / "approach.md").write_text(approach_content)
    
    # solution.py
    python_content = f'''from typing import List


class Solution:
    def solve(self):
        """
        {number}. {title}
        Time: O()
        Space: O()
        """
        pass
'''
    (folder_path / "solution.py").write_text(python_content)
    
    # solution.java
    java_content = f"""/**
 * {number}. {title}
 * Time: O()
 * Space: O()
 */
class Solution {{
    public void solve() {{
        
    }}
}}
"""
    (folder_path / "solution.java").write_text(java_content)
    
    print(f"Created: {folder_path}")
    print(f"  - problem.md")
    print(f"  - approach.md")
    print(f"  - solution.py")
    print(f"  - solution.java")
    print(f"\nLeetCode: {leetcode_url}")


def main():
    if len(sys.argv) != 4:
        print("Usage: python scripts/new_problem.py <number> <slug> <difficulty>")
        print("Example: python scripts/new_problem.py 347 top-k-frequent-elements medium")
        sys.exit(1)
    
    number = sys.argv[1]
    slug = sys.argv[2]
    difficulty = sys.argv[3]
    
    create_problem(number, slug, difficulty)


if __name__ == "__main__":
    main()
