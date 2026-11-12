# 3105. Longest Strictly Increasing or Strictly Decreasing Subarray

**Difficulty:** Easy  
**Topics:** `Array`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/longest-strictly-increasing-or-strictly-decreasing-subarray](https://yral.dev/leetcode/longest-strictly-increasing-or-strictly-decreasing-subarray)
- **Problem:** [Longest Strictly Increasing or Strictly Decreasing Subarray on LeetCode](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/)

## Idea

A strictly increasing subarray ending at `i` extends the one ending at `i - 1` exactly when `nums[i] > nums[i - 1]`; otherwise it starts over at length 1. The same holds for decreasing with `<`. So two running lengths are enough, and the answer is the largest value either one ever reaches.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
