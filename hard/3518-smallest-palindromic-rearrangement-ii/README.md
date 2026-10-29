# 3518. Smallest Palindromic Rearrangement II

**Difficulty:** Hard  
**Topics:** `String`, `Combinatorics`, `Greedy`, `Counting`, `Math`  
**Complexity:** time O(L * 26)  (capped permutation counts short-circuit), space O(26 + n)

- **Write-up:** [yral.dev/leetcode/smallest-palindromic-rearrangement-ii](https://yral.dev/leetcode/smallest-palindromic-rearrangement-ii)
- **Problem:** [Smallest Palindromic Rearrangement II on LeetCode](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/)

## Idea

A palindrome is fully determined by its **left half** plus a fixed middle character (the one with an odd count, if any). Two palindromes compare lexicographically exactly as their left halves do, since the left half is a prefix. So "k-th smallest palindrome" is precisely "k-th smallest permutation of the left-half multiset", where each character contributes `count // 2` copies.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
