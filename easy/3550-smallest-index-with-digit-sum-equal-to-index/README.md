# 3550. Smallest Index with Digit Sum Equal to Index

**Difficulty:** Easy  
**Topics:** `Array`, `Math`  
**Complexity:** time O(n * d), space O(1)

- **Write-up:** [yral.dev/leetcode/smallest-index-with-digit-sum-equal-to-index](https://yral.dev/leetcode/smallest-index-with-digit-sum-equal-to-index)
- **Problem:** [Smallest Index with Digit Sum Equal to Index on LeetCode](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/)

## Idea

The condition is per-index and independent of everything else, so a single left-to-right scan finds the smallest matching index. Returning on the first match is what makes it smallest.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
