# 51. N-Queens

**Difficulty:** Hard  
**Topics:** `Array`, `Backtracking`, `Recursion`  
**Complexity:** time O(n!), space O(n) excluding the output

- **Write-up:** [yral.dev/leetcode/n-queens](https://yral.dev/leetcode/n-queens)
- **Problem:** [N-Queens on LeetCode](https://leetcode.com/problems/n-queens/)

## Idea

Two queens attack along a row, a column, or a diagonal. Placing **exactly one queen per row** satisfies the row constraint by construction, so the search only has to choose a column for each row — turning the board into a sequence of `n` decisions rather than `n^2` cell choices.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
