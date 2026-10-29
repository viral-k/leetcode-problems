# 3513. Number of Unique XOR Triplets I

**Difficulty:** Medium  
**Topics:** `Bit Manipulation`, `Math`, `Combinatorics`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/number-of-unique-xor-triplets-i](https://yral.dev/leetcode/number-of-unique-xor-triplets-i)
- **Problem:** [Number of Unique XOR Triplets I on LeetCode](https://leetcode.com/problems/number-of-unique-xor-triplets-i/)

## Idea

Because `nums` is a permutation of `{1, 2, ..., n}`, the multiset of available values is *always* exactly `{1..n}` — so the answer depends only on `n`, not on the ordering. And since indices may repeat (`i <= j <= k`), we can pick the same element twice: `x XOR x XOR k = k`, which already makes every single value `1..n` reachable.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
