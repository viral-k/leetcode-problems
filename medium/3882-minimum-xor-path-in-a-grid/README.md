# 3882. Minimum XOR Path in a Grid

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`, `Bit Manipulation`, `Matrix`  
**Complexity:** time O(m * n * V), V = 1024, space O(n * V)

- **Write-up:** [yral.dev/leetcode/minimum-xor-path-in-a-grid](https://yral.dev/leetcode/minimum-xor-path-in-a-grid)
- **Problem:** [Minimum XOR Path in a Grid on LeetCode](https://leetcode.com/problems/minimum-xor-path-in-a-grid/)

## Idea

The normal minimum-path DP keeps one best value per cell. That fails for XOR,
because a larger value at one cell can become a smaller value later. For
example, `4 XOR 4 = 0` while `3 XOR 4 = 7`, so the path that was worse at the
earlier cell ends up better. Keeping only the minimum throws away the path that
would have won.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
