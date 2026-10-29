# 3713. Longest Balanced Substring I

**Difficulty:** Medium  
**Topics:** `String`, `Hash Table`, `Brute Force`  
**Complexity:** time O(n²), space O(1)

- **Write-up:** [yral.dev/leetcode/longest-balanced-substring-i](https://yral.dev/leetcode/longest-balanced-substring-i)
- **Problem:** [Longest Balanced Substring I on LeetCode](https://leetcode.com/problems/longest-balanced-substring-i/)

## Idea

A balanced substring has all distinct characters appearing the same number of times. If we have `d` distinct characters each appearing `f` times, the length is `d * f`. So we check if `distinct * maxFreq == length`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
