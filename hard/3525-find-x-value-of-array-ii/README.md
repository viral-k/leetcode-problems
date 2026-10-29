# 3525. Find X Value of Array II

**Difficulty:** Hard  
**Topics:** `Array`, `Math`, `Segment Tree`  
**Complexity:** time O((n + q) * k * log n), space O(n * k)

- **Write-up:** [yral.dev/leetcode/find-x-value-of-array-ii](https://yral.dev/leetcode/find-x-value-of-array-ii)
- **Problem:** [Find X Value of Array II on LeetCode](https://leetcode.com/problems/find-x-value-of-array-ii/)

## Idea

After dropping the prefix, the remaining choices are the non-empty prefixes of `nums[start..]`. So each query asks: among prefixes of a suffix of the array, how many have product `≡ x (mod k)`? With point updates mixed in, that calls for a structure whose segments can be merged.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
