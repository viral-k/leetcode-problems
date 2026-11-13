# 3420. Count Non-Decreasing Subarrays After K Operations

**Difficulty:** Hard  
**Topics:** `Array`, `Stack`, `Segment Tree`, `Sliding Window`, `Monotonic Stack`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/count-non-decreasing-subarrays-after-k-operations](https://yral.dev/leetcode/count-non-decreasing-subarrays-after-k-operations)
- **Problem:** [Count Non-Decreasing Subarrays After K Operations on LeetCode](https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/)

## Idea

Operations only increase values, so the cheapest way to make a subarray non-decreasing is to raise each element to the largest value before it. The cost of `nums[l..r]` is `Σ (max(nums[l..i]) - nums[i])` for `i` in `l..r`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
