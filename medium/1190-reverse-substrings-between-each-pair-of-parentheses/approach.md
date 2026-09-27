# Approach

**Tags:** `String`, `Stack`

## Intuition

The obvious solution keeps a stack of buffers, reversing and merging one on every `)`. That rebuilds the same characters over and over, so deeply nested input like `((((abc))))` costs O(n^2).

A better view: reversing a bracketed group means reading it from the other end. So treat each bracket as a portal. Walk the string with a direction; whenever you land on a bracket, teleport to its partner and flip direction. Inside one pair of parentheses you end up reading right to left, which is the reversal. Inside two, you flip twice and read left to right again, which matches nested reversals cancelling out. Each character position is passed exactly once, so the whole thing is linear.

## Approach

1. First pass: push indices of `(` onto a stack; on `)`, pop and record `pair[open] = close` and `pair[close] = open`.
2. Second pass: `i = 0`, `step = 1`, and while `0 <= i < n`:
   - if `s[i]` is a bracket, set `i = pair[i]` and `step = -step`
   - otherwise append `s[i]`
   - `i += step`
3. Join the collected characters.

The walk terminates because every jump lands on the matching bracket and the following `i += step` moves outward from that group; the index eventually leaves the string on the right or the left, depending on the final direction.

## Complexity

- **Time:** O(n)
- **Space:** O(n) for the pair table and the output

## Edge Cases

- No brackets at all → the string is copied unchanged
- Empty groups `"()"` → no letters emitted, the walk steps straight through
- Deep nesting `"((((abcd))))"` → the direction flips four times, so the result is the original order; this is the case the O(n^2) stack approach handles badly
- Sibling groups `"(ab)(cd)"` → each reverses on its own, giving `"badc"`
- Nesting plus trailing letters (Example 3) needs the direction restored correctly on leaving an inner group
- Leading/trailing letters outside all brackets stay in place
