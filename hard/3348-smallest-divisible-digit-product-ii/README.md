# 3348. Smallest Divisible Digit Product II

**Difficulty:** Hard  
**Topics:** `String`, `Greedy`, `Math`, `Number Theory`, `Enumeration`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/smallest-divisible-digit-product-ii](https://yral.dev/leetcode/smallest-divisible-digit-product-ii)
- **Problem:** [Smallest Divisible Digit Product II on LeetCode](https://leetcode.com/problems/smallest-divisible-digit-product-ii/)

## Idea

Digits `1..9` only carry the prime factors `2, 3, 5, 7`. So first strip those primes out of `t`; if anything remains, no digit product can ever be divisible by `t` → `"-1"`. What's left is a required exponent tuple `(a2, a3, a5, a7)` that the answer's digits must jointly supply.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
