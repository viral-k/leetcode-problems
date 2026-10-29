# 1254. Number of Closed Islands

**Difficulty:** Medium  
**Topics:** `Array`, `Depth-First Search`, `Breadth-First Search`, `Matrix`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/number-of-closed-islands](https://yral.dev/leetcode/number-of-closed-islands)
- **Problem:** [Number of Closed Islands on LeetCode](https://leetcode.com/problems/number-of-closed-islands/)

## Idea

An island is closed exactly when none of its cells is on the grid border. A
cell on the border has open space beyond the grid on at least one side, so its
island cannot be surrounded. An island with no border cell is, by maximality,
bounded on every side by water: any land neighbour would belong to the island.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
