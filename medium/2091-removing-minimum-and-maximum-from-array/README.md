# 2091. Removing Minimum and Maximum from Array

**Difficulty:** Medium  
**Topics:** `Array`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/removing-minimum-and-maximum-from-array](https://yral.dev/leetcode/removing-minimum-and-maximum-from-array)
- **Problem:** [Removing Minimum and Maximum from Array on LeetCode](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/)

## Idea

Deletions only ever come off the two ends, so whatever we do, the elements removed form a **prefix and a suffix**. The values in between are irrelevant — all that matters is where the minimum and maximum sit.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
