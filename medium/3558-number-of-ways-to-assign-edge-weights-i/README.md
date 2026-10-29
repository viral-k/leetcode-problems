# 3558. Number of Ways to Assign Edge Weights I

**Difficulty:** Medium  
**Topics:** `Tree`, `BFS`, `DFS`, `Math`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/number-of-ways-to-assign-edge-weights-i](https://yral.dev/leetcode/number-of-ways-to-assign-edge-weights-i)
- **Problem:** [Number of Ways to Assign Edge Weights I on LeetCode](https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/)

## Idea

Only the parity of the path cost matters. A weight of `2` is even and never changes parity; a weight of `1` is odd and flips it. So a path's total cost is odd exactly when an **odd number** of its edges are assigned weight `1`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
