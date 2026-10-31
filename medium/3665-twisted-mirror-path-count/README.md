# 3665. Twisted Mirror Path Count

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`, `Matrix`  
**Complexity:** time O(m * n), space O(n)

- **Write-up:** [yral.dev/leetcode/twisted-mirror-path-count](https://yral.dev/leetcode/twisted-mirror-path-count)
- **Problem:** [Twisted Mirror Path Count on LeetCode](https://leetcode.com/problems/twisted-mirror-path-count/)

## Idea

Plain grid path counting, except a mirror cell is never a place the robot stands. It is a turn whose result depends on the direction the robot came from: entering moving right sends it down, entering moving down sends it right. So the DP needs one extra bit per cell, the direction of entry. Moves still only go right or down, so row-major order works and chains of mirrors resolve on their own, one cell at a time.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
