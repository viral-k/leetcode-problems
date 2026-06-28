# Maximum Element After Decreasing and Rearranging

**Difficulty:** Medium  
**LeetCode Link:** [Maximum Element After Decreasing and Rearranging](https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/)

## Description

You are given an array of positive integers `arr`. Perform some operations (possibly none) on `arr` so that it satisfies these conditions:

- The value of the first element in `arr` must be `1`.
- The absolute difference between any 2 adjacent elements must be less than or equal to `1`. In other words, `abs(arr[i] - arr[i - 1]) <= 1` for each `i` where `1 <= i < arr.length` (0-indexed).

There are 2 types of operations that you can perform any number of times:

- Decrease the value of any element of `arr` to a smaller positive integer.
- Rearrange the elements of `arr` to be in any order.

Return the maximum possible value of an element in `arr` after performing the operations to satisfy the conditions.

## Examples

### Example 1
```
Input: arr = [2,2,1,2,1]
Output: 2
Explanation: We can rearrange arr so it becomes [1,2,2,2,1]. The largest element is 2.
```

### Example 2
```
Input: arr = [100,1,1000]
Output: 3
Explanation: Rearrange to [1,100,1000], decrease to [1,2,3]. The largest element is 3.
```

### Example 3
```
Input: arr = [1,2,3,4,5]
Output: 5
Explanation: The array already satisfies the conditions; the largest element is 5.
```

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i] <= 10^9`
