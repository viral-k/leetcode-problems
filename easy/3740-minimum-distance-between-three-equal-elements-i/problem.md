# Minimum Distance Between Three Equal Elements I

**Difficulty:** Easy  
**LeetCode Link:** [Minimum Distance Between Three Equal Elements I](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/)

## Description

You are given an integer array `nums`.

A tuple `(i, j, k)` of 3 distinct indices is **good** if `nums[i] == nums[j] == nums[k]`.

The **distance** of a good tuple is `abs(i - j) + abs(j - k) + abs(k - i)`, where `abs(x)` denotes the absolute value of x.

Return an integer denoting the **minimum possible distance** of a good tuple. If no good tuples exist, return `-1`.

## Examples

### Example 1
```
Input: nums = [1,2,1,1,3]
Output: 6
Explanation: The good tuple (0, 2, 3) has distance |0-2| + |2-3| + |3-0| = 2 + 1 + 3 = 6.
```

### Example 2
```
Input: nums = [1,1,2,3,2,1,2]
Output: 8
Explanation: The good tuple (2, 4, 6) has distance |2-4| + |4-6| + |6-2| = 2 + 2 + 4 = 8.
```

### Example 3
```
Input: nums = [1]
Output: -1
Explanation: No good tuples exist.
```

## Constraints

- `1 <= n == nums.length <= 100`
- `1 <= nums[i] <= n`
