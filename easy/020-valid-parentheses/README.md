# 20. Valid Parentheses

**Difficulty:** Easy  
**Topics:** `String`, `Stack`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/valid-parentheses](https://yral.dev/leetcode/valid-parentheses)
- **Problem:** [Valid Parentheses on LeetCode](https://leetcode.com/problems/valid-parentheses/)

## Idea

Brackets must close in reverse order of opening, which is exactly last-in-first-out, so a stack is the natural structure. Push each opener. When a closer arrives, the only bracket it is allowed to match is the most recent unclosed opener, i.e. the top of the stack. If the top is the wrong type, or there is nothing on the stack at all, the string is invalid.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
