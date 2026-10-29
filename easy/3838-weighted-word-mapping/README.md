# 3838. Weighted Word Mapping

**Difficulty:** Easy  
**Topics:** `Array`, `String`, `Hash Table`  
**Complexity:** time O(L) over all characters, space O(w) for the output

- **Write-up:** [yral.dev/leetcode/weighted-word-mapping](https://yral.dev/leetcode/weighted-word-mapping)
- **Problem:** [Weighted Word Mapping on LeetCode](https://leetcode.com/problems/weighted-word-mapping/)

## Idea

Each word maps to a single character through three direct steps: sum its letter weights, reduce modulo 26, then translate that index to a letter in reverse alphabetical order. There is nothing to optimize — just apply the rule to every word and concatenate.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
