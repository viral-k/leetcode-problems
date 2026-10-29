# 3047. Find the Largest Area of Square Inside Two Rectangles

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Geometry`  
**Complexity:** time O(n²), space O(1)

- **Write-up:** [yral.dev/leetcode/find-the-largest-area-of-square-inside-two-rectangles](https://yral.dev/leetcode/find-the-largest-area-of-square-inside-two-rectangles)
- **Problem:** [Find the Largest Area of Square Inside Two Rectangles on LeetCode](https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/)

## Idea

For each pair of rectangles, compute their intersection. If the intersection exists, the largest square that fits inside it has a side length equal to the minimum of the intersection's width and height.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
