# 1559. Detect Cycles in 2D Grid

**Difficulty:** Medium  
**Topics:** `Array`, `DFS`, `BFS`, `Union Find`, `Matrix`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/detect-cycles-in-2d-grid](https://yral.dev/leetcode/detect-cycles-in-2d-grid)
- **Problem:** [Detect Cycles in 2D Grid on LeetCode](https://leetcode.com/problems/detect-cycles-in-2d-grid/)

## Idea

Standard cycle detection in an undirected graph. A cycle exists if during DFS we reach a visited cell that is not our immediate parent.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
