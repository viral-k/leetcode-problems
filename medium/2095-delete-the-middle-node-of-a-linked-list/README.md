# 2095. Delete the Middle Node of a Linked List

**Difficulty:** Medium  
**Topics:** `Linked List`, `Two Pointers`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/delete-the-middle-node-of-a-linked-list](https://yral.dev/leetcode/delete-the-middle-node-of-a-linked-list)
- **Problem:** [Delete the Middle Node of a Linked List on LeetCode](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

## Idea

To delete a node from a singly linked list we need the node *before* it. Finding the middle in one pass is the classic slow/fast pointer trick: advance `fast` by two and `slow` by one, so when `fast` reaches the end, `slow` is at the middle. We just also keep a `prev` pointer trailing `slow` so we can splice the middle out.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
