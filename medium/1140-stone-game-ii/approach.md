# Approach

**Tags:** `Array`, `Dynamic Programming`, `Prefix Sum`, `Game Theory`, `Memoization`

## Intuition

Piles are always taken from the front, so the remaining game is fully described by two things: the current index `i` and the current `M`. Rather than tracking both players' totals, note that whatever the current player does *not* take from the suffix, the opponent (playing optimally on the rest) will secure. So:

```
dp(i, M) = max over X in [1, 2M] of ( suffix(i) - dp(i + X, max(M, X)) )
```

where `suffix(i)` is the sum of all piles from `i` onward. The `suffix(i) - ...` framing converts "how much do I get" into a single value per state.

## Approach

1. Build suffix sums so `suffix(i)` is O(1).
2. Memoize `dp(i, M)`:
   - If `i >= n`, return 0 (nothing left).
   - If `2M >= n - i`, the current player can take everything → return `suffix(i)`.
   - Otherwise take the max over `X = 1..2M` of `suffix(i) - dp(i + X, max(M, X))`.
3. Answer is `dp(0, 1)`.

`M` never needs to exceed `n` (taking more piles than remain is capped), so the state space is O(n^2) and each state does O(n) work.

## Complexity

- **Time:** O(n^3) — O(n^2) states, O(n) transitions (about 10^6 at n = 100)
- **Space:** O(n^2) — the memo table

## Edge Cases

- Single pile → Alice takes it → answer is that pile
- `2M` covering the rest → current player takes everything (the early-exit branch)
- Greedy "take the most stones now" is wrong (Example 1: taking 2 piles first loses)
- Total stones ≤ 100 * 10^4 = 10^6, comfortably within `int`
