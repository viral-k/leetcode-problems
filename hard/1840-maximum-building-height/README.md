# 1840. Maximum Building Height

**Difficulty:** Hard  
**Topics:** `Array`, `Math`, `Greedy`  
**Complexity:** time O(r log r), space O(r)

- **Write-up:** [yral.dev/leetcode/maximum-building-height](https://yral.dev/leetcode/maximum-building-height)
- **Problem:** [Maximum Building Height on LeetCode](https://leetcode.com/problems/maximum-building-height/)

## Idea

Because adjacent buildings can differ by at most 1, the height at a building is bounded by how far it is from any fixed-height constraint. Each restricted building acts as a "checkpoint": the height anywhere can rise or fall at most 1 per step away from a checkpoint.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
