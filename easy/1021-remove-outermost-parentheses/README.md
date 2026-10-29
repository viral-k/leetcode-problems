# 1021. Remove Outermost Parentheses

**Difficulty:** Easy  
**Topics:** `String`, `Stack`  
**Complexity:** time O(n), space O(n) for the output, O(1) beyond it

- **Write-up:** [yral.dev/leetcode/remove-outermost-parentheses](https://yral.dev/leetcode/remove-outermost-parentheses)
- **Problem:** [Remove Outermost Parentheses on LeetCode](https://leetcode.com/problems/remove-outermost-parentheses/)

## Idea

The primitive decomposition never has to be built. A primitive piece is exactly a stretch that starts when the running depth leaves 0 and ends when it returns to 0, because that is precisely when the prefix so far is balanced and cannot be split further. So the brackets to drop are the ones straddling depth 0: the `(` that moves the depth from 0 to 1, and the `)` that moves it from 1 back to 0.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
