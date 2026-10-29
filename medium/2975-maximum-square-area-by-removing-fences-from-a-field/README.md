# 2975. Maximum Square Area by Removing Fences from a Field

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Sorting`  
**Complexity:** time O(h² + v²), space O(h²)

- **Write-up:** [yral.dev/leetcode/maximum-square-area-by-removing-fences-from-a-field](https://yral.dev/leetcode/maximum-square-area-by-removing-fences-from-a-field)
- **Problem:** [Maximum Square Area by Removing Fences from a Field on LeetCode](https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/)

## Idea

We need to find the maximum square that can be formed by selecting two horizontal fences and two vertical fences such that the distance between them is equal. The boundary fences (at positions 1 and m for horizontal, 1 and n for vertical) are always present and cannot be removed.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
