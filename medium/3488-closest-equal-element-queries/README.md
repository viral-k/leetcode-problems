# 3488. Closest Equal Element Queries

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`  
**Complexity:** time O(n + q), space O(n)

- **Write-up:** [yral.dev/leetcode/closest-equal-element-queries](https://yral.dev/leetcode/closest-equal-element-queries)
- **Problem:** [Closest Equal Element Queries on LeetCode](https://leetcode.com/problems/closest-equal-element-queries/)

## Idea

Precompute the minimum distance to a same-value element for every index. Then queries are O(1) lookups.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
