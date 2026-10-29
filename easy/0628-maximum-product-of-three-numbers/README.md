# 628. Maximum Product of Three Numbers

**Difficulty:** Easy  
**Topics:** `Array`, `Math`, `Sorting`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-product-of-three-numbers](https://yral.dev/leetcode/maximum-product-of-three-numbers)
- **Problem:** [Maximum Product of Three Numbers on LeetCode](https://leetcode.com/problems/maximum-product-of-three-numbers/)

## Idea

If all numbers were non-negative, the answer would just be the three largest. But negatives flip the game: the product of the **two most negative** values is a large positive, which paired with the largest value can beat the top three. So exactly two candidates need comparing:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
