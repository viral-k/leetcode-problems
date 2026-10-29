# 1582. Special Positions in a Binary Matrix

**Difficulty:** Easy  
**Topics:** `Array`, `Matrix`  
**Complexity:** time O(m × n), space O(m + n)

- **Write-up:** [yral.dev/leetcode/special-positions-in-a-binary-matrix](https://yral.dev/leetcode/special-positions-in-a-binary-matrix)
- **Problem:** [Special Positions in a Binary Matrix on LeetCode](https://leetcode.com/problems/special-positions-in-a-binary-matrix/)

## Idea

A position is special if it's a `1` and it's the only `1` in both its row and column. Pre-compute the count of `1`s in each row and column, then check each `1` against these counts.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
