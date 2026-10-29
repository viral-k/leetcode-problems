# 3886. Sum of Sortable Integers

**Difficulty:** Hard  
**Topics:** `Array`, `Math`, `Sorting`, `Enumeration`  
**Complexity:** time O(n + sigma(n)), space O(n)

- **Write-up:** [yral.dev/leetcode/sum-of-sortable-integers](https://yral.dev/leetcode/sum-of-sortable-integers)
- **Problem:** [Sum of Sortable Integers on LeetCode](https://leetcode.com/problems/sum-of-sortable-integers/)

## Idea

A cyclic rotation permutes a block, so the multiset of values inside each block
never changes. That fixes the destination: a sortable `k` ends with an array
that is non-decreasing and has the same multiset as `nums`, so the result can
only be `sorted(nums)`. Block `i` therefore has to land exactly on
`sorted(nums)[i*k : (i+1)*k]`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
