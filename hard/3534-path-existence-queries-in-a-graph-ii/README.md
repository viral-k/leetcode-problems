# 3534. Path Existence Queries in a Graph II

**Difficulty:** Hard  
**Topics:** `Array`, `Binary Lifting`, `Sorting`, `Two Pointers`, `Greedy`  
**Complexity:** time O((n + q) log n), space O(n log n)

- **Write-up:** [yral.dev/leetcode/path-existence-queries-in-a-graph-ii](https://yral.dev/leetcode/path-existence-queries-in-a-graph-ii)
- **Problem:** [Path Existence Queries in a Graph II on LeetCode](https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/)

## Idea

Sort the nodes by value. Then, exactly as in part I, connected components are **contiguous runs** in sorted order (a consecutive gap larger than `maxDiff` can't be crossed by any edge). Cross-component queries answer `-1`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
