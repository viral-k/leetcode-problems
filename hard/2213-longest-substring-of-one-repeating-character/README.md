# 2213. Longest Substring of One Repeating Character

**Difficulty:** Hard  
**Topics:** `String`, `Segment Tree`, `Divide and Conquer`, `Array`  
**Complexity:** time O((n + k) log n), space O(n)

- **Write-up:** [yral.dev/leetcode/longest-substring-of-one-repeating-character](https://yral.dev/leetcode/longest-substring-of-one-repeating-character)
- **Problem:** [Longest Substring of One Repeating Character on LeetCode](https://leetcode.com/problems/longest-substring-of-one-repeating-character/)

## Idea

Recomputing the longest single-character run after each update would be O(n) per query — O(n * k) overall, far too slow. But the answer is a **mergeable** property: if you know, for two adjacent blocks, their longest internal run plus the runs touching their edges, you can combine them in O(1). That's exactly a segment tree over the string.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
