# 3286. Find a Safe Walk Through a Grid

**Difficulty:** Medium  
**Topics:** `Array`, `BFS`, `Graph`, `Matrix`, `Shortest Path`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/find-a-safe-walk-through-a-grid](https://yral.dev/leetcode/find-a-safe-walk-through-a-grid)
- **Problem:** [Find a Safe Walk Through a Grid on LeetCode](https://leetcode.com/problems/find-a-safe-walk-through-a-grid/)

## Idea

Health only drops when you step onto an unsafe (`1`) cell, and each such cell costs exactly 1. So the health you have left at the end is `health` minus the number of `1`-cells on your path. To maximize surviving health, minimize the number of unsafe cells passed through — a shortest-path problem where entering a cell costs its grid value (0 or 1).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
