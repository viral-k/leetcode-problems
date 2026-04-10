# XOR After Range Multiplication Queries II

**Difficulty:** Hard  
**LeetCode Link:** [XOR After Range Multiplication Queries II](https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/)

## Description

You are given an integer array `nums` of length `n` and a 2D integer array `queries` of size `q`, where `queries[i] = [li, ri, ki, vi]`.

For each query, you must apply the following operations in order:

1. Set `idx = li`
2. While `idx <= ri`:
   - Update: `nums[idx] = (nums[idx] * vi) % (10^9 + 7)`
   - Set `idx += ki`

Return the **bitwise XOR** of all elements in `nums` after processing all queries.

## Examples

### Example 1
```
Input: nums = [1,1,1], queries = [[0,2,1,4]]
Output: 4
Explanation: Query multiplies every element by 4.
Array: [1,1,1] → [4,4,4]
XOR: 4 ^ 4 ^ 4 = 4
```

### Example 2
```
Input: nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]]
Output: 31
Explanation:
- Query 1 [1,4,2,3]: multiply indices 1,3 by 3 → [2,9,1,15,4]
- Query 2 [0,2,1,2]: multiply indices 0,1,2 by 2 → [4,18,2,15,4]
XOR: 4 ^ 18 ^ 2 ^ 15 ^ 4 = 31
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= q == queries.length <= 10^5`
- `queries[i] = [li, ri, ki, vi]`
- `0 <= li <= ri < n`
- `1 <= ki <= n`
- `1 <= vi <= 10^5`
