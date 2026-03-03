# LeetCode Problems

Personal collection of LeetCode problem solutions with detailed approaches and explanations.

## Progress

| Difficulty | Solved |
|------------|--------|
| Easy       | 0      |
| Medium     | 0      |
| Hard       | 0      |
| **Total**  | **0**  |

## Topics Covered

- Arrays
- Strings
- Linked Lists
- Trees
- Graphs
- Dynamic Programming
- Greedy
- Binary Search
- Two Pointers
- Sliding Window
- Stack/Queue
- Heap/Priority Queue
- Backtracking
- Bit Manipulation
- Math
- Segment Tree
- Trie

## Solutions

| #   | Problem | Difficulty | Tags | Python | Java |
|-----|---------|------------|------|--------|------|
| -   | -       | -          | -    | -      | -    |

## Quick Start

### Add a New Problem

```bash
python scripts/new_problem.py <number> <slug> <difficulty>

# Examples:
python scripts/new_problem.py 1 two-sum easy
python scripts/new_problem.py 347 top-k-frequent-elements medium
python scripts/new_problem.py 42 trapping-rain-water hard
```

This creates the folder structure with pre-filled templates.

### Push Changes

```bash
python scripts/push.py
```

This will:

1. Detect added/modified problems
2. Auto-update this README
3. Generate commit message (e.g., `Add 001. Two Sum (Easy)`)
4. Ask for confirmation
5. Commit and push

### Full Workflow

```bash
# 1. Create problem folder with templates
python scripts/new_problem.py 1 two-sum easy

# 2. Edit your solution files
#    - easy/001-two-sum/problem.md    (copy problem statement)
#    - easy/001-two-sum/approach.md   (write your approach + tags)
#    - easy/001-two-sum/solution.py   (your Python solution)
#    - easy/001-two-sum/solution.java (your Java solution)

# 3. Push (handles everything automatically)
python scripts/push.py
```

## Repository Structure

```
leetcode-problems/
├── README.md
├── scripts/
│   ├── new_problem.py    # Create new problem folder
│   ├── update_readme.py  # Auto-generate README from folders
│   └── push.py           # Auto-commit and push
├── _templates/           # Reference templates
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
## Approach
## Complexity
- **Time:** O(n)
- **Space:** O(1)
## Edge Cases
```

Tags are auto-parsed and displayed in the solutions table.

## Scripts Reference

| Script | Usage | Description |
|--------|-------|-------------|
| `new_problem.py` | `python scripts/new_problem.py 1 two-sum easy` | Create problem folder with templates |
| `update_readme.py` | `python scripts/update_readme.py` | Regenerate README from folder structure |
| `push.py` | `python scripts/push.py` | Auto-commit with generated message and push |
