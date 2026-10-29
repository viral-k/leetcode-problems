# 2904. Shortest and Lexicographically Smallest Beautiful String

**Difficulty:** Medium  
**Topics:** `String`, `Sliding Window`, `Greedy`, `Two Pointers`  
**Complexity:** time O(n^2), space O(n)

- **Write-up:** [yral.dev/leetcode/shortest-and-lexicographically-smallest-beautiful-string](https://yral.dev/leetcode/shortest-and-lexicographically-smallest-beautiful-string)
- **Problem:** [Shortest and Lexicographically Smallest Beautiful String on LeetCode](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/)

## Idea

A beautiful substring can always be trimmed so it **starts and ends on a `1`**: stripping leading or trailing zeros keeps the count of ones the same while shortening the string, which is strictly better for the primary objective. So every candidate worth considering is delimited by two ones.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
