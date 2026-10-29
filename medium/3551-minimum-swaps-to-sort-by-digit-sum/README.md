# 3551. Minimum Swaps to Sort by Digit Sum

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Sorting`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/minimum-swaps-to-sort-by-digit-sum](https://yral.dev/leetcode/minimum-swaps-to-sort-by-digit-sum)
- **Problem:** [Minimum Swaps to Sort by Digit Sum on LeetCode](https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/)

## Idea

The target arrangement is not ambiguous. The values are distinct, so the key `(digit sum, value)` is distinct for every element and the sorted order is unique — there is no choice to make about where anything goes. The question is only how cheaply we can get there by swapping.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
