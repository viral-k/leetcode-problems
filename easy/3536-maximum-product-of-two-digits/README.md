# 3536. Maximum Product of Two Digits

**Difficulty:** Easy  
**Topics:** `Math`, `Greedy`  
**Complexity:** time O(d), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-product-of-two-digits](https://yral.dev/leetcode/maximum-product-of-two-digits)
- **Problem:** [Maximum Product of Two Digits on LeetCode](https://leetcode.com/problems/maximum-product-of-two-digits/)

## Idea

Digits are non-negative, so the largest product of any two of them is simply the product of the two largest digits (using the same position isn't allowed, but a repeated *value* is — and tracking the top two by value handles that automatically since `n >= 10` guarantees at least two digits).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
