# Smallest Palindromic Rearrangement II

**Difficulty:** Hard  
**LeetCode Link:** [Smallest Palindromic Rearrangement II](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/)

## Description

You are given a palindromic string `s` and an integer `k`.

Return the k-th lexicographically smallest palindromic permutation of `s`. If there are fewer than `k` distinct palindromic permutations, return an empty string.

Note: Different rearrangements that yield the same palindromic string are considered identical and are counted once.

## Examples

### Example 1
```
Input: s = "abba", k = 2
Output: "baab"
Explanation: The two distinct palindromic rearrangements are "abba" and "baab". k=2 -> "baab".
```

### Example 2
```
Input: s = "aa", k = 2
Output: ""
Explanation: Only one palindromic rearrangement "aa" exists; k=2 exceeds it.
```

### Example 3
```
Input: s = "bacab", k = 1
Output: "abcba"
Explanation: Distinct palindromes are "abcba" and "bacab". k=1 -> "abcba".
```

## Constraints

- `1 <= s.length <= 10^4`
- `s` consists of lowercase English letters.
- `s` is guaranteed to be palindromic.
- `1 <= k <= 10^6`
