# 1614. Maximum Nesting Depth of the Parentheses

**Difficulty:** Easy  
**Topics:** `String`, `Stack`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-nesting-depth-of-the-parentheses](https://yral.dev/leetcode/maximum-nesting-depth-of-the-parentheses)
- **Problem:** [Maximum Nesting Depth of the Parentheses on LeetCode](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/)

## Idea

Depth at any position is just the number of open brackets to its left minus the number of closed ones, so a single counter tracks it. The answer is the largest value the counter ever reaches. Since the input is guaranteed to be a valid parentheses string, brackets always match up and the counter can never dip below zero, which means an actual stack would only hold redundant information.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
