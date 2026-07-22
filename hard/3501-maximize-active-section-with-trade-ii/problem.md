# Maximize Active Section with Trade II

**Difficulty:** Hard  
**LeetCode Link:** [Maximize Active Section with Trade II](https://leetcode.com/problems/maximize-active-section-with-trade-ii/)

## Description

You are given a binary string `s` of length `n`, where:

- `'1'` represents an active section.
- `'0'` represents an inactive section.

You can perform at most one trade to maximize the number of active sections in `s`. In a trade, you:

- Convert a contiguous block of `'1'`s that is surrounded by `'0'`s to all `'0'`s.
- Afterward, convert a contiguous block of `'0'`s that is surrounded by `'1'`s to all `'1'`s.

Additionally, you are given a 2D array `queries`, where `queries[i] = [l_i, r_i]` represents a substring `s[l_i...r_i]`.

For each query, determine the maximum possible number of active sections in `s` after making the optimal trade on the substring `s[l_i...r_i]`.

Return an array `answer`, where `answer[i]` is the result for `queries[i]`.

Note:
- For each query, treat `s[l_i...r_i]` as if it is augmented with a `'1'` at both ends, forming `t = '1' + s[l_i...r_i] + '1'`. The augmented `'1'`s do not contribute to the final count.
- The queries are independent of each other.

## Examples

### Example 1
```
Input: s = "01", queries = [[0,1]]
Output: [1]
```

### Example 2
```
Input: s = "0100", queries = [[0,3],[0,2],[1,3],[2,3]]
Output: [4,3,1,1]
```

### Example 3
```
Input: s = "1000100", queries = [[1,5],[0,6],[0,4]]
Output: [6,7,2]
```

### Example 4
```
Input: s = "01010", queries = [[0,3],[1,4],[1,3]]
Output: [4,4,2]
```

## Constraints

- `1 <= n == s.length <= 10^5`
- `1 <= queries.length <= 10^5`
- `s[i]` is either `'0'` or `'1'`.
- `queries[i] = [l_i, r_i]`
- `0 <= l_i <= r_i < n`
