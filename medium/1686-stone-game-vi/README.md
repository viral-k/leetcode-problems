# 1686. Stone Game VI

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Greedy`, `Sorting`, `Heap (Priority Queue)`, `Game Theory`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/stone-game-vi](https://yral.dev/leetcode/stone-game-vi)
- **Problem:** [Stone Game VI on LeetCode](https://leetcode.com/problems/stone-game-vi/)

## Idea

Taking a stone does two things at once: it **gains** you your own value for it, and it **denies** the opponent theirs. So the real importance of stone `i` — the swing in the final score difference — is `aliceValues[i] + bobValues[i]`, not either value alone.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
