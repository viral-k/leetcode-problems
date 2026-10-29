# 1340. Jump Game V

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `DFS`, `Memoization`  
**Complexity:** time O(n * d), space O(n)

- **Write-up:** [yral.dev/leetcode/jump-game-v](https://yral.dev/leetcode/jump-game-v)
- **Problem:** [Jump Game V on LeetCode](https://leetcode.com/problems/jump-game-v/)

## Idea

Think of each index as a node. From an index, we can move only to lower values, and a jump direction is blocked as soon as we meet an equal or higher value.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
