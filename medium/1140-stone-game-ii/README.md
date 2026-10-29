# 1140. Stone Game II

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`, `Prefix Sum`, `Game Theory`, `Memoization`  
**Complexity:** time O(n^3), space O(n^2)

- **Write-up:** [yral.dev/leetcode/stone-game-ii](https://yral.dev/leetcode/stone-game-ii)
- **Problem:** [Stone Game II on LeetCode](https://leetcode.com/problems/stone-game-ii/)

## Idea

Piles are always taken from the front, so the remaining game is fully described by two things: the current index `i` and the current `M`. Rather than tracking both players' totals, note that whatever the current player does *not* take from the suffix, the opponent (playing optimally on the rest) will secure. So:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
