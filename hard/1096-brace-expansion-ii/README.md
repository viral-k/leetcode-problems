# 1096. Brace Expansion II

**Difficulty:** Hard  
**Topics:** `String`, `Backtracking`, `Stack`, `Breadth-First Search`  
**Complexity:** time O(total output size * word length), space O(total output size)

- **Write-up:** [yral.dev/leetcode/brace-expansion-ii](https://yral.dev/leetcode/brace-expansion-ii)
- **Problem:** [Brace Expansion II on LeetCode](https://leetcode.com/problems/brace-expansion-ii/)

## Idea

The grammar in the statement is already a parser specification, with the usual precedence: concatenation binds tighter than the comma. Writing it as three mutually recursive functions makes the two set operations fall out directly, one per production.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
