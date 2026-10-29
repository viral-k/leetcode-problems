# 3661. Maximum Walls Destroyed by Robots

**Difficulty:** Hard  
**Topics:** `Array`, `Greedy`, `Sorting`, `Binary Search`, `Dynamic Programming`  
**Complexity:** time O(n log n + m log m), space O(n)

- **Write-up:** [yral.dev/leetcode/maximum-walls-destroyed-by-robots](https://yral.dev/leetcode/maximum-walls-destroyed-by-robots)
- **Problem:** [Maximum Walls Destroyed by Robots on LeetCode](https://leetcode.com/problems/maximum-walls-destroyed-by-robots/)

## Idea

Each robot can fire left OR right. Bullets are blocked by adjacent robots. Use DP to track the best outcome when each robot fires left vs right, accounting for overlapping wall coverage between adjacent robots.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
