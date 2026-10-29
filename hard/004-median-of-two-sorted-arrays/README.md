# 4. Median of Two Sorted Arrays

**Difficulty:** Hard  
**Topics:** `Array`, `Binary Search`, `Divide and Conquer`  
**Complexity:** time O(log(min(m, n))), space O(1)

- **Write-up:** [yral.dev/leetcode/median-of-two-sorted-arrays](https://yral.dev/leetcode/median-of-two-sorted-arrays)
- **Problem:** [Median of Two Sorted Arrays on LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays/)

## Idea

The median splits the combined array into a left half and a right half of (almost) equal size, where every element on the left is `<=` every element on the right. We do not need to merge the arrays — we only need to find *where* to cut each one.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
