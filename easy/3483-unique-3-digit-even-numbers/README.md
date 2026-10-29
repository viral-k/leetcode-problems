# 3483. Unique 3-Digit Even Numbers

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Enumeration`, `Counting`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/unique-3-digit-even-numbers](https://yral.dev/leetcode/unique-3-digit-even-numbers)
- **Problem:** [Unique 3-Digit Even Numbers on LeetCode](https://leetcode.com/problems/unique-3-digit-even-numbers/)

## Idea

The obvious route is to permute the array and collect results in a set to drop duplicates. That works, but it does the deduplication after the fact and wastes effort whenever the input repeats a digit.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
