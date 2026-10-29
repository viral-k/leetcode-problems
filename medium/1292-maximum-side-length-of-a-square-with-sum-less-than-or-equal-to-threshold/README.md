# 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

**Difficulty:** Medium  
**Topics:** `Array`, `Binary Search`, `Matrix`, `Prefix Sum`  
**Complexity:** time O(m × n × log(min(m, n))), space O(m × n)

- **Write-up:** [yral.dev/leetcode/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold](https://yral.dev/leetcode/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold)
- **Problem:** [Maximum Side Length of a Square with Sum Less than or Equal to Threshold on LeetCode](https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/)

## Idea

Use 2D prefix sum to compute any submatrix sum in O(1). Binary search on the side length since if a square of size L works, all smaller squares also work (monotonic property).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
