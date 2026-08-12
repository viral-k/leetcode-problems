# Length of Longest Subarray With at Most K Frequency

**Difficulty:** Medium  
**LeetCode Link:** [Length of Longest Subarray With at Most K Frequency](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)

## Description

You are given an integer array `nums` and an integer `k`.

The frequency of an element `x` is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to `k`.

Return the length of the longest good subarray of `nums`.

A subarray is a contiguous non-empty sequence of elements within an array.

## Examples

### Example 1
```
Input: nums = [1,2,3,1,2,3,1,2], k = 2
Output: 6
Explanation: [1,2,3,1,2,3] is good; each of 1, 2, 3 occurs at most twice.
```

### Example 2
```
Input: nums = [1,2,1,2,1,2,1,2], k = 1
Output: 2
Explanation: [1,2] is good; each value occurs once.
```

### Example 3
```
Input: nums = [5,5,5,5,5,5,5], k = 4
Output: 4
Explanation: [5,5,5,5] is good; 5 occurs 4 times.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= nums.length`
