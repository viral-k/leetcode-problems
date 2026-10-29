# 1260. Shift 2D Grid

**Difficulty:** Easy  
**Topics:** `Array`, `Matrix`, `Simulation`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/shift-2d-grid](https://yral.dev/leetcode/shift-2d-grid)
- **Problem:** [Shift 2D Grid on LeetCode](https://leetcode.com/problems/shift-2d-grid/)

## Idea

The three shift rules together describe one simple thing: read the grid in **row-major order** and everything moves one step forward, wrapping from the last cell back to the first. So the 2D shift is just a **right rotation of the flattened 1D array**, and applying it `k` times is a rotation by `k`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
