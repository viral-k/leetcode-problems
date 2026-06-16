# Process String with Special Operations I

**Difficulty:** Medium  
**LeetCode Link:** [Process String with Special Operations I](https://leetcode.com/problems/process-string-with-special-operations-i/)

## Description

You are given a string `s` consisting of lowercase English letters and the special characters: `*`, `#`, and `%`.

Build a new string `result` by processing `s` according to the following rules from left to right:

- If the letter is a lowercase English letter append it to `result`.
- A `'*'` removes the last character from `result`, if it exists.
- A `'#'` duplicates the current `result` and appends it to itself.
- A `'%'` reverses the current `result`.

Return the final string `result` after processing all characters in `s`.

## Examples

### Example 1
```
Input: s = "a#b%*"
Output: "ba"
Explanation:
'a' -> "a"
'#' -> "aa"
'b' -> "aab"
'%' -> "baa"
'*' -> "ba"
```

### Example 2
```
Input: s = "z*#"
Output: ""
Explanation:
'z' -> "z"
'*' -> ""
'#' -> ""
```

## Constraints

- `1 <= s.length <= 20`
- `s` consists of only lowercase English letters and special characters `*`, `#`, and `%`.
