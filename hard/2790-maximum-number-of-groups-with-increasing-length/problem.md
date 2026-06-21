# Maximum Number of Groups With Increasing Length

**Difficulty:** Hard  
**LeetCode Link:** [Maximum Number of Groups With Increasing Length](https://leetcode.com/problems/maximum-number-of-groups-with-increasing-length/)

## Description

You are given a 0-indexed array `usageLimits` of length `n`.

Your task is to create groups using numbers from `0` to `n - 1`, ensuring that each number, `i`, is used no more than `usageLimits[i]` times in total across all groups. You must also satisfy the following conditions:

- Each group must consist of distinct numbers, meaning that no duplicate numbers are allowed within a single group.
- Each group (except the first one) must have a length strictly greater than the previous group.

Return an integer denoting the maximum number of groups you can create while satisfying these conditions.

## Examples

### Example 1
```
Input: usageLimits = [1,2,5]
Output: 3
Explanation: Group 1 = [2], Group 2 = [1,2], Group 3 = [0,1,2].
```

### Example 2
```
Input: usageLimits = [2,1,2]
Output: 2
Explanation: Group 1 = [0], Group 2 = [1,2].
```

### Example 3
```
Input: usageLimits = [1,1]
Output: 1
Explanation: Group 1 = [0].
```

## Constraints

- `1 <= usageLimits.length <= 10^5`
- `1 <= usageLimits[i] <= 10^9`
