# Maximum Product of Two Elements in an Array

**Difficulty:** Easy  
**LeetCode Link:** [Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)

## Description

Given the array of integers `nums`, you will choose two different indices `i` and `j` of that array. Return the maximum value of `(nums[i]-1)*(nums[j]-1)`.

## Examples

### Example 1
```
Input: nums = [3,4,5,2]
Output: 12
Explanation: (nums[1]-1)*(nums[2]-1) = 3*4 = 12.
```

### Example 2
```
Input: nums = [1,5,4,5]
Output: 16
Explanation: (5-1)*(5-1) = 16.
```

### Example 3
```
Input: nums = [3,7]
Output: 12
```

## Constraints

- `2 <= nums.length <= 500`
- `1 <= nums[i] <= 10^3`
