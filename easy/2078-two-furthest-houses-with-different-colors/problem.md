# Two Furthest Houses With Different Colors

**Difficulty:** Easy  
**LeetCode Link:** [Two Furthest Houses With Different Colors](https://leetcode.com/problems/two-furthest-houses-with-different-colors/)

## Description

There are `n` houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array `colors` of length `n`, where `colors[i]` represents the color of the `ith` house.

Return the **maximum distance** between two houses with **different colors**.

The distance between the `ith` and `jth` houses is `abs(i - j)`, where `abs(x)` is the absolute value of `x`.

## Examples

### Example 1
```
Input: colors = [1,1,1,6,1,1,1]
Output: 3
Explanation: Houses 0 and 3 have different colors (1 and 6). Distance = 3.
```

### Example 2
```
Input: colors = [1,8,3,8,3]
Output: 4
Explanation: Houses 0 and 4 have different colors (1 and 3). Distance = 4.
```

### Example 3
```
Input: colors = [0,1]
Output: 1
Explanation: Houses 0 and 1 have different colors. Distance = 1.
```

## Constraints

- `n == colors.length`
- `2 <= n <= 100`
- `0 <= colors[i] <= 100`
- At least two houses have different colors
