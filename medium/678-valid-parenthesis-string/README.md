# 678. Valid Parenthesis String

**Difficulty:** Medium  
**Topics:** `String`, `Dynamic Programming`, `Stack`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/valid-parenthesis-string](https://yral.dev/leetcode/valid-parenthesis-string)
- **Problem:** [Valid Parenthesis String on LeetCode](https://leetcode.com/problems/valid-parenthesis-string/)

## Idea

Without wildcards, a single running balance decides validity. With `'*'` the balance is no longer one number but a set of possible numbers, since each wildcard independently adds 1, subtracts 1, or does nothing.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
