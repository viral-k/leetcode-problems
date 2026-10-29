# 3655. XOR After Range Multiplication Queries II

**Difficulty:** Hard  
**Topics:** `Array`, `Bit Manipulation`, `Math`, `Sqrt Decomposition`  
**Complexity:** time O((N + Q) * sqrt(N)), space O(N + Q)

- **Write-up:** [yral.dev/leetcode/xor-after-range-multiplication-queries-ii](https://yral.dev/leetcode/xor-after-range-multiplication-queries-ii)
- **Problem:** [XOR After Range Multiplication Queries II on LeetCode](https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/)

## Idea

Two extreme approaches have tradeoffs:
- **Brute Force:** Fast for large k (few elements), slow for small k (many elements)
- **Difference Array:** Fast for small k (few unique values), slow for large k (many sweeps)

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
