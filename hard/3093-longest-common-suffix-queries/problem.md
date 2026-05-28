# Longest Common Suffix Queries

**Difficulty:** Hard  
**LeetCode Link:** [Longest Common Suffix Queries](https://leetcode.com/problems/longest-common-suffix-queries/)

## Description

You are given two arrays of strings `wordsContainer` and `wordsQuery`.

For each `wordsQuery[i]`, you need to find a string from `wordsContainer` that has the longest common suffix with `wordsQuery[i]`. If there are two or more strings in `wordsContainer` that share the longest common suffix, find the string that is the smallest in length. If there are two or more such strings that have the same smallest length, find the one that occurred earlier in `wordsContainer`.

Return an array of integers `ans`, where `ans[i]` is the index of the string in `wordsContainer` that has the longest common suffix with `wordsQuery[i]`.

## Examples

### Example 1
```
Input: wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]
Output: [1,1,1]
Explanation:
For wordsQuery[0] = "cd", strings from wordsContainer that share the longest common suffix "cd" are at indices 0, 1, and 2. Among these, index 1 has the shortest length.
For wordsQuery[1] = "bcd", strings from wordsContainer that share the longest common suffix "bcd" are at indices 0, 1, and 2. Among these, index 1 has the shortest length.
For wordsQuery[2] = "xyz", there is no non-empty common suffix. The empty suffix is shared with all strings, and index 1 has the shortest length.
```

### Example 2
```
Input: wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh","acbfgh","acbfegh"]
Output: [2,0,2]
Explanation:
For wordsQuery[0] = "gh", all strings share suffix "gh"; index 2 has the shortest length.
For wordsQuery[1] = "acbfgh", only index 0 shares the longest suffix "fgh".
For wordsQuery[2] = "acbfegh", all strings share suffix "gh"; index 2 has the shortest length.
```

## Constraints

- `1 <= wordsContainer.length, wordsQuery.length <= 10^4`
- `1 <= wordsContainer[i].length <= 5 * 10^3`
- `1 <= wordsQuery[i].length <= 5 * 10^3`
- `wordsContainer[i]` consists only of lowercase English letters.
- `wordsQuery[i]` consists only of lowercase English letters.
- Sum of `wordsContainer[i].length` is at most `5 * 10^5`.
- Sum of `wordsQuery[i].length` is at most `5 * 10^5`.
