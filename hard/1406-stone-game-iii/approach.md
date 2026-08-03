# Approach

**Tags:** `Array`, `Math`, `Dynamic Programming`, `Game Theory`, `Suffix Sum`

## Intuition

Both players play the same suffix of the row (stones are always taken from the front), so the state is just "which index we start from". Tracking the **score difference** (current player minus opponent) collapses both scores into one value: after the current player grabs some stones, the opponent faces the remaining suffix and *their* optimal difference is subtracted.

## Approach

Let `dp[i]` = the best (current player − opponent) score difference obtainable starting at index `i`.

- Base: `dp[n] = 0` (no stones left).
- Transition: taking `k` stones (`k = 1, 2, 3`) yields `sum(stoneValue[i..i+k-1]) - dp[i+k]`; take the max over valid `k`:
  ```
  dp[i] = max_{k=1..3, i+k<=n} ( running_sum_k - dp[i+k] )
  ```
  Accumulate `running_sum` as `k` grows to avoid recomputation.

Process `i` from `n-1` down to `0`. Then:
- `dp[0] > 0` → `"Alice"`
- `dp[0] < 0` → `"Bob"`
- `dp[0] == 0` → `"Tie"`

## Complexity

- **Time:** O(n) — each index does O(3) work
- **Space:** O(n) for the `dp` array (O(1) achievable by keeping only the last 3 values)

## Edge Cases

- Fewer than 3 stones remaining → only `k` up to what's left
- Negative values (Example 2) → taking more stones can be worse; the `max` handles it
- Exact tie (Example 3) → `dp[0] == 0`
- Single stone → Alice takes it; sign of its value decides Alice/Bob/Tie
