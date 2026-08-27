# Lexicographically Smallest Permutation Greater Than Target

**Difficulty:** Medium  
**LeetCode Link:** [Lexicographically Smallest Permutation Greater Than Target](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)

## Description

You are given two strings `s` and `target`, both having length `n`, consisting of lowercase English letters.

Return the lexicographically smallest permutation of `s` that is strictly greater than `target`. If no permutation of `s` is lexicographically strictly greater than `target`, return an empty string.

A string `a` is lexicographically strictly greater than a string `b` (of the same length) if in the first position where `a` and `b` differ, string `a` has a letter that appears later in the alphabet than the corresponding letter in `b`.

## Examples

### Example 1
```
Input: s = "abc", target = "bba"
Output: "bca"
Explanation: The permutations of s in order are "abc", "acb", "bac", "bca", "cab", "cba".
The smallest one strictly greater than "bba" is "bca".
```

### Example 2
```
Input: s = "leet", target = "code"
Output: "eelt"
Explanation: "eelt" is the smallest permutation of "leet", and it already exceeds "code".
```

### Example 3
```
Input: s = "baba", target = "bbaa"
Output: ""
Explanation: The largest permutation of "baba" is "bbaa", which is not strictly greater.
```

## Constraints

- `1 <= s.length == target.length <= 300`
- `s` and `target` consist of only lowercase English letters.
