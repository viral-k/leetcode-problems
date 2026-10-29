# 1081. Smallest Subsequence of Distinct Characters

**Difficulty:** Medium  
**Topics:** `String`, `Stack`, `Greedy`, `Monotonic Stack`, `Hash Table`  
**Complexity:** time O(n), space O(26)

- **Write-up:** [yral.dev/leetcode/smallest-subsequence-of-distinct-characters](https://yral.dev/leetcode/smallest-subsequence-of-distinct-characters)
- **Problem:** [Smallest Subsequence of Distinct Characters on LeetCode](https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/)

## Idea

We must keep exactly one copy of each distinct character, and want the result as small as possible lexicographically. Scanning left to right, a character already placed should be **dropped in favour of a smaller one** if we can safely re-add it later — i.e. if it occurs again further right. That "pop while the top is bigger and reappears later" rule is exactly a monotonic stack.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
