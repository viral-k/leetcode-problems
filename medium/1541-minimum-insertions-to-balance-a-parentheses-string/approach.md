# Approach

**Tags:** `String`, `Stack`, `Greedy`

## Intuition

The grammar is the usual one with a twist: a closer is `))`, two characters wide, while an opener is one. So the scan has to think in terms of closers rather than individual `)`.

Walk left to right keeping `open`, the number of `(` that still need their `))`. On reaching a `)`, the goal is to consume one whole closer:

- if the next character is also `)`, the closer is already there, take both
- if not, the closer is half-missing, so count one insertion and take the single `)`

Either way there is now a closer in hand, and it either cancels a pending `(` or, if none is pending, forces inserting a `(` to its left. Those two deficits cannot cancel each other, because a `(` must precede its closer, so an opener appearing later in the string can never serve an earlier closer.

Whatever `(` remain at the end each need a full `))`, hence the `2 *` on the leftover.

Processing closers greedily as soon as they appear is optimal: a `)` can only ever belong to the nearest closer, and pairing it with a later one would leave the earlier position needing its own insertion anyway.

## Approach

1. `i = 0`, `open = 0`, `adds = 0`.
2. While `i < n`:
   - `(` → `open += 1`, `i += 1`
   - `)` → consume a closer:
     - if `i + 1 < n and s[i+1] == ')'`, then `i += 2`
     - else `adds += 1` and `i += 1`
     - then if `open > 0`, `open -= 1`; else `adds += 1`
3. Return `adds + 2 * open`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- `"())"` → already balanced, 0 (Example 2)
- A lone trailing `)` (`"(()))"`) → the half-closer branch supplies the missing `)` (Example 1)
- Leading closers with no opener (`"))())("`) → one insertion for the `(`, two for the trailing opener, total 3 (Example 3)
- `"("` → 2, since one opener needs a whole `))`
- `")"` → 2: one `)` to complete the closer and one `(` in front of it
- `"(())"` is **not** balanced; two openers need four closing characters, so the answer is 2
- The answer can reach `2 * 10^5`, which still fits in `int`
- The lookahead must check `i + 1 < n` before indexing, since a `)` at the final position has no partner
