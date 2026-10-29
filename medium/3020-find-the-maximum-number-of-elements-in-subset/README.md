# 3020. Find the Maximum Number of Elements in Subset

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Enumeration`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/find-the-maximum-number-of-elements-in-subset](https://yral.dev/leetcode/find-the-maximum-number-of-elements-in-subset)
- **Problem:** [Find the Maximum Number of Elements in Subset on LeetCode](https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/)

## Idea

The valid arrangement `[x, x^2, ..., peak, ..., x^2, x]` is a symmetric chain of repeated squarings. Every value **below** the peak appears on both sides, so it needs **2 copies**; the **peak** appears once. The total length is always odd.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
