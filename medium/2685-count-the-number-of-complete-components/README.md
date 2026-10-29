# 2685. Count the Number of Complete Components

**Difficulty:** Medium  
**Topics:** `DFS`, `BFS`, `Union Find`, `Graph`  
**Complexity:** time O(n + m * alpha(n)), space O(n)

- **Write-up:** [yral.dev/leetcode/count-the-number-of-complete-components](https://yral.dev/leetcode/count-the-number-of-complete-components)
- **Problem:** [Count the Number of Complete Components on LeetCode](https://leetcode.com/problems/count-the-number-of-complete-components/)

## Idea

A connected component with `k` vertices is *complete* precisely when it contains every possible edge, i.e. exactly `k * (k - 1) / 2` of them. So for each component we just need its vertex count and edge count and compare.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
