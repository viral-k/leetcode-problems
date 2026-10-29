# 52. N-Queens II

**Difficulty:** Hard  
**Topics:** `Backtracking`, `Bit Manipulation`, `Recursion`  
**Complexity:** time O(n!), space O(n)

- **Write-up:** [yral.dev/leetcode/n-queens-ii](https://yral.dev/leetcode/n-queens-ii)
- **Problem:** [N-Queens II on LeetCode](https://leetcode.com/problems/n-queens-ii/)

## Idea

Identical search to N-Queens (problem 51) — place one queen per row, so rows never conflict and only column and diagonal attacks need checking — but here only the **count** matters, so no board is ever built.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
