# Sum of Distances

**Difficulty:** Medium  
**LeetCode Link:** [Sum of Distances](https://leetcode.com/problems/sum-of-distances/)

## Description

You are given a 0-indexed integer array `nums`. There exists an array `arr` of length `nums.length`, where `arr[i]` is the sum of `|i - j|` over all `j` such that `nums[j] == nums[i]` and `j != i`. If there is no such `j`, set `arr[i]` to be `0`.

Return the array `arr`.

## Examples

### Example 1
```
Input: nums = [1,3,1,1,2]
Output: [5,0,3,4,0]
Explanation: 
- i=0: nums[0]==nums[2]==nums[3], arr[0] = |0-2| + |0-3| = 5
- i=1: no other 3, arr[1] = 0
- i=2: arr[2] = |2-0| + |2-3| = 3
- i=3: arr[3] = |3-0| + |3-2| = 4
- i=4: no other 2, arr[4] = 0
```

### Example 2
```
Input: nums = [0,5,3]
Output: [0,0,0]
Explanation: All elements are distinct, so arr[i] = 0 for all i.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`

**Note:** This question is the same as 2121: Intervals Between Identical Elements.
