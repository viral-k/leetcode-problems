# 1569. Number of Ways to Reorder Array to Get Same BST

**Difficulty:** Hard  
**Topics:** `Array`, `Math`, `Divide and Conquer`, `Dynamic Programming`, `Tree`, `Memoization`, `Combinatorics`, `Binary Tree`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/number-of-ways-to-reorder-array-to-get-same-bst](https://yral.dev/leetcode/number-of-ways-to-reorder-array-to-get-same-bst)
- **Problem:** [Number of Ways to Reorder Array to Get Same BST on LeetCode](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/)

## Idea

An insertion order determines the tree through one recursive rule: `nums[0]` becomes the root, every smaller value falls into the left subtree in the relative order it appeared, every larger value into the right. Two orders give the same tree exactly when they agree on the root and each side, read in order, rebuilds that side.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
