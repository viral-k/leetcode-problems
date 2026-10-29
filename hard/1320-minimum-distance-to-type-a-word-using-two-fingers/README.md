# 1320. Minimum Distance to Type a Word Using Two Fingers

**Difficulty:** Hard  
**Topics:** `String`, `Dynamic Programming`  
**Complexity:** time O(n × 27), space O(27)

- **Write-up:** [yral.dev/leetcode/minimum-distance-to-type-a-word-using-two-fingers](https://yral.dev/leetcode/minimum-distance-to-type-a-word-using-two-fingers)
- **Problem:** [Minimum Distance to Type a Word Using Two Fingers on LeetCode](https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/)

## Idea

At each step, decide which finger types the current character. Use DP to track the positions of both fingers and minimize total distance.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
