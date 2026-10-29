# 2089. Find Target Indices After Sorting Array

**Difficulty:** Easy  
**Topics:** `Array`, `Binary Search`, `Sorting`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/find-target-indices-after-sorting-array](https://yral.dev/leetcode/find-target-indices-after-sorting-array)
- **Problem:** [Find Target Indices After Sorting Array on LeetCode](https://leetcode.com/problems/find-target-indices-after-sorting-array/)

## Idea

The obvious route is to sort and then scan for `target`, but sorting is more
than the question needs. After sorting, every copy of `target` sits in one
contiguous block, and where that block starts is decided by a single quantity:
how many elements are strictly smaller than `target`. Those are the only values
that can be placed before it. Elements larger than `target` land after the block
and cannot shift it.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
