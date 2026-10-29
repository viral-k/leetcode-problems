# 2161. Partition Array According to Given Pivot

**Difficulty:** Medium  
**Topics:** `Array`, `Two Pointers`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/partition-array-according-to-given-pivot](https://yral.dev/leetcode/partition-array-according-to-given-pivot)
- **Problem:** [Partition Array According to Given Pivot on LeetCode](https://leetcode.com/problems/partition-array-according-to-given-pivot/)

## Idea

The result is just three groups concatenated in order: everything `< pivot` (original order), then all the copies of `pivot`, then everything `> pivot` (original order). A stable single pass that buckets each value preserves the required relative order automatically.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
