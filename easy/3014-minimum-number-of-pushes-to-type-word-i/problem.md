# Minimum Number of Pushes to Type Word I

**Difficulty:** Easy  
**LeetCode Link:** [Minimum Number of Pushes to Type Word I](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/)

## Description

You are given a string `word` containing distinct lowercase English letters.

Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key `2` is mapped with `["a","b","c"]`; we push the key once to type `"a"`, twice for `"b"`, and three times for `"c"`.

It is allowed to remap the keys numbered `2` to `9` to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string `word`.

Return the minimum number of pushes needed to type `word` after remapping the keys.

Note that `1`, `*`, `#`, and `0` do not map to any letters.

## Examples

### Example 1
```
Input: word = "abcde"
Output: 5
Explanation: Map each letter to its own key (a..e on keys 2..6), each costs 1 push. Total 5.
```

### Example 2
```
Input: word = "xycdefghij"
Output: 12
Explanation: 8 letters cost 1 push, 2 letters cost 2 pushes. Total 12.
```

## Constraints

- `1 <= word.length <= 26`
- `word` consists of lowercase English letters.
- All letters in `word` are distinct.
