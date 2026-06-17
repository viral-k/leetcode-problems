# Process String with Special Operations II

**Difficulty:** Hard  
**LeetCode Link:** [Process String with Special Operations II](https://leetcode.com/problems/process-string-with-special-operations-ii/)

## Description

You are given a string `s` consisting of lowercase English letters and the special characters: `'*'`, `'#'`, and `'%'`.

You are also given an integer `k`.

Build a new string `result` by processing `s` according to the following rules from left to right:

- If the letter is a lowercase English letter append it to `result`.
- A `'*'` removes the last character from `result`, if it exists.
- A `'#'` duplicates the current `result` and appends it to itself.
- A `'%'` reverses the current `result`.

Return the `kth` character of the final string `result`. If `k` is out of the bounds of `result`, return `'.'`.

## Examples

### Example 1
```
Input: s = "a#b%*", k = 1
Output: "a"
Explanation: result becomes "ba"; the character at index 1 is 'a'.
```

### Example 2
```
Input: s = "cd%#*#", k = 3
Output: "d"
Explanation: result becomes "dcddcd"; the character at index 3 is 'd'.
```

### Example 3
```
Input: s = "z*#", k = 0
Output: "."
Explanation: result becomes ""; index 0 is out of bounds, so return '.'.
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters and special characters `'*'`, `'#'`, and `'%'`.
- `0 <= k <= 10^15`
- The length of `result` after processing `s` will not exceed `10^15`.
