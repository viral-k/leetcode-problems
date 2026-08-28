# Lexicographically Smallest Palindromic Permutation Greater Than Target

**Difficulty:** Hard  
**LeetCode Link:** [Lexicographically Smallest Palindromic Permutation Greater Than Target](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)

## Description

You are given two strings `s` and `target`, each of length `n`, consisting of lowercase English letters.

Return the lexicographically smallest string that is both a palindromic permutation of `s` and strictly greater than `target`. If no such permutation exists, return an empty string.

## Examples

### Example 1
```
Input: s = "baba", target = "abba"
Output: "baab"
Explanation: The palindromic permutations of s are "abba" and "baab".
The smallest one strictly greater than target is "baab".
```

### Example 2
```
Input: s = "baba", target = "bbaa"
Output: ""
Explanation: Neither "abba" nor "baab" is strictly greater than "bbaa".
```

### Example 3
```
Input: s = "abc", target = "abb"
Output: ""
Explanation: s has no palindromic permutations.
```

### Example 4
```
Input: s = "aac", target = "abb"
Output: "aca"
Explanation: The only palindromic permutation of s is "aca", which is greater than target.
```

## Constraints

- `1 <= n == s.length == target.length <= 300`
- `s` and `target` consist of only lowercase English letters.
