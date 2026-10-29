# 3517. Smallest Palindromic Rearrangement I

**Difficulty:** Medium  
**Topics:** `String`, `Greedy`, `Counting`, `Sorting`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/smallest-palindromic-rearrangement-i](https://yral.dev/leetcode/smallest-palindromic-rearrangement-i)
- **Problem:** [Smallest Palindromic Rearrangement I on LeetCode](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/)

## Idea

A palindrome is fully determined by its left half (and a possible middle character). Because `s` is already palindromic, every character count is even except at most one — exactly the condition needed to form a palindrome. To make the whole palindrome lexicographically smallest, make its **left half** as small as possible: place characters in ascending order, using half of each character's count. The right half is then forced (it must mirror the left), and the lone odd character sits in the middle.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
