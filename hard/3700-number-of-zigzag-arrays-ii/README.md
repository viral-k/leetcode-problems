# 3700. Number of ZigZag Arrays II

**Difficulty:** Hard  
**Topics:** `Dynamic Programming`, `Matrix Exponentiation`, `Combinatorics`  
**Complexity:** time O(m^3 log n) where m = r - l + 1, space O(m^2)

- **Write-up:** [yral.dev/leetcode/number-of-zigzag-arrays-ii](https://yral.dev/leetcode/number-of-zigzag-arrays-ii)
- **Problem:** [Number of ZigZag Arrays II on LeetCode](https://leetcode.com/problems/number-of-zigzag-arrays-ii/)

## Idea

This is the same counting problem as ZigZag I, but `n` can be up to `10^9`, so the O(n * m) per-length DP is too slow. The DP transition is *linear* in the state, so we can advance many lengths at once with matrix exponentiation. Here `m = r - l + 1 <= 75` is small, which makes an `m x m` matrix power cheap.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
