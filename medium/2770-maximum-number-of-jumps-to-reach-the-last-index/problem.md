# Maximum Number of Jumps to Reach the Last Index

**Difficulty:** Medium  
**LeetCode Link:** [Maximum Number of Jumps to Reach the Last Index](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)

## Description

You are given a 0-indexed array `nums` of `n` integers and an integer `target`.

You are initially positioned at index `0`. In one step, you can jump from index `i` to any index `j` such that:

- `0 <= i < j < n`
- `-target <= nums[j] - nums[i] <= target`

Return the maximum number of jumps you can make to reach index `n - 1`.

If there is no way to reach index `n - 1`, return `-1`.

## Examples

### Example 1
```
Input: nums = [1,3,6,4,1,2], target = 2
Output: 3
Explanation:
Jump from index 0 to 1, then 1 to 3, then 3 to 5.
There is no valid sequence from 0 to n - 1 with more than 3 jumps.
```

### Example 2
```
Input: nums = [1,3,6,4,1,2], target = 3
Output: 5
Explanation:
Jump through every adjacent index: 0 -> 1 -> 2 -> 3 -> 4 -> 5.
There is no valid sequence from 0 to n - 1 with more than 5 jumps.
```

### Example 3
```
Input: nums = [1,3,6,4,1,2], target = 0
Output: -1
Explanation:
There is no valid jumping sequence from 0 to n - 1.
```

## Constraints

- `2 <= nums.length == n <= 1000`
- `-10^9 <= nums[i] <= 10^9`
- `0 <= target <= 2 * 10^9`
