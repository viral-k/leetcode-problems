# 1406. Stone Game III

**Difficulty:** Hard  
**Topics:** `Array`, `Math`, `Dynamic Programming`, `Game Theory`, `Suffix Sum`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/stone-game-iii](https://yral.dev/leetcode/stone-game-iii)
- **Problem:** [Stone Game III on LeetCode](https://leetcode.com/problems/stone-game-iii/)

## Idea

Both players play the same suffix of the row (stones are always taken from the front), so the state is just "which index we start from". Tracking the **score difference** (current player minus opponent) collapses both scores into one value: after the current player grabs some stones, the opponent faces the remaining suffix and *their* optimal difference is subtracted.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
