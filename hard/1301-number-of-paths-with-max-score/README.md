# 1301. Number of Paths with Max Score

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Matrix`  
**Complexity:** time O(n^2), space O(n^2)

- **Write-up:** [yral.dev/leetcode/number-of-paths-with-max-score](https://yral.dev/leetcode/number-of-paths-with-max-score)
- **Problem:** [Number of Paths with Max Score on LeetCode](https://leetcode.com/problems/number-of-paths-with-max-score/)

## Idea

Moves are up / left / up-left, so travelling from `S` (bottom-right) to `E` (top-left) always decreases a coordinate. That makes it a clean grid DP: a cell `(i, j)` can only be entered from `(i+1, j)`, `(i, j+1)`, or `(i+1, j+1)` — the three cells "below/right" of it. We want both the maximum collectable sum and how many distinct paths hit that maximum.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
