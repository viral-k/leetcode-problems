# 2029. Stone Game IX

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Greedy`, `Counting`, `Game Theory`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/stone-game-ix](https://yral.dev/leetcode/stone-game-ix)
- **Problem:** [Stone Game IX on LeetCode](https://leetcode.com/problems/stone-game-ix/)

## Idea

Only each stone's value **mod 3** affects the game, so reduce the array to three counts: `c0`, `c1`, `c2` (stones ≡ 0, 1, 2 mod 3).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
