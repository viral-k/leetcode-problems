# Words Within Two Edits of Dictionary

**Difficulty:** Medium  
**LeetCode Link:** [Words Within Two Edits of Dictionary](https://leetcode.com/problems/words-within-two-edits-of-dictionary/)

## Description

You are given two string arrays, `queries` and `dictionary`. All words in each array comprise of lowercase English letters and have the same length.

In one **edit** you can take a word from `queries`, and change any letter in it to any other letter. Find all words from `queries` that, after a **maximum** of two edits, equal some word from `dictionary`.

Return a list of all words from `queries`, that match with some word from `dictionary` after a maximum of **two edits**. Return the words in the **same order** they appear in `queries`.

## Examples

### Example 1
```
Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
Output: ["word","note","wood"]
Explanation:
- "word" → "wood" (1 edit: r→o)
- "note" → "joke" (2 edits: n→j, t→k)
- "ants" cannot match any word in ≤2 edits
- "wood" matches exactly (0 edits)
```

### Example 2
```
Input: queries = ["yes"], dictionary = ["not"]
Output: []
Explanation: "yes" cannot match "not" in ≤2 edits.
```

## Constraints

- `1 <= queries.length, dictionary.length <= 100`
- `n == queries[i].length == dictionary[j].length`
- `1 <= n <= 100`
- All words are composed of lowercase English letters
