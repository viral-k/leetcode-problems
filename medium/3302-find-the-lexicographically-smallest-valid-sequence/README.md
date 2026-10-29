# 3302. Find the Lexicographically Smallest Valid Sequence

**Difficulty:** Medium  
**Topics:** `String`, `Greedy`, `Two Pointers`, `Suffix`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/find-the-lexicographically-smallest-valid-sequence](https://yral.dev/leetcode/find-the-lexicographically-smallest-valid-sequence)
- **Problem:** [Find the Lexicographically Smallest Valid Sequence on LeetCode](https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/)

## Idea

We match `word2` against a subsequence of `word1`, allowing **at most one mismatch** (the single change), and want the lexicographically smallest index array. Two facts drive the greedy:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
