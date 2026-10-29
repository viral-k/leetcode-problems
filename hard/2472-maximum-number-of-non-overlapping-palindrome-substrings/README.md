# 2472. Maximum Number of Non-overlapping Palindrome Substrings

**Difficulty:** Hard  
**Topics:** `String`, `Greedy`, `Dynamic Programming`, `Two Pointers`  
**Complexity:** time O(n * k), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-number-of-non-overlapping-palindrome-substrings](https://yral.dev/leetcode/maximum-number-of-non-overlapping-palindrome-substrings)
- **Problem:** [Maximum Number of Non-overlapping Palindrome Substrings on LeetCode](https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/)

## Idea

The hard-looking part is that palindromes can be arbitrarily long, so a full search would consider O(n^2) candidate substrings. Two facts collapse that.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
