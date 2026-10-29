# 3699. Number of ZigZag Arrays I

**Difficulty:** Hard  
**Topics:** `Dynamic Programming`, `Prefix Sum`, `Combinatorics`  
**Complexity:** time O(n * m) where m = r - l + 1, space O(m)

- **Write-up:** [yral.dev/leetcode/number-of-zigzag-arrays-i](https://yral.dev/leetcode/number-of-zigzag-arrays-i)
- **Problem:** [Number of ZigZag Arrays I on LeetCode](https://leetcode.com/problems/number-of-zigzag-arrays-i/)

## Idea

"No two adjacent equal" plus "no three consecutive strictly monotonic" forces a strict **zigzag**: the sequence must alternate up, down, up, down (or down, up, down, ...). Only the relative order of values matters, so shift the range `[l, r]` to `0 .. m-1` where `m = r - l + 1`; the count depends only on `n` and `m`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
