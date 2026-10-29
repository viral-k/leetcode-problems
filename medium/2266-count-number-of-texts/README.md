# 2266. Count Number of Texts

**Difficulty:** Medium  
**Topics:** `Hash Table`, `Math`, `String`, `Dynamic Programming`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/count-number-of-texts](https://yral.dev/leetcode/count-number-of-texts)
- **Problem:** [Count Number of Texts on LeetCode](https://leetcode.com/problems/count-number-of-texts/)

## Idea

A run of the same digit can be broken into letters independently of the other runs (a different digit forces a boundary). So the total is the **product** over runs of "how many ways this run splits into letters".

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
