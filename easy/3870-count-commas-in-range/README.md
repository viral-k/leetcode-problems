# 3870. Count Commas in Range

**Difficulty:** Easy  
**Topics:** `Math`, `Counting`  
**Complexity:** time O(log n), space O(1)

- **Write-up:** [yral.dev/leetcode/count-commas-in-range](https://yral.dev/leetcode/count-commas-in-range)
- **Problem:** [Count Commas in Range on LeetCode](https://leetcode.com/problems/count-commas-in-range/)

## Idea

A number with `d` digits carries `(d - 1) / 3` commas. Rather than computing that per number and summing, flip the counting around: ask **how many numbers earn each comma**.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
