# Minimum Operations to Make a Uni-Value Grid

**Difficulty:** Medium  
**LeetCode Link:** [Minimum Operations to Make a Uni-Value Grid](https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/)

## Description

You are given a 2D integer `grid` of size `m x n` and an integer `x`. In one operation, you can **add** `x` to or **subtract** `x` from any element in the grid.

A **uni-value grid** is a grid where all the elements are equal.

Return the **minimum number of operations** to make the grid uni-value. If it is not possible, return `-1`.

## Examples

### Example 1
```
Input: grid = [[2,4],[6,8]], x = 2
Output: 4
Explanation: Make every element equal to 4:
- Add x to 2 once
- Subtract x from 6 once
- Subtract x from 8 twice
Total: 4 operations
```

### Example 2
```
Input: grid = [[1,5],[2,3]], x = 1
Output: 5
Explanation: Make every element equal to 3.
```

### Example 3
```
Input: grid = [[1,2],[3,4]], x = 2
Output: -1
Explanation: Impossible - elements have different remainders mod 2.
```

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 10^5`
- `1 <= m * n <= 10^5`
- `1 <= x, grid[i][j] <= 10^4`
