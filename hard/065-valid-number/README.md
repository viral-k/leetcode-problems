# 65. Valid Number

**Difficulty:** Hard  
**Topics:** `String`, `Simulation`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/valid-number](https://yral.dev/leetcode/valid-number)
- **Problem:** [Valid Number on LeetCode](https://leetcode.com/problems/valid-number/)

## Idea

The grammar looks fiddly, but every rule is **local** — whether a character is legal depends only on what has been seen so far, never on what comes later. That means one left-to-right scan carrying three booleans is enough, with no backtracking and no regex.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
