# 2770. Maximum Number of Jumps to Reach the Last Index

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`  
**Complexity:** time O(n²), space O(n)

- **Write-up:** [yral.dev/leetcode/maximum-number-of-jumps-to-reach-the-last-index](https://yral.dev/leetcode/maximum-number-of-jumps-to-reach-the-last-index)
- **Problem:** [Maximum Number of Jumps to Reach the Last Index on LeetCode](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)

## Idea

Jumps only go from a smaller index to a larger index, so the graph is acyclic. That makes dynamic programming natural.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
