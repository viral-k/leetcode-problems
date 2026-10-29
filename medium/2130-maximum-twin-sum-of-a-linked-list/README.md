# 2130. Maximum Twin Sum of a Linked List

**Difficulty:** Medium  
**Topics:** `Linked List`, `Two Pointers`, `Stack`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-twin-sum-of-a-linked-list](https://yral.dev/leetcode/maximum-twin-sum-of-a-linked-list)
- **Problem:** [Maximum Twin Sum of a Linked List on LeetCode](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)

## Idea

Twins are the `ith` and `(n-1-i)th` nodes — the node pairs you get by walking inward from both ends, exactly like a palindrome check. If we could traverse the second half in reverse while traversing the first half forward, each step would line up a twin pair.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
