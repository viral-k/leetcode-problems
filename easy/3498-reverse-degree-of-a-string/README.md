# 3498. Reverse Degree of a String

**Difficulty:** Easy  
**Topics:** `String`, `Simulation`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/reverse-degree-of-a-string](https://yral.dev/leetcode/reverse-degree-of-a-string)
- **Problem:** [Reverse Degree of a String on LeetCode](https://leetcode.com/problems/reverse-degree-of-a-string/)

## Idea

The definition is already the algorithm. The only translation needed is from a character to its reversed-alphabet position: `'a'` is offset 0 from `'a'` and should map to 26, `'z'` is offset 25 and should map to 1, so the value is `26 - offset`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
