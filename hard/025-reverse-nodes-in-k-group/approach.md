# Approach

**Tags:** `Linked List`, `Recursion`, `Two Pointers`

## Intuition

Process the list one group at a time. Before touching anything, confirm a full group of `k` nodes actually exists — the trailing remainder must be left untouched, so the check has to happen *first*, not after a partial reverse.

The reversal itself is the standard three-pointer walk, with one trick: seed `prev` with the node **after** the group rather than `null`. That way the group's original head (which becomes its tail) already points at the rest of the list when the loop ends, and no separate fix-up is needed.

A dummy node in front of `head` removes the special case for the very first group, since every group then has a real predecessor to relink.

## Approach

1. Create `dummy -> head`, set `groupPrev = dummy`.
2. Loop:
   - Walk `k` steps from `groupPrev` to find `kth`. If it's `null`, fewer than `k` nodes remain → stop, leaving them as-is.
   - Save `groupNext = kth.next`.
   - **Reverse the group:** with `prev = groupNext` and `cur = groupPrev.next`, repeatedly do `nxt = cur.next; cur.next = prev; prev = cur; cur = nxt` until `cur == groupNext`.
   - Relink: the group's old head (`groupPrev.next`) is now its tail, so save it as `tmp`, set `groupPrev.next = kth` (the new head), then `groupPrev = tmp`.
3. Return `dummy.next`.

## Complexity

- **Time:** O(n) — each node is visited once to check the group and once to reverse
- **Space:** O(1) — only a few pointers, satisfying the follow-up (a recursive version would use O(n/k) stack)

## Edge Cases

- `k == 1` → the list is returned unchanged
- `n` not a multiple of `k` → the final partial group stays in original order (Example 1's trailing `5`)
- `k == n` → the entire list is reversed once
- The group-existence check must precede the reversal, or a partial tail would be wrongly reversed
- Values must not be swapped — only pointers are rewired
