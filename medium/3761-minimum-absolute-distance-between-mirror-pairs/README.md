# 3761. Minimum Absolute Distance Between Mirror Pairs

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/minimum-absolute-distance-between-mirror-pairs](https://yral.dev/leetcode/minimum-absolute-distance-between-mirror-pairs)
- **Problem:** [Minimum Absolute Distance Between Mirror Pairs on LeetCode](https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/)

## Idea

For a mirror pair (i, j) with i < j, we need `reverse(nums[i]) == nums[j]`. Process right to left, tracking the smallest index for each value seen so far.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
