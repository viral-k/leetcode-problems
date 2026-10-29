# 3559. Number of Ways to Assign Edge Weights II

**Difficulty:** Hard  
**Topics:** `Tree`, `Binary Lifting`, `Depth-First Search`, `Math`  
**Complexity:** time O((n + q) log n), space O(n log n)

- **Write-up:** [yral.dev/leetcode/number-of-ways-to-assign-edge-weights-ii](https://yral.dev/leetcode/number-of-ways-to-assign-edge-weights-ii)
- **Problem:** [Number of Ways to Assign Edge Weights II on LeetCode](https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/)

## Idea

As in the easy version, only parity matters: weight `2` keeps parity, weight `1` flips it, so a path's cost is odd exactly when an odd number of its edges get weight `1`. For a path with `d` edges there are `2^d` assignments and exactly half are odd, giving `2^(d-1)` (and `0` when `d = 0`, i.e. `u == v`).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
