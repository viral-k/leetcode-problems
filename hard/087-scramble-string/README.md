# 87. Scramble String

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`, `Recursion`, `Memoization`  
**Complexity:** time O(n^4), space O(n^3)

- **Write-up:** [yral.dev/leetcode/scramble-string](https://yral.dev/leetcode/scramble-string)
- **Problem:** [Scramble String on LeetCode](https://leetcode.com/problems/scramble-string/)

## Idea

The scrambling process is recursive by definition, so the natural question to ask is also recursive: given a substring of `s1` and a substring of `s2` of the same length, can the first scramble into the second?

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
