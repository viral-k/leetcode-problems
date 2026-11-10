# 3693. Climbing Stairs II

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/climbing-stairs-ii](https://yral.dev/leetcode/climbing-stairs-ii)
- **Problem:** [Climbing Stairs II on LeetCode](https://leetcode.com/problems/climbing-stairs-ii/)

## Idea

The cost of landing on step `j` depends only on where the jump started, and that can only be `j - 1`, `j - 2` or `j - 3`. So the cheapest way to reach `j` is the cheapest way to reach one of those three steps, plus the jump. The jump costs `costs[j]` plus a penalty of 1, 4 or 9 for a jump of length 1, 2 or 3.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
