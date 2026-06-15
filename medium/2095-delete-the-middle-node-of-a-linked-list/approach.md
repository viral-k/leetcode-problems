# Approach

**Tags:** `Linked List`, `Two Pointers`

## Intuition

To delete a node from a singly linked list we need the node *before* it. Finding the middle in one pass is the classic slow/fast pointer trick: advance `fast` by two and `slow` by one, so when `fast` reaches the end, `slow` is at the middle. We just also keep a `prev` pointer trailing `slow` so we can splice the middle out.

For `⌊n/2⌋` 0-indexed, starting both pointers at the head and stepping while `fast` and `fast.next` exist lands `slow` exactly on the node to delete.

## Approach

1. Handle the single-node case up front: deleting index `0` leaves an empty list, so return `None`.
2. Walk `slow` (with `prev` behind it) one step and `fast` two steps until `fast` runs off the end.
3. `slow` now points at the middle node; unlink it with `prev.next = slow.next`.
4. Return `head`.

## Complexity

- **Time:** O(n) — single traversal
- **Space:** O(1) — only a few pointers

## Edge Cases

- Single node -> result is an empty list (`None`)
- Two nodes -> middle is index `1`, leaving only the head
- Odd vs even length -> the `fast`/`fast.next` loop condition picks `⌊n/2⌋` in both cases
