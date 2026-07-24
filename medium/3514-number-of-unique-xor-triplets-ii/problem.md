# Number of Unique XOR Triplets II

**Difficulty:** Medium  
**LeetCode Link:** [Number of Unique XOR Triplets II](https://leetcode.com/problems/number-of-unique-xor-triplets-ii/)

## Description

You are given an integer array `nums`.

A XOR triplet is defined as the XOR of three elements `nums[i] XOR nums[j] XOR nums[k]` where `i <= j <= k`.

Return the number of unique XOR triplet values from all possible triplets `(i, j, k)`.

## Examples

### Example 1
```
Input: nums = [1,3]
Output: 2
Explanation: The unique XOR values are {1, 3}.
```

### Example 2
```
Input: nums = [6,7,8,9]
Output: 4
Explanation: The possible XOR triplet values are {6, 7, 8, 9}.
```

## Constraints

- `1 <= nums.length <= 1500`
- `1 <= nums[i] <= 1500`
