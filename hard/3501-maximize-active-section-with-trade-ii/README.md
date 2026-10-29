# 3501. Maximize Active Section with Trade II

**Difficulty:** Hard  
**Topics:** `String`, `Binary Search`, `Sparse Table`, `Prefix Sum`, `Greedy`  
**Complexity:** time O(n log n + q log n), space O(n log n)

- **Write-up:** [yral.dev/leetcode/maximize-active-section-with-trade-ii](https://yral.dev/leetcode/maximize-active-section-with-trade-ii)
- **Problem:** [Maximize Active Section with Trade II on LeetCode](https://leetcode.com/problems/maximize-active-section-with-trade-ii/)

## Idea

Part I established the core accounting: on `t = '1' + substring + '1'`, a trade around a `1`-run `B` flanked by `0`-runs `A` and `C` nets exactly `A + C` (you lose `B`, then regain it inside the merged block). So per query:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
