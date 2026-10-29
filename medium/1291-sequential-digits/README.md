# 1291. Sequential Digits

**Difficulty:** Medium  
**Topics:** `Enumeration`, `String`, `Math`  
**Complexity:** time O(1)  (36 fixed candidates), space O(1)

- **Write-up:** [yral.dev/leetcode/sequential-digits](https://yral.dev/leetcode/sequential-digits)
- **Problem:** [Sequential Digits on LeetCode](https://leetcode.com/problems/sequential-digits/)

## Idea

Every number with sequential digits is a contiguous run from the string `"123456789"` — e.g. `2345` is the substring `"2345"`. Digits never wrap past 9, so there are very few such numbers (36 in total across lengths 2–9). Just generate them all and filter.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
