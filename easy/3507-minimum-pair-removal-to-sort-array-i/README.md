# 3507. Minimum Pair Removal to Sort Array I

**Difficulty:** Easy  
**Topics:** `Array`, `Simulation`, `Greedy`  
**Complexity:** time O(n³), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-pair-removal-to-sort-array-i](https://yral.dev/leetcode/minimum-pair-removal-to-sort-array-i)
- **Problem:** [Minimum Pair Removal to Sort Array I on LeetCode](https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/)

## Idea

Simulate the process: repeatedly find the adjacent pair with minimum sum, merge them, and count operations until the array is non-decreasing.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
