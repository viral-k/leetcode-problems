# 3532. Path Existence Queries in a Graph I

**Difficulty:** Medium  
**Topics:** `Array`, `Union Find`, `Prefix Sum`  
**Complexity:** time O(n + q), space O(n)

- **Write-up:** [yral.dev/leetcode/path-existence-queries-in-a-graph-i](https://yral.dev/leetcode/path-existence-queries-in-a-graph-i)
- **Problem:** [Path Existence Queries in a Graph I on LeetCode](https://leetcode.com/problems/path-existence-queries-in-a-graph-i/)

## Idea

`nums` is sorted, which collapses the whole graph structure: a connected component is always a **contiguous range** of indices. Two neighbors `i` and `i+1` are joined iff `nums[i+1] - nums[i] <= maxDiff`. If that consecutive gap exceeds `maxDiff`, nothing can bridge it — any edge crossing the gap connects two values at least that far apart (sorted order), so it also exceeds `maxDiff`. Hence the components are exactly the maximal runs where every consecutive gap is `<= maxDiff`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
