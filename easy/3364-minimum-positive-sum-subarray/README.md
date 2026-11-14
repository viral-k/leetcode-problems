# 3364. Minimum Positive Sum Subarray

**Difficulty:** Easy  
**Topics:** `Array`, `Sliding Window`, `Prefix Sum`  
**Complexity:** time O(n * r), from list inserts; the searches are O(log r), space O(n)

- **Write-up:** [yral.dev/leetcode/minimum-positive-sum-subarray](https://yral.dev/leetcode/minimum-positive-sum-subarray)
- **Problem:** [Minimum Positive Sum Subarray on LeetCode](https://leetcode.com/problems/minimum-positive-sum-subarray/)

## Idea

With prefix sums `P`, the subarray `nums[i..j-1]` sums to `P[j] - P[i]`, and its length is `j - i`. Fix the end `j`. The length constraint `l <= j - i <= r` means the start `i` must lie in `[j - r, j - l]`, and that range slides right by one as `j` grows.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
