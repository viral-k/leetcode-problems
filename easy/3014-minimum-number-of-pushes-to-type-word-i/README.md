# 3014. Minimum Number of Pushes to Type Word I

**Difficulty:** Easy  
**Topics:** `Math`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-number-of-pushes-to-type-word-i](https://yral.dev/leetcode/minimum-number-of-pushes-to-type-word-i)
- **Problem:** [Minimum Number of Pushes to Type Word I on LeetCode](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/)

## Idea

There are 8 usable keys (2–9). Each key's first assigned letter costs 1 push, its second costs 2, its third costs 3, etc. To minimize total pushes, fill all 8 keys with one letter each (cost 1) before giving any key a second letter (cost 2), and so on. Since all letters in `word` are distinct, only the *count* of letters matters — not which letters they are.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
