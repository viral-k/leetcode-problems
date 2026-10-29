# 10. Regular Expression Matching

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`, `Recursion`, `Memoization`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/regular-expression-matching](https://yral.dev/leetcode/regular-expression-matching)
- **Problem:** [Regular Expression Matching on LeetCode](https://leetcode.com/problems/regular-expression-matching/)

## Idea

Match the two strings from the left, one decision at a time. The only real complication is `*`, because `x*` may consume any number of characters — including none — so at each `*` the pattern branches:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
