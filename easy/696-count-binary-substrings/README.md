# 696. Count Binary Substrings

**Difficulty:** Easy  
**Topics:** `String`, `Two Pointers`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/count-binary-substrings](https://yral.dev/leetcode/count-binary-substrings)
- **Problem:** [Count Binary Substrings on LeetCode](https://leetcode.com/problems/count-binary-substrings/)

## Idea

At each boundary between groups of 0s and 1s, count valid substrings. If previous group has `prev` chars and current has `curr` chars, we can form `min(prev, curr)` valid substrings centered at this boundary.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
