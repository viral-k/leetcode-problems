# 115. Distinct Subsequences

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`  
**Complexity:** time O(m * n), space O(n)

- **Write-up:** [yral.dev/leetcode/distinct-subsequences](https://yral.dev/leetcode/distinct-subsequences)
- **Problem:** [Distinct Subsequences on LeetCode](https://leetcode.com/problems/distinct-subsequences/)

## Idea

Walk both strings from the left and ask, at each position, "how many ways can the first `j` characters of `t` be formed from the first `i` characters of `s`?" Every occurrence of `t` inside `s` is picked out by choosing, for each character of `t`, which position in `s` supplies it — so the count naturally decomposes into per-character decisions.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
