# Approach

**Tags:** `String`, `Dynamic Programming`, `Stack`

## Intuition

A valid substring ends at some index `i`, and its length is `i` minus the index just *before* the substring started. If we always know that "boundary" index — the last position that cannot be part of the current valid run — we can compute the length in O(1) at each step. A stack of indices tracks exactly these boundaries.

## Approach

Maintain a stack of indices, seeded with a sentinel `-1` representing the position before a valid run that starts at index `0`.

1. For each character at index `i`:
   - If it is `'('`, push `i`.
   - If it is `')'`, pop the top:
     - If the stack becomes **empty**, this `')'` is unmatched and becomes a new boundary — push `i`.
     - Otherwise, the current valid substring runs from just after the new top to `i`, so update the answer with `i - stack.top`.
2. Return the best length found.

The element left on top after popping is always the index immediately before the current valid segment, which makes the length subtraction exact.

## Complexity

- **Time:** O(n) — single pass over the string
- **Space:** O(n) — the index stack in the worst case (e.g. all `'('`)

## Edge Cases

- Empty string -> `0`
- No valid pairs (e.g. `"((("` or `")))"`) -> `0`
- Entire string valid (e.g. `"()()"`) -> full length
- Leading unmatched `')'` -> handled by pushing it as a new boundary
