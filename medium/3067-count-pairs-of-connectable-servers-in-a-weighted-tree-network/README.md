# 3067. Count Pairs of Connectable Servers in a Weighted Tree Network

**Difficulty:** Medium  
**Topics:** `Array`, `Tree`, `DFS`  
**Complexity:** time O(n²), space O(n)

- **Write-up:** [yral.dev/leetcode/count-pairs-of-connectable-servers-in-a-weighted-tree-network](https://yral.dev/leetcode/count-pairs-of-connectable-servers-in-a-weighted-tree-network)
- **Problem:** [Count Pairs of Connectable Servers in a Weighted Tree Network on LeetCode](https://leetcode.com/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/)

## Idea

For each server `c`, count valid servers in each branch (subtree), then count pairs across different branches. Two servers are connectable if they're in different branches and both have distances divisible by `signalSpeed`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
