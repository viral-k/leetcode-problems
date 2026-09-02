# Construct Uniform Parity Array I

**Difficulty:** Easy  
**LeetCode Link:** [Construct Uniform Parity Array I](https://leetcode.com/problems/construct-uniform-parity-array-i/)

## Description

You are given an array `nums1` of `n` distinct integers.

You want to construct another array `nums2` of length `n` such that the elements in `nums2` are either all odd or all even.

For each index `i`, you must choose exactly one of the following (in any order):

- `nums2[i] = nums1[i]`
- `nums2[i] = nums1[i] - nums1[j]`, for an index `j != i`

Return `true` if it is possible to construct such an array, otherwise, return `false`.

## Examples

### Example 1
```
Input: nums1 = [2,3]
Output: true
Explanation: nums2[0] = 2 - 3 = -1 and nums2[1] = 3, so nums2 = [-1, 3] is all odd.
```

### Example 2
```
Input: nums1 = [4,6]
Output: true
Explanation: nums2 = [4, 6] is already all even.
```

## Constraints

- `1 <= n == nums1.length <= 100`
- `1 <= nums1[i] <= 100`
- `nums1` consists of distinct integers.
