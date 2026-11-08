# 1267. Count Servers that Communicate

**Difficulty:** Medium  
**Topics:** `Array`, `Depth-First Search`, `Breadth-First Search`, `Matrix`, `Counting`  
**Complexity:** time O(m * n), space O(m + n)

- **Write-up:** [yral.dev/leetcode/count-servers-that-communicate](https://yral.dev/leetcode/count-servers-that-communicate)
- **Problem:** [Count Servers that Communicate on LeetCode](https://leetcode.com/problems/count-servers-that-communicate/)

## Idea

A server communicates if at least one other server shares its row or its column. The question is not about chains of servers, so no graph search is needed. All that matters per server is whether its row or its column holds two or more servers, and two arrays of counts answer that.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
