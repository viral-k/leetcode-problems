# 2196. Create Binary Tree from Descriptions

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Tree`, `Binary Tree`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/create-binary-tree-from-descriptions](https://yral.dev/leetcode/create-binary-tree-from-descriptions)
- **Problem:** [Create Binary Tree from Descriptions on LeetCode](https://leetcode.com/problems/create-binary-tree-from-descriptions/)

## Idea

Each description tells us a parent-child link. If we can quickly look up (or create) a node by its value, building the tree is just wiring those links together. The only real question is finding the root: it is the one value that is a parent but never a child.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
