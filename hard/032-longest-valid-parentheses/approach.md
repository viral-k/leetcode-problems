# Approach

**Tags:** `String`, `Dynamic Programming`, `Stack`

## Intuition

Track two counters instead of positions. Scanning left to right and counting `'('` and `')'`:

- when the counts are equal, everything scanned since the last reset is balanced, giving a candidate length of `2 * close`
- when `close` exceeds `open`, the prefix has an unmatched `')'` that nothing to the right can fix, so no valid substring can span it; reset both counters and start fresh after it

That single pass finds every valid substring whose blocking character is an unmatched `')'`. It misses the mirror case: a run with leftover unmatched `'('`, like `"(()"`, where the counters never equalise and no reset ever fires. Scanning right to left with the roles swapped (reset when `open > close`) handles exactly those. The answer is the larger result of the two passes.

Both passes are needed and together they are sufficient: any valid substring is bounded on at least one side by a character that breaks the balance in one direction, and whichever side that is, the corresponding pass sees it as a reset point.

## Approach

1. `best = 0`.
2. Left to right with `open`/`close` at 0: increment the matching counter; if equal, `best = max(best, 2 * close)`; else if `close > open`, zero both.
3. Right to left with the same counters reset: increment; if equal, `best = max(best, 2 * open)`; else if `open > close`, zero both.
4. Return `best`.

## Complexity

- **Time:** O(n) — two passes
- **Space:** O(1)

The alternative stack-of-indices solution is also O(n) time but O(n) space, since a string of all `'('` pushes every index. The DP-over-positions variant is O(n) space too. The counter method is the only one of the three that is constant space, which is why it is used here.

## Edge Cases

- Empty string → 0, both loops do nothing
- No valid pairs (`"((("` or `")))"`) → 0
- Entire string valid (`"()()"`) → full length, found by the first pass
- Leftover unmatched `'('` (`"(()"`) → found only by the second pass, which is the reason it exists
- Leading unmatched `')'` (`")()()"`) → the first pass resets past it
- All `'('` followed by all `')'` (`"((()))"`) → the counters equalise exactly once, at the end
