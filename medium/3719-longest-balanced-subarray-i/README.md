# 3719. Longest Balanced Subarray I

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Brute Force`  
**Complexity:** time O(n²), space O(n)

- **Write-up:** [yral.dev/leetcode/longest-balanced-subarray-i](https://yral.dev/leetcode/longest-balanced-subarray-i)
- **Problem:** [Longest Balanced Subarray I on LeetCode](https://leetcode.com/problems/longest-balanced-subarray-i/)

## Idea

For each starting index, expand the subarray while tracking distinct even and odd numbers. When counts are equal, we have a balanced subarray.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
