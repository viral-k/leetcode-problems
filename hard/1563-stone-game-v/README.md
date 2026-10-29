# 1563. Stone Game V

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Prefix Sum`, `Two Pointers`, `Game Theory`, `Interval DP`  
**Complexity:** time O(n^2), space O(n^2)

- **Write-up:** [yral.dev/leetcode/stone-game-v](https://yral.dev/leetcode/stone-game-v)
- **Problem:** [Stone Game V on LeetCode](https://leetcode.com/problems/stone-game-v/)

## Idea

Every round leaves Alice with a **contiguous subarray**, so the state is an interval. Let `dp[i][j]` = the maximum score obtainable starting from stones `i..j`. Splitting at `k` gives left sum `L` and right sum `R`; Bob discards the larger, so Alice gains the smaller side and continues on it. On a tie she picks whichever side is better.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
