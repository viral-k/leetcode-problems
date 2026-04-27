# Check if There is a Valid Path in a Grid

**Difficulty:** Medium  
**LeetCode Link:** [Check if There is a Valid Path in a Grid](https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/)

## Description

You are given an `m x n` grid. Each cell of grid represents a street:

- `1`: connects left ↔ right
- `2`: connects up ↔ down
- `3`: connects left ↔ down
- `4`: connects right ↔ down
- `5`: connects left ↔ up
- `6`: connects right ↔ up

You start at the upper-left cell `(0, 0)`. A valid path starts from `(0, 0)` and ends at `(m-1, n-1)`, following the streets.

Return `true` if there is a valid path, otherwise `false`.

## Examples

### Example 1
```
Input: grid = [[2,4,3],[6,5,2]]
Output: true
Explanation: Can traverse from (0,0) to (1,2) following connected streets.
```

### Example 2
```
Input: grid = [[1,2,1],[1,2,1]]
Output: false
Explanation: Street at (0,0) doesn't connect to any adjacent cell.
```

### Example 3
```
Input: grid = [[1,1,2]]
Output: false
Explanation: Get stuck at (0,1), cannot reach (0,2).
```

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `1 <= grid[i][j] <= 6`
