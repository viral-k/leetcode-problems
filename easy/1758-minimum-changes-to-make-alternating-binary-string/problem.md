# Minimum Changes To Make Alternating Binary String

**Difficulty:** Easy  
**LeetCode Link:** [Minimum Changes To Make Alternating Binary String](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/)

## Description

You are given a string `s` consisting only of the characters `'0'` and `'1'`. In one operation, you can change any `'0'` to `'1'` or vice versa.

The string is called **alternating** if no two adjacent characters are equal.

For example:
- `"010"` is alternating
- `"0100"` is not alternating

Return the **minimum number of operations** needed to make `s` alternating.

## Examples

### Example 1
```
Input: s = "0100"
Output: 1
Explanation: Changing the last character to '1' makes "0101" which is alternating.
```

### Example 2
```
Input: s = "10"
Output: 0
Explanation: The string is already alternating.
```

### Example 3
```
Input: s = "1111"
Output: 2
Explanation: Two possible alternating strings are "0101" and "1010".
Minimum changes needed = 2.
```

## Constraints

- `1 <= s.length <= 10^4`
- `s[i]` is either `'0'` or `'1'`
