# 2943. Maximize Area of Square Hole in Grid

**Difficulty:** Medium  
**Topics:** `Array`, `Sorting`, `Greedy`  
**Complexity:** time O(h log h + v log v), space O(1)

- **Write-up:** [yral.dev/leetcode/maximize-area-of-square-hole-in-grid](https://yral.dev/leetcode/maximize-area-of-square-hole-in-grid)
- **Problem:** [Maximize Area of Square Hole in Grid on LeetCode](https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/)

## Idea

To maximize the square hole area, we need to find the maximum gap we can create by removing consecutive bars in both horizontal and vertical directions. The key insight is that removing consecutive bars creates a larger gap than removing scattered bars.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
