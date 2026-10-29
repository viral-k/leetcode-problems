# 796. Rotate String

**Difficulty:** Easy  
**Topics:** `String`, `String Matching`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/rotate-string](https://yral.dev/leetcode/rotate-string)
- **Problem:** [Rotate String on LeetCode](https://leetcode.com/problems/rotate-string/)

## Idea

Every rotation of `s` appears inside `s + s`. For example, if `s = "abcde"`, then `s + s = "abcdeabcde"`, which contains rotations like `"bcdea"` and `"cdeab"`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
