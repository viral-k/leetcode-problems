# 3090. Maximum Length Substring with Two Occurrences

**Difficulty:** Easy  
**Topics:** `Hash Table`, `String`, `Sliding Window`  
**Complexity:** time O(n), space O(26)

- **Write-up:** [yral.dev/leetcode/maximum-length-substring-with-two-occurrences](https://yral.dev/leetcode/maximum-length-substring-with-two-occurrences)
- **Problem:** [Maximum Length Substring with Two Occurrences on LeetCode](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/)

## Idea

"At most two occurrences of each character" is preserved when a window shrinks, so a two-pointer sliding window applies: extend the right edge greedily, and whenever the constraint breaks, pull the left edge in until it holds again.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
