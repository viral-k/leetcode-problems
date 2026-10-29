# 3345. Smallest Divisible Digit Product I

**Difficulty:** Easy  
**Topics:** `Math`, `Enumeration`, `Simulation`  
**Complexity:** time O(A * d), space O(1)

- **Write-up:** [yral.dev/leetcode/smallest-divisible-digit-product-i](https://yral.dev/leetcode/smallest-divisible-digit-product-i)
- **Problem:** [Smallest Divisible Digit Product I on LeetCode](https://leetcode.com/problems/smallest-divisible-digit-product-i/)

## Idea

With `n <= 100` and `t <= 10`, just scan upward from `n` and return the first number whose digit product is divisible by `t`. The search is guaranteed short: any number containing a `0` digit has digit product `0`, which is divisible by every `t`, and such numbers (e.g. the next multiple of 10) are never far away.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
