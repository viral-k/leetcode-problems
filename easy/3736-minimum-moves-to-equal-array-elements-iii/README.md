# 3736. Minimum Moves to Equal Array Elements III

**Difficulty:** Easy  
**Topics:** `Array`, `Math`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-moves-to-equal-array-elements-iii](https://yral.dev/leetcode/minimum-moves-to-equal-array-elements-iii)
- **Problem:** [Minimum Moves to Equal Array Elements III on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/)

## Idea

Moves only increase values, so no element can come down to meet the others. The common target has to be at least `max(nums)`, and every step above it costs `n` extra moves. So the target is the max, and each element `x` needs `max - x` moves.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
