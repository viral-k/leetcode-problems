# 301. Remove Invalid Parentheses

**Difficulty:** Hard  
**Topics:** `String`, `Backtracking`, `Breadth-First Search`  
**Complexity:** time O(product of run lengths), far below 2^p after the budget prunes, space O(n) recursion depth plus the output

- **Write-up:** [yral.dev/leetcode/remove-invalid-parentheses](https://yral.dev/leetcode/remove-invalid-parentheses)
- **Problem:** [Remove Invalid Parentheses on LeetCode](https://leetcode.com/problems/remove-invalid-parentheses/)

## Idea

Two separate questions hide in this problem: how many brackets must go, and which sets of that size work.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
