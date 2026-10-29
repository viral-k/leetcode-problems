# 3742. Maximum Path Score in a Grid

**Difficulty:** Medium  
**Topics:** `Array`, `Matrix`, `Dynamic Programming`  
**Complexity:** time O(m * n * min(k, m + n - 1)), space O(n * min(k, m + n - 1))  -- rolling rows

- **Write-up:** [yral.dev/leetcode/maximum-path-score-in-a-grid](https://yral.dev/leetcode/maximum-path-score-in-a-grid)
- **Problem:** [Maximum Path Score in a Grid on LeetCode](https://leetcode.com/problems/maximum-path-score-in-a-grid/)

## Idea

Grid DP with one extra dimension for the cost budget. A 2D `dp[i][j]` is insufficient: the budget couples decisions across the path, so we must track how much cost has been spent so far. Per cell, cost is binary (`0` if value `0`, else `1`) and score is the cell value.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
