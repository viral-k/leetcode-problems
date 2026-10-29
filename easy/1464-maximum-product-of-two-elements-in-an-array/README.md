# 1464. Maximum Product of Two Elements in an Array

**Difficulty:** Easy  
**Topics:** `Array`, `Math`, `Sorting`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-product-of-two-elements-in-an-array](https://yral.dev/leetcode/maximum-product-of-two-elements-in-an-array)
- **Problem:** [Maximum Product of Two Elements in an Array on LeetCode](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)

## Idea

Every value is at least 1, so `nums[i] - 1 >= 0` — no negatives to worry about. The product `(x-1)(y-1)` of two non-negative terms is maximized by taking the two largest values. Two different indices are required, but tracking the top two by value (with the second-largest allowed to equal the largest when it appears twice) handles that.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
