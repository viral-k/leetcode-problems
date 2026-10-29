# 1807. Evaluate the Bracket Pairs of a String

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `String`  
**Complexity:** time O(n + m), space O(n + m)

- **Write-up:** [yral.dev/leetcode/evaluate-the-bracket-pairs-of-a-string](https://yral.dev/leetcode/evaluate-the-bracket-pairs-of-a-string)
- **Problem:** [Evaluate the Bracket Pairs of a String on LeetCode](https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/)

## Idea

Nothing about the replacement depends on context, so this is a single left-to-right pass with a lookup table. Since brackets are never nested, the parser only needs one bit of state: inside a key or not. Building the result as a list of chunks and joining once avoids the quadratic cost of repeated string concatenation.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
