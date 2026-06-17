# Approach

**Tags:** `String`, `Simulation`

## Intuition

The result can be as long as `10^15`, so we cannot build it (that was fine for the easy version, where `n <= 20`). But we do not need the whole string — only one character. The key observation: the index `k` in the final string can be traced *backwards* through the operations to the single original letter that produced it. At each step we only need the **length** of the buffer, not its contents.

So first compute the length after every step in a forward pass, then walk the operations in reverse, rewriting `k` to the position it occupied before each operation, until `k` lands exactly on an appended letter.

## Approach

1. **Forward pass:** compute `len[i]`, the buffer length after step `i`:
   - letter -> `+1`
   - `'*'` -> `-1` (if non-empty)
   - `'#'` -> `*2`
   - `'%'` -> unchanged
   Cap each length at a value above `10^15` to avoid overflow; valid inputs never need a larger exact value (see note).
2. If `k >= finalLength`, return `'.'`.
3. **Backward pass** over steps `i = n-1 .. 0`, with `before = len[i-1]` (the length before step `i`):
   - letter: if `k == before` (the index of the appended letter), return that letter; otherwise `k` is unchanged.
   - `'*'`: `k` is unchanged (only a trailing character was removed).
   - `'#'`: if `k >= before`, set `k -= before` (it lies in the duplicated second copy).
   - `'%'`: set `k = before - 1 - k` (reverse the position).

The backward pass always resolves to a letter because `k` is a valid in-bounds index.

## Complexity

- **Time:** O(n) — one forward pass and one backward pass
- **Space:** O(n) — the array of lengths

## Edge Cases

- `k` out of bounds (including an empty final result) -> `'.'`
- `'*'` / `'#'` on an empty buffer -> length stays `0`
- `'%'` mapping relies on the exact pre-op length, which is preserved (never wrongly capped) for valid inputs
- Large `k` near `10^15` -> handled with 64-bit integers in Java

## Note

Capping intermediate lengths is safe: since `'*'` removes at most one character, a length exceeding `~10^15` could not be brought back under `10^15` within `n <= 10^5` steps, so for inputs satisfying the "final length `<= 10^15`" guarantee, every relevant length stays well under the cap and is therefore stored exactly. The cap only protects against overflow on adversarial inputs.
