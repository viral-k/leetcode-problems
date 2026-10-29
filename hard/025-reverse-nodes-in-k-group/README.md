# 25. Reverse Nodes in k-Group

**Difficulty:** Hard  
**Topics:** `Linked List`, `Recursion`, `Two Pointers`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/reverse-nodes-in-k-group](https://yral.dev/leetcode/reverse-nodes-in-k-group)
- **Problem:** [Reverse Nodes in k-Group on LeetCode](https://leetcode.com/problems/reverse-nodes-in-k-group/)

## Idea

Process the list one group at a time. Before touching anything, confirm a full group of `k` nodes actually exists — the trailing remainder must be left untouched, so the check has to happen *first*, not after a partial reverse.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
