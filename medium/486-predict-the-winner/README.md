# 486. Predict the Winner

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`, `Recursion`, `Game Theory`, `Interval DP`  
**Complexity:** time O(n^2), space O(n)

- **Write-up:** [yral.dev/leetcode/predict-the-winner](https://yral.dev/leetcode/predict-the-winner)
- **Problem:** [Predict the Winner on LeetCode](https://leetcode.com/problems/predict-the-winner/)

## Idea

Instead of tracking two separate scores, track the **difference** between the current player's score and the opponent's on each subarray. Whatever the current player takes, the roles then flip, so the opponent's optimal difference on the remaining subarray is *subtracted* from the taken value. Maximizing this difference on the full array tells us whether player 1 comes out non-negative (a win or tie).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
