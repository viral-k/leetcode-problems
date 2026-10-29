# 3871. Count Commas in Range II

**Difficulty:** Medium  
**Topics:** `Math`, `Counting`  
**Complexity:** time O(log n), space O(1)

- **Write-up:** [yral.dev/leetcode/count-commas-in-range-ii](https://yral.dev/leetcode/count-commas-in-range-ii)
- **Problem:** [Count Commas in Range II on LeetCode](https://leetcode.com/problems/count-commas-in-range-ii/)

## Idea

Same counting argument as part I, but `n` now reaches `10^15`, so iterating over the range is out and the result no longer fits in 32 bits.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
