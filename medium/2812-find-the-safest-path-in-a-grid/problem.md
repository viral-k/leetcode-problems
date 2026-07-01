# Find the Safest Path in a Grid

**Difficulty:** Medium  
**LeetCode Link:** [Find the Safest Path in a Grid](https://leetcode.com/problems/find-the-safest-path-in-a-grid/)

## Description

You are given a 0-indexed 2D matrix `grid` of size `n x n`, where `(r, c)` represents:

- A cell containing a thief if `grid[r][c] = 1`
- An empty cell if `grid[r][c] = 0`

You are initially positioned at cell `(0, 0)`. In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

The safeness factor of a path on the grid is defined as the minimum Manhattan distance from any cell in the path to any thief in the grid.

Return the maximum safeness factor of all paths leading to cell `(n - 1, n - 1)`.

An adjacent cell of cell `(r, c)` is one of `(r, c + 1)`, `(r, c - 1)`, `(r + 1, c)`, `(r - 1, c)` if it exists.

The Manhattan distance between `(a, b)` and `(x, y)` is `|a - x| + |b - y|`.

## Examples

### Example 1
```
Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
Output: 0
Explanation: All paths from (0,0) to (n-1,n-1) go through thieves at (0,0) and (n-1,n-1).
```

### Example 2
```
Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
Output: 2
Explanation: The best path has safeness factor 2.
```

### Example 3
```
Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
Output: 2
```

## Constraints

- `1 <= grid.length == n <= 400`
- `grid[i].length == n`
- `grid[i][j]` is either `0` or `1`.
- There is at least one thief in the `grid`.
