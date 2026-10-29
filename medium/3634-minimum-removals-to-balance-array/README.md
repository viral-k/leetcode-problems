# 3634. Minimum Removals to Balance Array

**Difficulty:** Medium  
**Topics:** `Array`, `Sorting`, `Two Pointers`, `Sliding Window`  
**Complexity:** time O(n log n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-removals-to-balance-array](https://yral.dev/leetcode/minimum-removals-to-balance-array)
- **Problem:** [Minimum Removals to Balance Array on LeetCode](https://leetcode.com/problems/minimum-removals-to-balance-array/)

## Idea

After sorting, we need the longest contiguous subarray where `max <= min * k`. Since array is sorted, max is the rightmost element and min is the leftmost. Use two pointers to find the longest valid window.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
