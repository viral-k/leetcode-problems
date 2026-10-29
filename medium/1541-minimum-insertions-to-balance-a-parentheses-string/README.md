# 1541. Minimum Insertions to Balance a Parentheses String

**Difficulty:** Medium  
**Topics:** `String`, `Stack`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-insertions-to-balance-a-parentheses-string](https://yral.dev/leetcode/minimum-insertions-to-balance-a-parentheses-string)
- **Problem:** [Minimum Insertions to Balance a Parentheses String on LeetCode](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)

## Idea

The grammar is the usual one with a twist: a closer is `))`, two characters wide, while an opener is one. So the scan has to think in terms of closers rather than individual `)`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
