# 2267. Check if There Is a Valid Parentheses String Path

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Matrix`, `Bit Manipulation`  
**Complexity:** time O(m * n * (m + n) / 64) with bitmask balances, space O(m * n)

- **Write-up:** [yral.dev/leetcode/check-if-there-is-a-valid-parentheses-string-path](https://yral.dev/leetcode/check-if-there-is-a-valid-parentheses-string-path)
- **Problem:** [Check if There Is a Valid Parentheses String Path on LeetCode](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/)

## Idea

A parentheses string is valid exactly when the running balance never drops below zero and ends at zero. That makes the balance the only thing a partial path needs to remember: two different paths reaching the same cell with the same balance are interchangeable for the rest of the journey. So the state is `(row, col, balance)`, and the question is whether balance 0 is reachable at the bottom-right cell.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
