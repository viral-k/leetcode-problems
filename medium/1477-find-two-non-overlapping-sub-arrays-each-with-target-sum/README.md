# 1477. Find Two Non-overlapping Sub-arrays Each with Target Sum

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Binary Search`, `Dynamic Programming`, `Sliding Window`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/find-two-non-overlapping-sub-arrays-each-with-target-sum](https://yral.dev/leetcode/find-two-non-overlapping-sub-arrays-each-with-target-sum)
- **Problem:** [Find Two Non-overlapping Sub-arrays Each with Target Sum on LeetCode](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)

## Idea

Every element is positive, so as the right end of a window moves right, the left end only ever needs to move right too. That means a single sliding window visits every subarray whose sum is exactly `target`, and for each right index there is at most one such subarray.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
