# 1401. Circle and Rectangle Overlapping

**Difficulty:** Medium  
**Topics:** `Math`, `Geometry`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/circle-and-rectangle-overlapping](https://yral.dev/leetcode/circle-and-rectangle-overlapping)
- **Problem:** [Circle and Rectangle Overlapping on LeetCode](https://leetcode.com/problems/circle-and-rectangle-overlapping/)

## Idea

A circle and a rectangle overlap exactly when the rectangle's nearest point to the circle's center lies inside the circle. For an axis-aligned rectangle the nearest point is easy: clamp the center's x into `[x1, x2]` and its y into `[y1, y2]`. Each coordinate is independent because the rectangle is a product of two intervals, and clamping minimises each squared difference separately.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
