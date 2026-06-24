# Number of ZigZag Arrays II

**Difficulty:** Hard  
**LeetCode Link:** [Number of ZigZag Arrays II](https://leetcode.com/problems/number-of-zigzag-arrays-ii/)

## Description

You are given three integers `n`, `l`, and `r`.

A ZigZag array of length `n` is defined as follows:

- Each element lies in the range `[l, r]`.
- No two adjacent elements are equal.
- No three consecutive elements form a strictly increasing or strictly decreasing sequence.

Return the total number of valid ZigZag arrays.

Since the answer may be large, return it modulo `10^9 + 7`.

A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists). A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).

## Examples

### Example 1
```
Input: n = 3, l = 4, r = 5
Output: 2
Explanation: The valid arrays are [4,5,4] and [5,4,5].
```

### Example 2
```
Input: n = 3, l = 1, r = 3
Output: 10
Explanation: 10 valid ZigZag arrays of length 3 using values in [1, 3].
```

## Constraints

- `3 <= n <= 10^9`
- `1 <= l < r <= 75`
