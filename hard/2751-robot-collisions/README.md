# 2751. Robot Collisions

**Difficulty:** Hard  
**Topics:** `Array`, `Stack`, `Sorting`, `Simulation`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/robot-collisions](https://yral.dev/leetcode/robot-collisions)
- **Problem:** [Robot Collisions on LeetCode](https://leetcode.com/problems/robot-collisions/)

## Idea

Similar to asteroid collision problems. Robots only collide when one moves right (`'R'`) and another moves left (`'L'`). Use a stack to track right-moving robots and simulate collisions when a left-moving robot appears.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
