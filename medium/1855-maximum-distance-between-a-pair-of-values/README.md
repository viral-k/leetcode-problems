# 1855. Maximum Distance Between a Pair of Values

**Difficulty:** Medium  
**Topics:** `Array`, `Two Pointers`, `Binary Search`  
**Complexity:** time O(n + m), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-distance-between-a-pair-of-values](https://yral.dev/leetcode/maximum-distance-between-a-pair-of-values)
- **Problem:** [Maximum Distance Between a Pair of Values on LeetCode](https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/)

## Idea

Both arrays are sorted in descending order. Use two pointers: as nums1[i] decreases (increasing i), we can extend j further to find larger distances.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
