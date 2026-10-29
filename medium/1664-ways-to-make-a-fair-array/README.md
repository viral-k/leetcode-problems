# 1664. Ways to Make a Fair Array

**Difficulty:** Medium  
**Topics:** `Array`, `Prefix Sum`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/ways-to-make-a-fair-array](https://yral.dev/leetcode/ways-to-make-a-fair-array)
- **Problem:** [Ways to Make a Fair Array on LeetCode](https://leetcode.com/problems/ways-to-make-a-fair-array/)

## Idea

Removing index `i` shifts every element after `i` one position left, which **flips its parity** (even index ↔ odd index). Elements before `i` keep their parity. So the fairness of the resulting array depends only on four running sums: even/odd sums of the prefix (before `i`) and even/odd sums of the suffix (after `i`) — with the suffix contributions swapped because of the parity flip.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
