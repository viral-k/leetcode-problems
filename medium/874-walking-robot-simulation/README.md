# 874. Walking Robot Simulation

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Simulation`  
**Complexity:** time O(n + m) where n = total steps, m = obstacles, space O(m)

- **Write-up:** [yral.dev/leetcode/walking-robot-simulation](https://yral.dev/leetcode/walking-robot-simulation)
- **Problem:** [Walking Robot Simulation on LeetCode](https://leetcode.com/problems/walking-robot-simulation/)

## Idea

Simulate the robot's movement step by step. Use direction vectors and a set for O(1) obstacle lookup. Track maximum squared distance after each step.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
