# Maximum Twin Sum of a Linked List

**Difficulty:** Medium  
**LeetCode Link:** [Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)

## Description

In a linked list of size `n`, where `n` is even, the `ith` node (0-indexed) of the linked list is known as the twin of the `(n-1-i)th` node, if `0 <= i <= (n / 2) - 1`.

- For example, if `n = 4`, then node `0` is the twin of node `3`, and node `1` is the twin of node `2`. These are the only nodes with twins for `n = 4`.

The twin sum is defined as the sum of a node and its twin.

Given the `head` of a linked list with even length, return the maximum twin sum of the linked list.

## Examples

### Example 1
```
Input: head = [5,4,2,1]
Output: 6
Explanation: Twin sums are 5+1 = 6 and 4+2 = 6. Maximum is 6.
```

### Example 2
```
Input: head = [4,2,2,3]
Output: 7
Explanation: Twin sums are 4+3 = 7 and 2+2 = 4. Maximum is 7.
```

### Example 3
```
Input: head = [1,100000]
Output: 100001
Explanation: The only twin sum is 1 + 100000 = 100001.
```

## Constraints

- The number of nodes in the list is an even integer in the range `[2, 10^5]`.
- `1 <= Node.val <= 10^5`
