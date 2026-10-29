# 3644. Maximum K to Sort a Permutation

**Difficulty:** Medium  
**Topics:** `Array`, `Bit Manipulation`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-k-to-sort-a-permutation](https://yral.dev/leetcode/maximum-k-to-sort-a-permutation)
- **Problem:** [Maximum K to Sort a Permutation on LeetCode](https://leetcode.com/problems/maximum-k-to-sort-a-permutation/)

## Idea

Let `S` be the set of misplaced values, `{nums[i] : nums[i] != i}`. Misplaced
positions in a permutation form cycles of length at least 2, so the values
sitting at misplaced positions are the same integers as those positions — `S` is
one well-defined set, usable as both. An empty `S` means the array is sorted and
the statement asks for 0.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
