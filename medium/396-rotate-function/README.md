# 396. Rotate Function

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Dynamic Programming`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/rotate-function](https://yral.dev/leetcode/rotate-function)
- **Problem:** [Rotate Function on LeetCode](https://leetcode.com/problems/rotate-function/)

## Idea

The direct way is to build every rotated array and compute its weighted sum, but that repeats almost all of the same work. When the array rotates once clockwise, every element's index increases by `1`, except the element moved from the end to the front, whose contribution drops from `(n - 1) * value` to `0`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
