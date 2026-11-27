# 3946. Maximum Number of Items from Sale I

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`, `Greedy`  
**Complexity:** time O(n * budget + F log F), F = max factor, space O(budget + F)

- **Write-up:** [yral.dev/leetcode/maximum-number-of-items-from-sale-i](https://yral.dev/leetcode/maximum-number-of-items-from-sale-i)
- **Problem:** [Maximum Number of Items from Sale I on LeetCode](https://leetcode.com/problems/maximum-number-of-items-from-sale-i/)

## Idea

Buying an item type `i` for the first time is worth `1 + g_i` copies, where `g_i` is the number of other items whose factor is a multiple of `factor_i`. Every further copy of `i` is worth exactly `1`. So the purchase splits into two parts:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
