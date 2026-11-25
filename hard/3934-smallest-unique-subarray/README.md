# 3934. Smallest Unique Subarray

**Difficulty:** Hard  
**Topics:** `Array`, `Hash Table`, `Binary Search`  
**Complexity:** time O(n) expected, space O(n)

- **Write-up:** [yral.dev/leetcode/smallest-unique-subarray](https://yral.dev/leetcode/smallest-unique-subarray)
- **Problem:** [Smallest Unique Subarray on LeetCode](https://leetcode.com/problems/smallest-unique-subarray/)

## Idea

Extending a unique subarray keeps it unique, so "some subarray of length `L` is unique" is monotone in `L`. That gives the usual solution: binary search on `L` and count rolling hashes of every window, O(n log n), with some risk of hash collisions.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
