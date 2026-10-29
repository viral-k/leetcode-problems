# 1914. Cyclically Rotating a Grid

**Difficulty:** Medium  
**Topics:** `Array`, `Matrix`, `Simulation`  
**Complexity:** time O(m × n), space O(m + n)

- **Write-up:** [yral.dev/leetcode/cyclically-rotating-a-grid](https://yral.dev/leetcode/cyclically-rotating-a-grid)
- **Problem:** [Cyclically Rotating a Grid on LeetCode](https://leetcode.com/problems/cyclically-rotating-a-grid/)

## Idea

Each layer is an independent cycle. If we list a layer's cells around the border, one rotation moves each value into the adjacent cell in the counter-clockwise direction. With the coordinate order used below, the value written at position `i` should come from position `(i - k) % length`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
