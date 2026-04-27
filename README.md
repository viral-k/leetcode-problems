# LeetCode Problems

Personal collection of LeetCode problem solutions with detailed approaches and explanations.

[![LeetCode](https://img.shields.io/badge/LeetCode-viras03-orange?logo=leetcode)](https://leetcode.com/u/viras03/)

## Progress

| Difficulty | Solved | Problems |
|------------|--------|----------|
| Easy       | 13      | [View](easy/README.md) |
| Medium     | 28      | [View](medium/README.md) |
| Hard       | 7      | [View](hard/README.md) |
| **Total**  | **48**  | |

## Topics Covered

`Array` `BFS` `Binary Search` `Bit Manipulation` `Brute Force` `Bucket Sort` `Counting Sort` `DFS` `Design` `Dynamic Programming` `Geometry` `Greedy` `Hash Table` `Math` `Matrix` `Prefix Sum` `Recursion` `Segment Tree` `Simulation` `Sliding Window` `Sorting` `Sqrt Decomposition` `Stack` `String` `Tree` `Two Pointers` `Union Find`

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
