# Check if Binary String Has at Most One Segment of Ones

**Difficulty:** Easy  
**LeetCode Link:** [Check if Binary String Has at Most One Segment of Ones](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)

## Description

Given a binary string `s` **without leading zeros**, return `true` if `s` contains **at most one contiguous segment of ones**. Otherwise, return `false`.

A contiguous segment of ones means that all `1`s appear together in a single block.

## Examples

### Example 1
```
Input: s = "1001"
Output: false
Explanation: The ones appear in two separate segments.
```

### Example 2
```
Input: s = "110"
Output: true
Explanation: All ones form one contiguous segment.
```

## Constraints

- `1 <= s.length <= 100`
- `s[i]` is either `'0'` or `'1'`
- `s[0]` is `'1'`
