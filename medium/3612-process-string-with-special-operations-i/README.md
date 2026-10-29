# 3612. Process String with Special Operations I

**Difficulty:** Medium  
**Topics:** `String`, `Simulation`, `Stack`  
**Complexity:** time O(n * L), space O(L)

- **Write-up:** [yral.dev/leetcode/process-string-with-special-operations-i](https://yral.dev/leetcode/process-string-with-special-operations-i)
- **Problem:** [Process String with Special Operations I on LeetCode](https://leetcode.com/problems/process-string-with-special-operations-i/)

## Idea

There is no hidden structure — each character is a direct instruction on the running buffer. Just carry out the operations in order. Since `s` has at most 20 characters (and only the few `#` before the final state can grow it), the buffer stays small, so a plain simulation is more than fast enough.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
