# Approach

**Tags:** `String`, `Dynamic Programming`, `Backtracking`

## Intuition

Generating all `2^(2n)` strings and filtering the valid ones wastes almost all of the work. Instead build the string one character at a time and only ever place a character that keeps it extendable to a valid string. Two counters are enough: how many `(` have been placed and how many `)`.

A `(` is legal whenever fewer than `n` have been used. A `)` is legal whenever it has an unmatched `(` to close, i.e. `close < open`. Those two conditions are exactly the invariant for a valid prefix, so every leaf of the recursion is a complete well-formed string and nothing is ever discarded.

## Approach

1. Keep a mutable buffer and the counts `open` and `close`.
2. If the buffer length is `2n`, record the joined string and return.
3. If `open < n`, append `(`, recurse, pop.
4. If `close < open`, append `)`, recurse, pop.

Trying `(` before `)` at each step produces the results in lexicographic order, since `(` sorts before `)`.

## Complexity

- **Time:** O(C(n) * n) where `C(n)` is the nth Catalan number — one unit of work per output character, plus O(n) to materialise each string
- **Space:** O(n) for the buffer and the recursion stack, excluding the output

`C(8) = 1430`, so the output stays small across the whole constraint range.

## Edge Cases

- `n = 1` → `["()"]`, the only option
- `n = 8` → 1430 strings, the largest case; no risk of deep recursion since the depth is `2n = 16`
- The buffer must be popped after each recursive call, or branches leak characters into their siblings
- Checking the length rather than `close == n` as the stop condition works equally; both are reached at the same time
