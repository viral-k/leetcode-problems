# 1722. Minimize Hamming Distance After Swap Operations

**Difficulty:** Medium  
**Topics:** `Array`, `Union Find`, `Hash Table`  
**Complexity:** time O(n * α(n)), space O(n)

- **Write-up:** [yral.dev/leetcode/minimize-hamming-distance-after-swap-operations](https://yral.dev/leetcode/minimize-hamming-distance-after-swap-operations)
- **Problem:** [Minimize Hamming Distance After Swap Operations on LeetCode](https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/)

## Idea

If indices can swap (directly or transitively), elements at those indices can be freely rearranged. Use Union-Find to identify connected components of indices.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
