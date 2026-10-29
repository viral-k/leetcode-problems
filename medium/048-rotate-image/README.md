# 48. Rotate Image

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Matrix`  
**Complexity:** time O(n²), space O(1)

- **Write-up:** [yral.dev/leetcode/rotate-image](https://yral.dev/leetcode/rotate-image)
- **Problem:** [Rotate Image on LeetCode](https://leetcode.com/problems/rotate-image/)

## Idea

A clockwise rotation moves each value from `(row, col)` to `(col, n - 1 - row)`. Instead of creating another matrix, we can get the same final layout with two in-place operations:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
