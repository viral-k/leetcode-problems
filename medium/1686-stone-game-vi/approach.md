# Approach

**Tags:** `Array`, `Math`, `Greedy`, `Sorting`, `Heap (Priority Queue)`, `Game Theory`

## Intuition

Taking a stone does two things at once: it **gains** you your own value for it, and it **denies** the opponent theirs. So the real importance of stone `i` — the swing in the final score difference — is `aliceValues[i] + bobValues[i]`, not either value alone.

That's why a stone can be worth grabbing even if you value it lowly: if the opponent values it highly, taking it is a defensive move. Example 3 shows this — Bob's high values on stones 1 and 2 dominate.

Once every stone is ranked by that combined weight, the game is a simple alternating pick: on each turn the current player should take the highest remaining swing. (An exchange argument confirms it: if a player ever skips the top-swing stone, swapping their pick to that stone never hurts them.)

## Approach

1. Sort the stone indices by `aliceValues[i] + bobValues[i]` **descending**.
2. Alice takes positions `0, 2, 4, ...` in that order; Bob takes `1, 3, 5, ...`.
3. Sum Alice's own values over her picks and Bob's own values over his.
4. Compare: `1` if Alice's total is larger, `-1` if Bob's is, `0` if equal.

## Complexity

- **Time:** O(n log n) — dominated by the sort
- **Space:** O(n) — the index ordering

## Edge Cases

- Single stone → Alice takes it; she wins unless her value is 0 (values are ≥ 1, so she always wins)
- Ties in `a[i] + b[i]` → any consistent order gives the same result
- A stone Alice values little but Bob values highly may still be her best pick (Example 3's logic)
- Totals reach at most 10^5 * 100 = 10^7, comfortably within `int`
- Verified against a full bitmask minimax for `n <= 8`
