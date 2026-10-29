# 3499. Maximize Active Section with Trade I

**Difficulty:** Medium  
**Topics:** `String`, `Greedy`, `Enumeration`, `Two Pointers`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximize-active-section-with-trade-i](https://yral.dev/leetcode/maximize-active-section-with-trade-i)
- **Problem:** [Maximize Active Section with Trade I on LeetCode](https://leetcode.com/problems/maximize-active-section-with-trade-i/)

## Idea

Augment to `t = '1' + s + '1'` and view it as alternating runs. A trade must pick a `1`-run **surrounded by `0`s** — i.e. an interior `1`-run. Around it the runs look like:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
