# Smallest Missing Integer Greater Than Sequential Prefix Sum

**Difficulty:** Easy  
**LeetCode Link:** [Smallest Missing Integer Greater Than Sequential Prefix Sum](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/)

## Description

You are given a 0-indexed array of integers `nums`.

A prefix `nums[0..i]` is sequential if, for all `1 <= j <= i`, `nums[j] = nums[j - 1] + 1`. In particular, the prefix consisting only of `nums[0]` is sequential.

Return the smallest integer `x` missing from `nums` such that `x` is greater than or equal to the sum of the longest sequential prefix.

## Examples

### Example 1
```
Input: nums = [1,2,3,2,5]
Output: 6
Explanation: The longest sequential prefix is [1,2,3] with sum 6. 6 is not in nums.
```

### Example 2
```
Input: nums = [3,4,5,1,12,14,13]
Output: 15
Explanation: The longest sequential prefix is [3,4,5] with sum 12. 12, 13, 14 are in nums; 15 is not.
```

## Constraints

- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 50`
