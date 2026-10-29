# 44. Wildcard Matching

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`, `Greedy`, `Recursion`  
**Complexity:** time O(m * n), space O(n)

- **Write-up:** [yral.dev/leetcode/wildcard-matching](https://yral.dev/leetcode/wildcard-matching)
- **Problem:** [Wildcard Matching on LeetCode](https://leetcode.com/problems/wildcard-matching/)

## Idea

Match prefixes against prefixes. The state "does `s[:i]` match `p[:j]`" is enough, because every pattern character either consumes exactly one character of `s` (a letter or `?`) or, in the case of `*`, may consume any number.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
