# 856. Score of Parentheses

**Difficulty:** Medium  
**Topics:** `String`, `Stack`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/score-of-parentheses](https://yral.dev/leetcode/score-of-parentheses)
- **Problem:** [Score of Parentheses on LeetCode](https://leetcode.com/problems/score-of-parentheses/)

## Idea

Unfold the two composition rules. `AB` adds, and `(A)` doubles, so the total score is a sum of contributions from the innermost `"()"` pairs, each weighted by how deeply it is nested. A core sitting inside `d` enclosing pairs has been doubled `d - 1` times, so it contributes `2^(d-1)` where `d` is its own depth.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
