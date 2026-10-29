# 3721. Longest Balanced Subarray II

**Difficulty:** Hard  
**Topics:** `Array`, `Hash Table`, `Segment Tree`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/longest-balanced-subarray-ii](https://yral.dev/leetcode/longest-balanced-subarray-ii)
- **Problem:** [Longest Balanced Subarray II on LeetCode](https://leetcode.com/problems/longest-balanced-subarray-ii/)

## Idea

For each left boundary `l`, we need to find the rightmost `r` where `distinctOdd[l..r] == distinctEven[l..r]`. Define `diff[r] = distinctOdd - distinctEven` for subarray `[l..r]`. We need to find rightmost `r` where `diff[r] == 0`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
