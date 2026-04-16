# Shortest Distance to Target String in a Circular Array

**Difficulty:** Easy  
**LeetCode Link:** [Shortest Distance to Target String in a Circular Array](https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/)

## Description

You are given a **0-indexed circular** string array `words` and a string `target`. A circular array means that the array's end connects to the array's beginning.

Formally, the next element of `words[i]` is `words[(i + 1) % n]` and the previous element of `words[i]` is `words[(i - 1 + n) % n]`, where `n` is the length of `words`.

Starting from `startIndex`, you can move to either the next word or the previous word with 1 step at a time.

Return the **shortest distance** needed to reach the string `target`. If the string `target` does not exist in `words`, return `-1`.

## Examples

### Example 1
```
Input: words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
Output: 1
Explanation: From index 1, we can reach "hello" at index 0 (1 step left) or index 4 (3 steps right).
Shortest distance is 1.
```

### Example 2
```
Input: words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
Output: 1
Explanation: From index 0, we can reach "leetcode" at index 2 (2 steps right or 1 step left).
Shortest distance is 1.
```

### Example 3
```
Input: words = ["i","eat","leetcode"], target = "ate", startIndex = 0
Output: -1
Explanation: "ate" does not exist in words.
```

## Constraints

- `1 <= words.length <= 100`
- `1 <= words[i].length <= 100`
- `words[i]` and `target` consist of only lowercase English letters
- `0 <= startIndex < words.length`
