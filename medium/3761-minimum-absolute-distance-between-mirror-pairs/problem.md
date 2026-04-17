# Minimum Absolute Distance Between Mirror Pairs

**Difficulty:** Medium  
**LeetCode Link:** [Minimum Absolute Distance Between Mirror Pairs](https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/)

## Description

You are given an integer array `nums`.

A **mirror pair** is a pair of indices `(i, j)` such that:

- `0 <= i < j < nums.length`, and
- `reverse(nums[i]) == nums[j]`, where `reverse(x)` denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing (e.g., `reverse(120) = 21`).

Return the **minimum absolute distance** between the indices of any mirror pair. The absolute distance between indices `i` and `j` is `abs(i - j)`.

If no mirror pair exists, return `-1`.

## Examples

### Example 1
```
Input: nums = [12,21,45,33,54]
Output: 1
Explanation:
- (0, 1): reverse(12) = 21 = nums[1], distance = 1
- (2, 4): reverse(45) = 54 = nums[4], distance = 2
Minimum distance is 1.
```

### Example 2
```
Input: nums = [120,21]
Output: 1
Explanation: Mirror pair (0, 1) since reverse(120) = 21 = nums[1].
```

### Example 3
```
Input: nums = [21,120]
Output: -1
Explanation: No mirror pairs exist. reverse(21) = 12 ≠ 120.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
