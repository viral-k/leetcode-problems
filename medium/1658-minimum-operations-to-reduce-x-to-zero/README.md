# 1658. Minimum Operations to Reduce X to Zero

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Binary Search`, `Sliding Window`, `Prefix Sum`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-operations-to-reduce-x-to-zero](https://yral.dev/leetcode/minimum-operations-to-reduce-x-to-zero)
- **Problem:** [Minimum Operations to Reduce X to Zero on LeetCode](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)

## Idea

The elements removed are always some prefix plus some disjoint suffix, and their order does not matter to the total. So the question is which prefix/suffix pair sums to `x`, and among those, which uses the fewest elements. What is left behind is a contiguous middle subarray summing to `total - x`. Fewest removals means longest middle, so the problem flips into: find the longest subarray with sum exactly `total - x`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
