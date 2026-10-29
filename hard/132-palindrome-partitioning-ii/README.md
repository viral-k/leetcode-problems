# 132. Palindrome Partitioning II

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`  
**Complexity:** time O(n^2), space O(n^2)

- **Write-up:** [yral.dev/leetcode/palindrome-partitioning-ii](https://yral.dev/leetcode/palindrome-partitioning-ii)
- **Problem:** [Palindrome Partitioning II on LeetCode](https://leetcode.com/problems/palindrome-partitioning-ii/)

## Idea

Minimum cuts is a shortest-path style DP over positions: `cuts[i]` is the answer for the suffix starting at `i`, and the choice at `i` is where the first palindromic piece ends. So `cuts[i] = 1 + min(cuts[j+1])` over all `j` such that `s[i..j]` is a palindrome, with 0 when the whole suffix is already a palindrome.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
