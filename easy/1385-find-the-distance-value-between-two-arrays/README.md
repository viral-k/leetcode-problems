# 1385. Find the Distance Value Between Two Arrays

**Difficulty:** Easy  
**Topics:** `Array`, `Two Pointers`, `Binary Search`, `Sorting`  
**Complexity:** time O((n + m) log m), space O(m)

- **Write-up:** [yral.dev/leetcode/find-the-distance-value-between-two-arrays](https://yral.dev/leetcode/find-the-distance-value-between-two-arrays)
- **Problem:** [Find the Distance Value Between Two Arrays on LeetCode](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)

## Idea

`arr1[i]` counts when no `arr2` value lies within `d` of it, which means the range `[x - d, x + d]` holds no `arr2` value. Once `arr2` is sorted, one binary search answers that: find the smallest value `>= x - d` and check whether it is still `<= x + d`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
