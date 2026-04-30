# Maximum Path Score In A Grid

**Difficulty:** Medium  
**LeetCode Link:** [Maximum Path Score In A Grid](https://leetcode.com/problems/maximum-path-score-in-a-grid/)

## Description

You are given an `m x n` grid where each cell contains one of the values `0`, `1`, or `2`. You are also given an integer `k`.

You start from the top-left corner `(0, 0)` and want to reach the bottom-right corner `(m - 1, n - 1)` by moving only right or down.

Each cell contributes a specific score and incurs an associated cost, according to its value:

- `0`: adds `0` to the score and costs `0`.
- `1`: adds `1` to the score and costs `1`.
- `2`: adds `2` to the score and costs `1`.

Return the maximum score achievable without exceeding a total cost of `k`, or `-1` if no valid path exists.

> If you reach the last cell but the total cost exceeds `k`, the path is invalid.

## Examples

### Example 1
```
Input:  grid = [[0,1],[2,0]], k = 1
Output: 2
Explanation: Path (0,0) -> (1,0) -> (1,1) has score 0+2+0 = 2 and cost 0+1+0 = 1.
```

### Example 2
```
Input:  grid = [[0,1],[1,2]], k = 1
Output: -1
Explanation: Every path to (1,1) costs at least 2, exceeding k = 1.
```

## Constraints

- `1 <= m, n <= 200`
- `0 <= k <= 10^3`
- `grid[0][0] == 0`
- `0 <= grid[i][j] <= 2`
