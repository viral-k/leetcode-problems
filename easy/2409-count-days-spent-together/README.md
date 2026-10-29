# 2409. Count Days Spent Together

**Difficulty:** Easy  
**Topics:** `Math`, `String`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/count-days-spent-together](https://yral.dev/leetcode/count-days-spent-together)
- **Problem:** [Count Days Spent Together on LeetCode](https://leetcode.com/problems/count-days-spent-together/)

## Idea

Dates in a fixed, known year are just numbers. Map each `"MM-DD"` to its
day-of-year ordinal and the problem collapses to intersecting two closed
intervals of integers, with no calendar arithmetic left to get wrong.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
