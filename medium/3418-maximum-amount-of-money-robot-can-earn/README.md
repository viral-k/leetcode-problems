# 3418. Maximum Amount of Money Robot Can Earn

**Difficulty:** Medium  
**Topics:** `Array`, `Matrix`, `Dynamic Programming`  
**Complexity:** time O(m × n), space O(m × n)

- **Write-up:** [yral.dev/leetcode/maximum-amount-of-money-robot-can-earn](https://yral.dev/leetcode/maximum-amount-of-money-robot-can-earn)
- **Problem:** [Maximum Amount of Money Robot Can Earn on LeetCode](https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/)

## Idea

Standard grid DP with an extra dimension: we can neutralize up to 2 negative cells. Track how many neutralizations have been used at each position.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
