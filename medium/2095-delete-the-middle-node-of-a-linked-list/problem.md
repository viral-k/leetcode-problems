# Delete the Middle Node of a Linked List

**Difficulty:** Medium  
**LeetCode Link:** [Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

## Description

You are given the `head` of a linked list. Delete the middle node, and return the `head` of the modified linked list.

The middle node of a linked list of size `n` is the `⌊n / 2⌋th` node from the start using 0-based indexing, where `⌊x⌋` denotes the largest integer less than or equal to `x`.

- For `n` = `1`, `2`, `3`, `4`, and `5`, the middle nodes are `0`, `1`, `1`, `2`, and `2`, respectively.

## Examples

### Example 1
```
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation: n = 7, the middle node is index 3 (value 7), which is removed.
```

### Example 2
```
Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation: n = 4, the middle node is index 2 (value 3), which is removed.
```

### Example 3
```
Input: head = [2,1]
Output: [2]
Explanation: n = 2, the middle node is index 1 (value 1), which is removed.
```

## Constraints

- The number of nodes in the list is in the range `[1, 10^5]`.
- `1 <= Node.val <= 10^5`
