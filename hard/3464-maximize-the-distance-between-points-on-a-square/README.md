# 3464. Maximize the Distance Between Points on a Square

**Difficulty:** Hard  
**Topics:** `Array`, `Binary Search`, `Greedy`  
**Complexity:** time O(n * k * log n * log(perimeter/k)), space O(n)

- **Write-up:** [yral.dev/leetcode/maximize-the-distance-between-points-on-a-square](https://yral.dev/leetcode/maximize-the-distance-between-points-on-a-square)
- **Problem:** [Maximize the Distance Between Points on a Square on LeetCode](https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/)

## Idea

Key insight: For points on a square boundary, Manhattan distance equals the minimum of clockwise and counter-clockwise perimeter distances.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
