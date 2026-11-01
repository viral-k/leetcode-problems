# 453. Minimum Moves to Equal Array Elements

**Difficulty:** Medium  
**Topics:** `Array`, `Math`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-moves-to-equal-array-elements](https://yral.dev/leetcode/minimum-moves-to-equal-array-elements)
- **Problem:** [Minimum Moves to Equal Array Elements on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)

## Idea

Adding 1 to every element except one changes the differences between elements exactly as subtracting 1 from that one element would. Only the differences matter for "all equal", so each move is really "decrease one element by 1". The cheapest target is then the minimum, since nothing can go below it without wasting moves, and every element `x` needs `x - min` moves to get there.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
