# 3514. Number of Unique XOR Triplets II

**Difficulty:** Medium  
**Topics:** `Array`, `Bit Manipulation`, `Hash Table`, `Enumeration`  
**Complexity:** time O(D^2 + V * D)  (D = distinct values, V = 2048), space O(V)

- **Write-up:** [yral.dev/leetcode/number-of-unique-xor-triplets-ii](https://yral.dev/leetcode/number-of-unique-xor-triplets-ii)
- **Problem:** [Number of Unique XOR Triplets II on LeetCode](https://leetcode.com/problems/number-of-unique-xor-triplets-ii/)

## Idea

Unlike part I, `nums` is arbitrary, so we can't reduce to a closed-form on `n`. But the values are tiny: `nums[i] <= 1500 < 2048 = 2^11`, so **every XOR result fits in 11 bits** and there are at most 2048 distinct values anywhere in the computation. That bounds the whole search space and makes brute-forcing in two stages feasible.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
