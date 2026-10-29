# 940. Distinct Subsequences II

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`, `Counting`  
**Complexity:** time O(n), space O(26)

- **Write-up:** [yral.dev/leetcode/distinct-subsequences-ii](https://yral.dev/leetcode/distinct-subsequences-ii)
- **Problem:** [Distinct Subsequences II on LeetCode](https://leetcode.com/problems/distinct-subsequences-ii/)

## Idea

Counting subsequences is easy; counting **distinct** ones is the hard part, because a repeated letter regenerates subsequences that were already counted. The fix is to bucket the count by **last character**.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
