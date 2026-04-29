# Maximum Score From Grid Operations

**Difficulty:** Hard  
**LeetCode Link:** [Maximum Score From Grid Operations](https://leetcode.com/problems/maximum-score-from-grid-operations/)

## Description

You are given a 2D matrix `grid` of size `n x n`. Initially, all cells are colored white. In one operation, you can select any cell `(i, j)` and color black all cells of the `jth` column from the top row down to the `ith` row.

The grid score is the sum of all `grid[i][j]` such that cell `(i, j)` is white and it has a horizontally adjacent black cell.

Return the **maximum score** that can be achieved after some number of operations.

## Examples

### Example 1
```
Input: grid = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]
Output: 11
Explanation: Color column 1 down to row 3, column 4 down to last row.
Score = grid[3][0] + grid[1][2] + grid[3][3] = 5 + 3 + 3 = 11.
```

### Example 2
```
Input: grid = [[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]
Output: 94
```

## Constraints

- `1 <= n == grid.length <= 100`
- `n == grid[i].length`
- `0 <= grid[i][j] <= 10^9`
