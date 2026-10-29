# 1189. Maximum Number of Balloons

**Difficulty:** Easy  
**Topics:** `Hash Table`, `String`, `Counting`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-number-of-balloons](https://yral.dev/leetcode/maximum-number-of-balloons)
- **Problem:** [Maximum Number of Balloons on LeetCode](https://leetcode.com/problems/maximum-number-of-balloons/)

## Idea

Forming the word "balloon" repeatedly is limited by whichever required letter runs out first. So count the letters in `text` and see how many copies of "balloon" the supply supports. The word uses `l` and `o` twice each, so their available counts must be halved before comparing.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
