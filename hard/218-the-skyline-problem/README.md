# 218. The Skyline Problem

**Difficulty:** Hard  
**Topics:** `Array`, `Divide and Conquer`, `Heap (Priority Queue)`, `Segment Tree`, `Binary Indexed Tree`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/the-skyline-problem](https://yral.dev/leetcode/the-skyline-problem)
- **Problem:** [The Skyline Problem on LeetCode](https://leetcode.com/problems/the-skyline-problem/)

## Idea

The skyline height at a given x is just the maximum height among the buildings
covering x. So the height function is piecewise constant, and a key point
appears precisely where that maximum changes. Nothing has to be drawn — sweep x
from left to right and watch the running maximum of a set that gains a building
at each left edge and loses one at each right edge.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
