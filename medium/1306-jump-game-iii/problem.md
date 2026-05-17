# Jump Game III

**Difficulty:** Medium  
**LeetCode Link:** [Jump Game III](https://leetcode.com/problems/jump-game-iii/)

## Description

Given an array of non-negative integers `arr`, you are initially positioned at `start` index of the array.

When you are at index `i`, you can jump to:

- `i + arr[i]`
- `i - arr[i]`

Check if you can reach any index with value `0`.

You cannot jump outside of the array at any time.

## Examples

### Example 1
```
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
Possible paths to index 3 with value 0 include:
5 -> 4 -> 1 -> 3
5 -> 6 -> 4 -> 1 -> 3
```

### Example 2
```
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One path is 0 -> 4 -> 1 -> 3.
```

### Example 3
```
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation:
There is no way to reach index 1 with value 0.
```

## Constraints

- `1 <= arr.length <= 5 * 10^4`
- `0 <= arr[i] < arr.length`
- `0 <= start < arr.length`
