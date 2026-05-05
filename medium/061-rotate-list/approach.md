# Approach

**Tags:** `Linked List`, `Two Pointers`

## Intuition

Rotating a list of length `n` by `k` places is the same as rotating it by `k % n` places. If the effective rotation is `0`, the list does not change.

For a non-zero rotation, the new tail is the node at position `n - k % n - 1`, and the new head is the next node.

## Approach

1. Handle empty lists and single-node lists immediately.
2. Traverse the list once to find:
   - the length `n`
   - the current tail
3. Reduce `k` with `k %= n`.
4. If `k == 0`, return `head`.
5. Connect the current tail to the current head, temporarily making a cycle.
6. Move `n - k - 1` steps from the original head to find the new tail.
7. The node after the new tail is the new head.
8. Break the cycle by setting `new_tail.next = None`.

## Complexity

- **Time:** O(n) — the list is traversed a constant number of times
- **Space:** O(1) — only pointer variables are used

## Edge Cases

- Empty list → return `None`
- Single-node list → unchanged
- `k = 0` → unchanged
- `k` is larger than the list length → use `k % n`
- `k` is a multiple of `n` → unchanged
