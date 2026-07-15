# Ways to Make a Fair Array

**Difficulty:** Medium  
**LeetCode Link:** [Ways to Make a Fair Array](https://leetcode.com/problems/ways-to-make-a-fair-array/)

## Description

You are given an integer array `nums`. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.

For example, if `nums = [6,1,7,4,1]`:
- Choosing to remove index `1` results in `nums = [6,7,4,1]`.
- Choosing to remove index `2` results in `nums = [6,1,4,1]`.
- Choosing to remove index `4` results in `nums = [6,1,7,4]`.

An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.

Return the number of indices that you could choose such that after the removal, `nums` is fair.

## Examples

### Example 1
```
Input: nums = [2,1,6,4]
Output: 1
Explanation: Removing index 1 gives [2,6,4]: even sum 2+4=6, odd sum 6. Fair.
```

### Example 2
```
Input: nums = [1,1,1]
Output: 3
Explanation: Any removal leaves a fair array.
```

### Example 3
```
Input: nums = [1,2,3]
Output: 0
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`
