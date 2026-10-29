# 3841. Palindromic Path Queries in a Tree

**Difficulty:** Hard  
**Topics:** `Array`, `String`, `Divide and Conquer`, `Bit Manipulation`, `Tree`, `Depth-First Search`, `Binary Indexed Tree`, `Segment Tree`  
**Complexity:** time O((n + q) log n), space O(n log n)

- **Write-up:** [yral.dev/leetcode/palindromic-path-queries-in-a-tree](https://yral.dev/leetcode/palindromic-path-queries-in-a-tree)
- **Problem:** [Palindromic Path Queries in a Tree on LeetCode](https://leetcode.com/problems/palindromic-path-queries-in-a-tree/)

## Idea

A multiset of letters can be rearranged into a palindrome exactly when at most
one letter appears an odd number of times. Only parity matters, so a path can
be summarised by a 26-bit mask where bit `c` is the parity of letter `c`, and
the path is good when the mask has at most one bit set.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
