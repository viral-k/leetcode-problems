# 2287. Rearrange Characters to Make Target String

**Difficulty:** Easy  
**Topics:** `Hash Table`, `String`, `Counting`  
**Complexity:** time O(|s| + |target|), space O(1)

- **Write-up:** [yral.dev/leetcode/rearrange-characters-to-make-target-string](https://yral.dev/leetcode/rearrange-characters-to-make-target-string)
- **Problem:** [Rearrange Characters to Make Target String on LeetCode](https://leetcode.com/problems/rearrange-characters-to-make-target-string/)

## Idea

Each copy of `target` consumes a fixed number of each of its letters. So the number of copies we can build is limited by whichever target letter runs out first in `s`. Count both strings, then take the bottleneck.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
