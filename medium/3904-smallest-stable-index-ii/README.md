# 3904. Smallest Stable Index II

**Difficulty:** Medium  
**Topics:** `Array`, `Prefix Sum`, `Prefix Maximum`, `Suffix Minimum`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/smallest-stable-index-ii](https://yral.dev/leetcode/smallest-stable-index-ii)
- **Problem:** [Smallest Stable Index II on LeetCode](https://leetcode.com/problems/smallest-stable-index-ii/)

## Idea

Identical to part I; only the input size grows (`n` from 100 to 10^5), which rules out recomputing `max` and `min` per index — that would be O(n^2) and roughly 10^10 operations. The linear formulation already handles it.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
