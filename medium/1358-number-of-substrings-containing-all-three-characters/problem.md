# Number of Substrings Containing All Three Characters

**Difficulty:** Medium  
**LeetCode Link:** [Number of Substrings Containing All Three Characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)

## Description

Given a string `s` consisting only of characters `a`, `b` and `c`.

Return the number of substrings containing at least one occurrence of all these characters `a`, `b` and `c`.

## Examples

### Example 1
```
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of a, b and c are
"abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc".
```

### Example 2
```
Input: s = "aaacb"
Output: 3
Explanation: The valid substrings are "aaacb", "aacb" and "acb".
```

### Example 3
```
Input: s = "abc"
Output: 1
```

## Constraints

- `3 <= s.length <= 5 * 10^4`
- `s` only consists of `a`, `b` or `c` characters.
