# 1520. Maximum Number of Non-Overlapping Substrings

**Difficulty:** Hard  
**Topics:** `String`, `Greedy`  
**Complexity:** time O(26 * n), space O(1) beyond the output

- **Write-up:** [yral.dev/leetcode/maximum-number-of-non-overlapping-substrings](https://yral.dev/leetcode/maximum-number-of-non-overlapping-substrings)
- **Problem:** [Maximum Number of Non-Overlapping Substrings on LeetCode](https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/)

## Idea

Condition 2 says a chosen substring is closed under "if you contain one `c`, you contain every `c`". For a given character `c`, the shortest closed substring that starts at `first[c]` is forced: start at `first[c]`, and every character `x` you encounter while scanning pushes the right end out to at least `last[x]`. If some `x` inside has `first[x] < first[c]`, the substring cannot be closed without extending left past `first[c]`, so no valid substring starts there.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
