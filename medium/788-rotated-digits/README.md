# 788. Rotated Digits

**Difficulty:** Medium  
**Topics:** `Math`, `Dynamic Programming`  
**Complexity:** time O(n log n), space O(1)

- **Write-up:** [yral.dev/leetcode/rotated-digits](https://yral.dev/leetcode/rotated-digits)
- **Problem:** [Rotated Digits on LeetCode](https://leetcode.com/problems/rotated-digits/)

## Idea

A number can only be good if every digit is valid after rotation. Digits `0`, `1`, and `8` stay the same, while `2`, `5`, `6`, and `9` change into another digit. Digits `3`, `4`, and `7` make the whole number invalid.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
