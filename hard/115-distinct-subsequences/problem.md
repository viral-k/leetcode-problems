# Distinct Subsequences

**Difficulty:** Hard  
**LeetCode Link:** [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)

## Description

Given two strings `s` and `t`, return the number of distinct subsequences of `s` which equals `t`.

The test cases are generated so that the answer fits on a 32-bit signed integer.

## Examples

### Example 1
```
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation: There are 3 ways to generate "rabbit" from "rabbbit" by deleting one of the three b's.
```

### Example 2
```
Input: s = "babgbag", t = "bag"
Output: 5
Explanation: There are 5 ways to generate "bag" from "babgbag".
```

## Constraints

- `1 <= s.length, t.length <= 1000`
- `s` and `t` consist of English letters.
