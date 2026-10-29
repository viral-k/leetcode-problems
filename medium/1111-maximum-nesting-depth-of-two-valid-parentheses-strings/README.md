# 1111. Maximum Nesting Depth of Two Valid Parentheses Strings

**Difficulty:** Medium  
**Topics:** `String`, `Stack`, `Greedy`  
**Complexity:** time O(n), space O(1) beyond the output

- **Write-up:** [yral.dev/leetcode/maximum-nesting-depth-of-two-valid-parentheses-strings](https://yral.dev/leetcode/maximum-nesting-depth-of-two-valid-parentheses-strings)
- **Problem:** [Maximum Nesting Depth of Two Valid Parentheses Strings on LeetCode](https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/)

## Idea

Start from the lower bound. If `seq` has depth `D`, there is a moment when `D` brackets are simultaneously open. Every one of them must go to `A` or to `B`, and whichever group receives more of them is nested at least `ceil(D/2)` deep. So no split can beat `ceil(D/2)`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
