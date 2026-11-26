# 3360. Stone Removal Game

**Difficulty:** Easy  
**Topics:** `Math`, `Simulation`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/stone-removal-game](https://yral.dev/leetcode/stone-removal-game)
- **Problem:** [Stone Removal Game on LeetCode](https://leetcode.com/problems/stone-removal-game/)

## Idea

Nobody makes a choice in this game. The amounts are fixed (10 for Alice, then 9, 8, 7 and so on), so all that matters is how many of those moves fit in the pile. The player who faces a move that doesn't fit loses. If an odd number of moves was made, Alice made the last one and Bob is stuck, so Alice wins.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
