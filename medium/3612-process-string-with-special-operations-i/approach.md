# Approach

**Tags:** `String`, `Simulation`, `Stack`

## Intuition

There is no hidden structure — each character is a direct instruction on the running buffer. Just carry out the operations in order. Since `s` has at most 20 characters (and only the few `#` before the final state can grow it), the buffer stays small, so a plain simulation is more than fast enough.

## Approach

Maintain `result` as a mutable list of characters and process each character of `s`:

1. Lowercase letter -> append it.
2. `'*'` -> pop the last character if the buffer is non-empty.
3. `'#'` -> double the buffer (`result += result`).
4. `'%'` -> reverse the buffer in place.

Join the list into a string at the end.

## Complexity

- **Time:** O(n * L) — for each of the `n` characters, an op may touch up to the current length `L` (reverse/duplicate); bounded and tiny here
- **Space:** O(L) — the result buffer

## Edge Cases

- `'*'` on an empty buffer -> no-op
- `'#'` on an empty buffer -> stays empty
- `'%'` on an empty or single-character buffer -> unchanged
- A string of only special characters -> result can end up empty
