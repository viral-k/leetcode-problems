# 3731. Find Missing Elements

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Sorting`  
**Complexity:** time O(n + R)  (R = max - min), space O(n)

- **Write-up:** [yral.dev/leetcode/find-missing-elements](https://yral.dev/leetcode/find-missing-elements)
- **Problem:** [Find Missing Elements on LeetCode](https://leetcode.com/problems/find-missing-elements/)

## Idea

The original range is exactly `[min(nums), max(nums)]` (endpoints are guaranteed present). Any value in that range not found in `nums` is missing.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
