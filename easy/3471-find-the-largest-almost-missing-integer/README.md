# 3471. Find the Largest Almost Missing Integer

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Enumeration`, `Counting`  
**Complexity:** time O(n * k), space O(n)

- **Write-up:** [yral.dev/leetcode/find-the-largest-almost-missing-integer](https://yral.dev/leetcode/find-the-largest-almost-missing-integer)
- **Problem:** [Find the Largest Almost Missing Integer on LeetCode](https://leetcode.com/problems/find-the-largest-almost-missing-integer/)

## Idea

"Appears in exactly one subarray of size `k`" is a direct counting question, and with `n <= 50` there are at most 50 windows to inspect. For each window take the **set** of values it holds (a value appearing twice inside one window still counts as that one window), tally across windows, and keep the values whose tally is 1.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
