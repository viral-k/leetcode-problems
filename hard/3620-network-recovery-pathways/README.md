# 3620. Network Recovery Pathways

**Difficulty:** Hard  
**Topics:** `Graph`, `Binary Search`, `Dynamic Programming`, `Topological Sort`, `Shortest Path`  
**Complexity:** time O((n + m) log m), space O(n + m)

- **Write-up:** [yral.dev/leetcode/network-recovery-pathways](https://yral.dev/leetcode/network-recovery-pathways)
- **Problem:** [Network Recovery Pathways on LeetCode](https://leetcode.com/problems/network-recovery-pathways/)

## Idea

The score of a path is its **minimum** edge cost, and we want the largest such minimum subject to a total-cost budget `k`. "Maximize the minimum" with a monotonic feasibility check screams **binary search on the answer**.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
