# Check if Array is Good

**Difficulty:** Easy  
**LeetCode Link:** [Check if Array is Good](https://leetcode.com/problems/check-if-array-is-good/)

## Description

You are given an integer array `nums`. We consider an array good if it is a permutation of an array `base[n]`.

`base[n] = [1, 2, ..., n - 1, n, n]`

In other words, it is an array of length `n + 1` which contains `1` to `n - 1` exactly once, plus two occurrences of `n`.

For example:

- `base[1] = [1, 1]`
- `base[3] = [1, 2, 3, 3]`

Return `true` if the given array is good, otherwise return `false`.

## Examples

### Example 1
```
Input: nums = [2,1,3]
Output: false
Explanation:
The maximum element is 3, so the only candidate is base[3].
base[3] has length 4, but nums has length 3.
```

### Example 2
```
Input: nums = [1,3,3,2]
Output: true
Explanation:
nums is a permutation of base[3] = [1,2,3,3].
```

### Example 3
```
Input: nums = [1,1]
Output: true
Explanation:
nums is a permutation of base[1] = [1,1].
```

### Example 4
```
Input: nums = [3,4,4,1,2,1]
Output: false
Explanation:
The maximum element is 4, so the only candidate is base[4].
base[4] has length 5, but nums has length 6.
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 200`
