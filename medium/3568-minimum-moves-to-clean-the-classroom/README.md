# 3568. Minimum Moves to Clean the Classroom

**Difficulty:** Medium  
**Topics:** `Array`, `BFS`, `Bit Manipulation`, `Matrix`, `Graph`  
**Complexity:** time O(m * n * 2^L), space O(m * n * 2^L)

- **Write-up:** [yral.dev/leetcode/minimum-moves-to-clean-the-classroom](https://yral.dev/leetcode/minimum-moves-to-clean-the-classroom)
- **Problem:** [Minimum Moves to Clean the Classroom on LeetCode](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/)

## Idea

Position alone isn't a state here — revisiting a cell is often necessary (to detour through a reset area, or to reach litter from a different side). What actually determines the future is the triple **(position, which litter is collected, current energy)**. With at most 10 litter cells the collected set fits in a bitmask, so the state space is manageable.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
