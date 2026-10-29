# 3043. Find the Length of the Longest Common Prefix

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`  
**Complexity:** time O((n + m) * D), where D is the maximum digit count, space O(n * D)

- **Write-up:** [yral.dev/leetcode/find-the-length-of-the-longest-common-prefix](https://yral.dev/leetcode/find-the-length-of-the-longest-common-prefix)
- **Problem:** [Find the Length of the Longest Common Prefix on LeetCode](https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/)

## Idea

For any number, repeatedly removing its last digit gives all of its prefixes from longest to shortest.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
