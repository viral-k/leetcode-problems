# 2492. Minimum Score of a Path Between Two Cities

**Difficulty:** Medium  
**Topics:** `BFS`, `DFS`, `Union Find`, `Graph`  
**Complexity:** time O(n + m), space O(n + m)

- **Write-up:** [yral.dev/leetcode/minimum-score-of-a-path-between-two-cities](https://yral.dev/leetcode/minimum-score-of-a-path-between-two-cities)
- **Problem:** [Minimum Score of a Path Between Two Cities on LeetCode](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/)

## Idea

The scoring rule plus the freedom to reuse roads and revisit cities changes the problem completely. A path's score is its **minimum** edge, and since you can wander anywhere in the connected component and backtrack, any road in city 1's component can be included in *some* path from 1 to `n` (walk to that road, cross it, return, then head to `n`). City `n` is guaranteed to be in the same component.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
