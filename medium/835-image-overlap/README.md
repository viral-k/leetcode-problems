# 835. Image Overlap

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Matrix`  
**Complexity:** time O(k1 * k2), space O(n^2)

- **Write-up:** [yral.dev/leetcode/image-overlap](https://yral.dev/leetcode/image-overlap)
- **Problem:** [Image Overlap on LeetCode](https://leetcode.com/problems/image-overlap/)

## Idea

A translation is fully described by one offset vector `(dr, dc)`. Under that translation, a `1` at `(r, c)` in `img1` lands on `(r + dr, c + dc)`, and it contributes to the overlap exactly when `img2` has a `1` there.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
