# 3691. Maximum Total Subarray Value II

**Difficulty:** Hard  
**Topics:** `Array`, `Heap (Priority Queue)`, `Sparse Table`  
**Complexity:** time O(n log n + k log k), space O(n log n + k)

- **Write-up:** [yral.dev/leetcode/maximum-total-subarray-value-ii](https://yral.dev/leetcode/maximum-total-subarray-value-ii)
- **Problem:** [Maximum Total Subarray Value II on LeetCode](https://leetcode.com/problems/maximum-total-subarray-value-ii/)

## Idea

We want the `k` distinct subarrays with the largest values, then sum those values. The crucial structural fact: shrinking a subarray can never increase its value. Removing an element from either end can only lower the `max` or raise the `min`, so

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
