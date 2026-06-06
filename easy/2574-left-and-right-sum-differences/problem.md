# Left and Right Sum Differences

**Difficulty:** Easy  
**LeetCode Link:** [Left and Right Sum Differences](https://leetcode.com/problems/left-and-right-sum-differences/)

## Description

You are given a 0-indexed integer array `nums` of size `n`.

Define two arrays `leftSum` and `rightSum` where:

- `leftSum[i]` is the sum of elements to the left of index `i` in `nums`. If there is no such element, `leftSum[i] = 0`.
- `rightSum[i]` is the sum of elements to the right of index `i` in `nums`. If there is no such element, `rightSum[i] = 0`.

Return an integer array `answer` of size `n` where `answer[i] = |leftSum[i] - rightSum[i]|`.

## Examples

### Example 1
```
Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation:
leftSum = [0,10,14,22]
rightSum = [15,11,3,0]
answer = [15,1,11,22]
```

### Example 2
```
Input: nums = [1]
Output: [0]
Explanation: Both left and right sums are 0.
```

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^5`
