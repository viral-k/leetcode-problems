# Construct Uniform Parity Array II

**Difficulty:** Medium  
**LeetCode Link:** [Construct Uniform Parity Array II](https://leetcode.com/problems/construct-uniform-parity-array-ii/)

## Description

You are given an array `nums1` of `n` distinct integers.

You want to construct another array `nums2` of length `n` such that the elements in `nums2` are either all odd or all even.

For each index `i`, you must choose exactly one of the following (in any order):

- `nums2[i] = nums1[i]`
- `nums2[i] = nums1[i] - nums1[j]`, for an index `j != i`, such that `nums1[i] - nums1[j] >= 1`

Return `true` if it is possible to construct such an array, otherwise return `false`.

## Examples

### Example 1
```
Input: nums1 = [1,4,7]
Output: true
Explanation: nums2[0] = 1, nums2[1] = 4 - 1 = 3, nums2[2] = 7.
nums2 = [1, 3, 7] is all odd.
```

### Example 2
```
Input: nums1 = [2,3]
Output: false
Explanation: No choice makes all elements share a parity.
```

### Example 3
```
Input: nums1 = [4,6]
Output: true
Explanation: nums2 = [4, 6] is already all even.
```

## Constraints

- `1 <= n == nums1.length <= 10^5`
- `1 <= nums1[i] <= 10^9`
- `nums1` consists of distinct integers.
