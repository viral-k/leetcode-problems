# 1784. Check if Binary String Has at Most One Segment of Ones

**Difficulty:** Easy  
**Topics:** `String`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/check-if-binary-string-has-at-most-one-segment-of-ones](https://yral.dev/leetcode/check-if-binary-string-has-at-most-one-segment-of-ones)
- **Problem:** [Check if Binary String Has at Most One Segment of Ones on LeetCode](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)

## Idea

Since the string has no leading zeros (starts with `'1'`), if there's more than one segment of ones, we must see the pattern `"01"` — a zero followed by a one.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
