# Smallest Missing Multiple of K

**Difficulty:** Easy  
**LeetCode Link:** [Smallest Missing Multiple of K](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

## Description

Given an integer array `nums` and an integer `k`, return the smallest positive multiple of `k` that is missing from `nums`.

A multiple of `k` is any positive integer divisible by `k`.

## Examples

### Example 1
```
Input: nums = [8,2,3,4,6], k = 2
Output: 10
Explanation: The multiples of k = 2 are 2, 4, 6, 8, 10, 12, ...
The smallest one missing from nums is 10.
```

### Example 2
```
Input: nums = [1,4,7,10,15], k = 5
Output: 5
Explanation: The multiples of k = 5 are 5, 10, 15, 20, ...
5 is missing from nums, so it is the answer.
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
- `1 <= k <= 100`
