# 1846. Maximum Element After Decreasing and Rearranging

**Difficulty:** Medium  
**Topics:** `Array`, `Greedy`, `Sorting`  
**Complexity:** time O(n log n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-element-after-decreasing-and-rearranging](https://yral.dev/leetcode/maximum-element-after-decreasing-and-rearranging)
- **Problem:** [Maximum Element After Decreasing and Rearranging on LeetCode](https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/)

## Idea

We can only decrease values and reorder them, never increase. To make the maximum element as large as possible, we want the values to climb as steeply as the rules allow: start at 1 and go up by at most 1 each step. Sorting ascending lets every position contribute its full upward potential.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
