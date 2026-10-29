# 2333. Minimum Sum of Squared Difference

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Binary Search`, `Sorting`, `Heap (Priority Queue)`, `Greedy`, `Counting`  
**Complexity:** time O(n + V) where V = max difference, space O(V)

- **Write-up:** [yral.dev/leetcode/minimum-sum-of-squared-difference](https://yral.dev/leetcode/minimum-sum-of-squared-difference)
- **Problem:** [Minimum Sum of Squared Difference on LeetCode](https://leetcode.com/problems/minimum-sum-of-squared-difference/)

## Idea

The pairing is fixed, so the only thing that matters about index `i` is the absolute difference `d[i] = |nums1[i] - nums2[i]|`. One operation on either array changes one `d[i]` by exactly 1, which means `k1` and `k2` are interchangeable and collapse into a single budget `k = k1 + k2`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
