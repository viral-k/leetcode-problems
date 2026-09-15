# Maximum Number of Non-overlapping Palindrome Substrings

**Difficulty:** Hard  
**LeetCode Link:** [Maximum Number of Non-overlapping Palindrome Substrings](https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/)

## Description

You are given a string `s` and a positive integer `k`.

Select a set of non-overlapping substrings from the string `s` that satisfy the following conditions:

- The length of each substring is at least `k`.
- Each substring is a palindrome.

Return the maximum number of substrings in an optimal selection.

A substring is a contiguous sequence of characters within a string.

## Examples

### Example 1
```
Input: s = "abaccdbbd", k = 3
Output: 2
Explanation: "aba" and "dbbd" are non-overlapping palindromes of length at least 3.
No selection has more than two.
```

### Example 2
```
Input: s = "adbcda", k = 2
Output: 0
Explanation: There is no palindrome substring of length at least 2.
```

## Constraints

- `1 <= k <= s.length <= 2000`
- `s` consists of lowercase English letters.
