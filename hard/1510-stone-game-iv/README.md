# 1510. Stone Game IV

**Difficulty:** Hard  
**Topics:** `Math`, `Dynamic Programming`, `Game Theory`  
**Complexity:** time O(n * sqrt(n)), space O(n)

- **Write-up:** [yral.dev/leetcode/stone-game-iv](https://yral.dev/leetcode/stone-game-iv)
- **Problem:** [Stone Game IV on LeetCode](https://leetcode.com/problems/stone-game-iv/)

## Idea

This is a standard impartial win/lose game. A position with `i` stones is a **winning** position for the player to move if there exists *any* legal move leading to a **losing** position for the opponent. A position is losing if every move hands the opponent a win.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
