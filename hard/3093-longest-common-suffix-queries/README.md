# 3093. Longest Common Suffix Queries

**Difficulty:** Hard  
**Topics:** `Array`, `String`, `Trie`  
**Complexity:** time O(total container length + total query length), space O(total container length)

- **Write-up:** [yral.dev/leetcode/longest-common-suffix-queries](https://yral.dev/leetcode/longest-common-suffix-queries)
- **Problem:** [Longest Common Suffix Queries on LeetCode](https://leetcode.com/problems/longest-common-suffix-queries/)

## Idea

A suffix becomes a prefix if we read the word from right to left. So we can insert every container word into a trie in reversed order.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
