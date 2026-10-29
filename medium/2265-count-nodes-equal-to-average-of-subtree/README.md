# 2265. Count Nodes Equal to Average of Subtree

**Difficulty:** Medium  
**Topics:** `Tree`, `DFS`, `Binary Tree`, `Recursion`  
**Complexity:** time O(n), space O(h)

- **Write-up:** [yral.dev/leetcode/count-nodes-equal-to-average-of-subtree](https://yral.dev/leetcode/count-nodes-equal-to-average-of-subtree)
- **Problem:** [Count Nodes Equal to Average of Subtree on LeetCode](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/)

## Idea

Each node's test needs two facts about its own subtree: the sum of the values and how many there are. Both are simple aggregates of the same facts for the left and right subtrees, so a single post-order traversal can compute them bottom-up and answer every node on the way back.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
