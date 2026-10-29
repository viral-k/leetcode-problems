# 1358. Number of Substrings Containing All Three Characters

**Difficulty:** Medium  
**Topics:** `Hash Table`, `String`, `Sliding Window`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/number-of-substrings-containing-all-three-characters](https://yral.dev/leetcode/number-of-substrings-containing-all-three-characters)
- **Problem:** [Number of Substrings Containing All Three Characters on LeetCode](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)

## Idea

Count valid substrings by their **right endpoint**. A substring ending at index `i` contains all three characters iff its start is at or before the most recent position where the *rarest-so-far* of the three was last seen. Concretely, if `last[a]`, `last[b]`, `last[c]` are the most recent indices of each character up to `i`, then any start `j` with `0 <= j <= min(last[a], last[b], last[c])` yields a valid substring.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
