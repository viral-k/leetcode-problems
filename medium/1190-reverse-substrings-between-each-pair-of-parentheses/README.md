# 1190. Reverse Substrings Between Each Pair of Parentheses

**Difficulty:** Medium  
**Topics:** `String`, `Stack`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/reverse-substrings-between-each-pair-of-parentheses](https://yral.dev/leetcode/reverse-substrings-between-each-pair-of-parentheses)
- **Problem:** [Reverse Substrings Between Each Pair of Parentheses on LeetCode](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/)

## Idea

The obvious solution keeps a stack of buffers, reversing and merging one on every `)`. That rebuilds the same characters over and over, so deeply nested input like `((((abc))))` costs O(n^2).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
