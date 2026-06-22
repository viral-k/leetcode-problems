# Rearrange Characters to Make Target String

**Difficulty:** Easy  
**LeetCode Link:** [Rearrange Characters to Make Target String](https://leetcode.com/problems/rearrange-characters-to-make-target-string/)

## Description

You are given two 0-indexed strings `s` and `target`. You can take some letters from `s` and rearrange them to form new strings.

Return the maximum number of copies of `target` that can be formed by taking letters from `s` and rearranging them.

## Examples

### Example 1
```
Input: s = "ilovecodingonleetcode", target = "code"
Output: 2
Explanation: Two copies of "code" can be formed from the letters of s.
```

### Example 2
```
Input: s = "abcba", target = "abc"
Output: 1
Explanation: Only one 'c' is available, so at most one copy of "abc".
```

### Example 3
```
Input: s = "abbaccaddaeea", target = "aaaaa"
Output: 1
Explanation: There are 6 'a's, enough for one copy of "aaaaa" (needs 5).
```

## Constraints

- `1 <= s.length <= 100`
- `1 <= target.length <= 10`
- `s` and `target` consist of lowercase English letters.
