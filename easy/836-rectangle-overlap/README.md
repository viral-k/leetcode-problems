# 836. Rectangle Overlap

**Difficulty:** Easy  
**Topics:** `Math`, `Geometry`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/rectangle-overlap](https://yral.dev/leetcode/rectangle-overlap)
- **Problem:** [Rectangle Overlap on LeetCode](https://leetcode.com/problems/rectangle-overlap/)

## Idea

Two axis-aligned rectangles overlap only if they overlap along the X-axis **and** along the Y-axis independently. Each axis reduces to a one-dimensional question: do the intervals `[x1, x2]` of the two rectangles share an open segment?

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
