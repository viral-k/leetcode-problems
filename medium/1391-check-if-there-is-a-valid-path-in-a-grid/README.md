# 1391. Check if There is a Valid Path in a Grid

**Difficulty:** Medium  
**Topics:** `Array`, `BFS`, `DFS`, `Matrix`, `Union Find`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/check-if-there-is-a-valid-path-in-a-grid](https://yral.dev/leetcode/check-if-there-is-a-valid-path-in-a-grid)
- **Problem:** [Check if There is a Valid Path in a Grid on LeetCode](https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/)

## Idea

BFS/DFS with connection validation. When moving between cells, both cells must have compatible street types that connect to each other.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
