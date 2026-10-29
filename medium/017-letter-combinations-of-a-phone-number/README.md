# 17. Letter Combinations of a Phone Number

**Difficulty:** Medium  
**Topics:** `Hash Table`, `String`, `Backtracking`, `Recursion`  
**Complexity:** time O(4^n * n), space O(n) recursion depth (excluding output)

- **Write-up:** [yral.dev/leetcode/letter-combinations-of-a-phone-number](https://yral.dev/leetcode/letter-combinations-of-a-phone-number)
- **Problem:** [Letter Combinations of a Phone Number on LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## Idea

Every digit independently contributes one of its letters, so the full set of combinations is the Cartesian product of the per-digit letter groups. Backtracking builds each combination one digit at a time, branching over that digit's letters.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
