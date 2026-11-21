# 3331. Find Subtree Sizes After Changes

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `String`, `Tree`, `Depth-First Search`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/find-subtree-sizes-after-changes](https://yral.dev/leetcode/find-subtree-sizes-after-changes)
- **Problem:** [Find Subtree Sizes After Changes on LeetCode](https://leetcode.com/problems/find-subtree-sizes-after-changes/)

## Idea

Every move uses the **original** tree, since all changes happen at once. The new parent of `x` is the nearest ancestor with the same letter. A DFS can track that directly. Keep `last[c]`, the deepest node on the current root-to-node path with letter `c`. When the DFS enters `x`, `last[s[x]]` is exactly the closest matching ancestor.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
