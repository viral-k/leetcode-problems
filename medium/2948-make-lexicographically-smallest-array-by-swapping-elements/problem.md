# Make Lexicographically Smallest Array by Swapping Elements

**Difficulty:** Medium  
**LeetCode Link:** [Make Lexicographically Smallest Array by Swapping Elements](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/)

## Description

You are given a 0-indexed array of positive integers `nums` and a positive integer `limit`.

In one operation, you can choose any two indices `i` and `j` and swap `nums[i]` and `nums[j]` if `|nums[i] - nums[j]| <= limit`.

Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

An array `a` is lexicographically smaller than an array `b` if in the first position where `a` and `b` differ, array `a` has an element that is less than the corresponding element in `b`. For example, the array `[2,10,3]` is lexicographically smaller than the array `[10,2,3]` because they differ at index `0` and `2 < 10`.

## Examples

### Example 1
```
Input: nums = [1,5,3,9,8], limit = 2
Output: [1,3,5,8,9]
Explanation: Swap nums[1] with nums[2], then nums[3] with nums[4].
```

### Example 2
```
Input: nums = [1,7,6,18,2,1], limit = 3
Output: [1,6,7,18,1,2]
```

### Example 3
```
Input: nums = [1,7,28,19,10], limit = 3
Output: [1,7,28,19,10]
Explanation: No operation can be applied to any two indices.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= limit <= 10^9`
