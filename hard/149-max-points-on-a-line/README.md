# 149. Max Points on a Line

**Difficulty:** Hard  
**Topics:** `Array`, `Hash Table`, `Math`, `Geometry`  
**Complexity:** time O(n^2), space O(n)

- **Write-up:** [yral.dev/leetcode/max-points-on-a-line](https://yral.dev/leetcode/max-points-on-a-line)
- **Problem:** [Max Points on a Line on LeetCode](https://leetcode.com/problems/max-points-on-a-line/)

## Idea

Two points determine a line, so instead of enumerating lines, fix one point as an anchor and sort the rest by direction. All points sharing a direction from the anchor are collinear with it. The best line through the anchor is the largest such group plus the anchor itself.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
