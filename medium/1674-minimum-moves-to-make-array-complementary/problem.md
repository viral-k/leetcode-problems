# Minimum Moves to Make Array Complementary

**Difficulty:** Medium  
**LeetCode Link:** [Minimum Moves to Make Array Complementary](https://leetcode.com/problems/minimum-moves-to-make-array-complementary/)

## Description

You are given an integer array `nums` of even length `n` and an integer `limit`. In one move, you can replace any integer from `nums` with another integer between `1` and `limit`, inclusive.

The array `nums` is complementary if for all indices `i`, `nums[i] + nums[n - 1 - i]` equals the same number.

Return the minimum number of moves required to make `nums` complementary.

## Examples

### Example 1
```
Input: nums = [1,2,4,3], limit = 4
Output: 1
Explanation:
Change nums to [1,2,2,3].
Both mirrored pairs sum to 4.
```

### Example 2
```
Input: nums = [1,2,2,1], limit = 2
Output: 2
Explanation:
Change nums to [2,2,2,2]. A target pair sum of 3 is impossible because values cannot exceed limit.
```

### Example 3
```
Input: nums = [1,2,1,2], limit = 2
Output: 0
Explanation:
nums is already complementary.
```

## Constraints

- `n == nums.length`
- `2 <= n <= 10^5`
- `1 <= nums[i] <= limit <= 10^5`
- `n` is even.
