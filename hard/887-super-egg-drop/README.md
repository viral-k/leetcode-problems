# 887. Super Egg Drop

**Difficulty:** Hard  
**Topics:** `Math`, `Dynamic Programming`, `Binary Search`  
**Complexity:** time O(k * m) ~ O(k log n), space O(k)

- **Write-up:** [yral.dev/leetcode/super-egg-drop](https://yral.dev/leetcode/super-egg-drop)
- **Problem:** [Super Egg Drop on LeetCode](https://leetcode.com/problems/super-egg-drop/)

## Idea

The naive DP "minimum moves for (eggs, floors)" is O(k * n^2) and is too slow for `n = 10^4`. The key is to **invert the question**: instead of asking how many moves a given number of floors needs, ask how many floors a given number of moves can cover.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
