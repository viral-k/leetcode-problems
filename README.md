# LeetCode Problems

Personal collection of LeetCode problem solutions with detailed approaches and explanations.

[![LeetCode](https://img.shields.io/badge/LeetCode-yral--k-orange?logo=leetcode)](https://leetcode.com/u/yral-k/)

## Progress

| Difficulty | Solved | Problems |
|------------|--------|----------|
| Easy       | 32      | [View](easy/README.md) |
| Medium     | 75      | [View](medium/README.md) |
| Hard       | 32      | [View](hard/README.md) |
| **Total**  | **139**  | |

## Topics Covered

`Array` `BFS` `Binary Indexed Tree` `Binary Lifting` `Binary Search` `Binary Tree` `Bit Manipulation` `Brute Force` `Bucket Sort` `Combinatorics` `Counting` `Counting Sort` `DFS` `Depth-First Search` `Design` `Digit DP` `Divide and Conquer` `Dynamic Programming` `Enumeration` `Geometry` `Graph` `Greedy` `Hash Set` `Hash Table` `Heap (Priority Queue)` `Linked List` `Math` `Matrix` `Matrix Exponentiation` `Memoization` `Monotonic Stack` `Number Theory` `Prefix Maximum` `Prefix Minimum` `Prefix Sum` `Recursion` `Segment Tree` `Shell` `Shortest Path` `Simulation` `Sliding Window` `Sorting` `Sparse Table` `Sqrt Decomposition` `Stack` `String` `String Matching` `Suffix Minimum` `Topological Sort` `Tree` `Trie` `Two Pointers` `Union Find`

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
