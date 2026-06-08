# Partition Array According to Given Pivot

**Difficulty:** Medium  
**LeetCode Link:** [Partition Array According to Given Pivot](https://leetcode.com/problems/partition-array-according-to-given-pivot/)

## Description

You are given a 0-indexed integer array `nums` and an integer `pivot`. Rearrange `nums` such that the following conditions are satisfied:

- Every element less than `pivot` appears before every element greater than `pivot`.
- Every element equal to `pivot` appears in between the elements less than and greater than `pivot`.
- The relative order of the elements less than `pivot` and the elements greater than `pivot` is maintained.
  - More formally, consider every `pi`, `pj` where `pi` is the new position of the `ith` element and `pj` is the new position of the `jth` element. If `i < j` and both elements are smaller (or larger) than `pivot`, then `pi < pj`.

Return `nums` after the rearrangement.

## Examples

### Example 1
```
Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
Explanation: The elements 9, 5, and 3 are less than the pivot so they are on the
left side of the array. The elements 12 and 14 are greater than the pivot so they
are on the right side. The relative ordering [9, 5, 3] and [12, 14] is maintained.
```

### Example 2
```
Input: nums = [-3,4,3,2], pivot = 2
Output: [-3,2,4,3]
Explanation: -3 is less than the pivot (left side). 4 and 3 are greater (right side).
The relative ordering [-3] and [4, 3] is maintained.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^6 <= nums[i] <= 10^6`
- `pivot` equals to an element of `nums`.
