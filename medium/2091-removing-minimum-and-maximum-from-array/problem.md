# Removing Minimum and Maximum From Array

**Difficulty:** Medium  
**LeetCode Link:** [Removing Minimum and Maximum From Array](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/)

## Description

You are given a 0-indexed array of distinct integers `nums`.

There is an element in `nums` that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.

A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.

Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.

## Examples

### Example 1
```
Input: nums = [2,10,7,5,4,1,8,6]
Output: 5
Explanation: The minimum is nums[5] = 1 and the maximum is nums[1] = 10.
Removing 2 from the front and 3 from the back gives 5 deletions.
```

### Example 2
```
Input: nums = [0,-4,19,1,8,-2,-3,5]
Output: 3
Explanation: The minimum is nums[1] = -4 and the maximum is nums[2] = 19.
Removing 3 elements from the front suffices.
```

### Example 3
```
Input: nums = [101]
Output: 1
Explanation: The single element is both the minimum and the maximum.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^5 <= nums[i] <= 10^5`
- The integers in `nums` are distinct.
