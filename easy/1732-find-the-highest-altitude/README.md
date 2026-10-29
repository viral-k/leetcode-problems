# 1732. Find the Highest Altitude

**Difficulty:** Easy  
**Topics:** `Array`, `Prefix Sum`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/find-the-highest-altitude](https://yral.dev/leetcode/find-the-highest-altitude)
- **Problem:** [Find the Highest Altitude on LeetCode](https://leetcode.com/problems/find-the-highest-altitude/)

## Idea

The altitude at each point is the running sum of the gains up to that point, starting from `0`. So the highest altitude is simply the maximum prefix sum of `gain`, including the starting altitude of `0`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
