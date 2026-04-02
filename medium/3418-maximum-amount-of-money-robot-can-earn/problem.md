# Maximum Amount of Money Robot Can Earn

**Difficulty:** Medium  
**LeetCode Link:** [Maximum Amount of Money Robot Can Earn](https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/)

## Description

You are given an `m x n` grid. A robot starts at the top-left corner `(0, 0)` and wants to reach the bottom-right corner `(m - 1, n - 1)`.

The robot can only move:
- **Right**
- **Down**

Each cell contains a value:
- If `coins[i][j] >= 0`: the robot gains coins
- If `coins[i][j] < 0`: a robber steals coins

The robot has a special ability to **neutralize robbers in at most 2 cells**, preventing loss in those cells.

Return the **maximum profit** the robot can achieve.

## Examples

### Example 1
```
Input: coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
Output: 8
```

### Example 2
```
Input: coins = [[10,10,10],[10,10,10]]
Output: 40
```

## Constraints

- `1 <= m, n <= 500`
- `-1000 <= coins[i][j] <= 1000`
