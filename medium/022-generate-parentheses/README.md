# 22. Generate Parentheses

**Difficulty:** Medium  
**Topics:** `String`, `Dynamic Programming`, `Backtracking`  
**Complexity:** time O(C(n) * n) where C(n) is the nth Catalan number, space O(n) excluding the output

- **Write-up:** [yral.dev/leetcode/generate-parentheses](https://yral.dev/leetcode/generate-parentheses)
- **Problem:** [Generate Parentheses on LeetCode](https://leetcode.com/problems/generate-parentheses/)

## Idea

Generating all `2^(2n)` strings and filtering the valid ones wastes almost all of the work. Instead build the string one character at a time and only ever place a character that keeps it extendable to a valid string. Two counters are enough: how many `(` have been placed and how many `)`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
