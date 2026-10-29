# 3524. Find X Value of Array I

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Dynamic Programming`  
**Complexity:** time O(n * k), space O(k)

- **Write-up:** [yral.dev/leetcode/find-x-value-of-array-i](https://yral.dev/leetcode/find-x-value-of-array-i)
- **Problem:** [Find X Value of Array I on LeetCode](https://leetcode.com/problems/find-x-value-of-array-i/)

## Idea

Removing a prefix and a suffix leaves a contiguous non-empty subarray, so the task is to count subarrays by their product modulo `k`. With `k <= 5` there are only five possible residues, which makes a per-residue count over subarrays ending at the current index cheap to maintain.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
