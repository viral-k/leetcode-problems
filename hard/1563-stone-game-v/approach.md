# Approach

**Tags:** `Array`, `Dynamic Programming`, `Prefix Sum`, `Two Pointers`, `Game Theory`, `Interval DP`

## Intuition

Every round leaves Alice with a **contiguous subarray**, so the state is an interval. Let `dp[i][j]` = the maximum score obtainable starting from stones `i..j`. Splitting at `k` gives left sum `L` and right sum `R`; Bob discards the larger, so Alice gains the smaller side and continues on it. On a tie she picks whichever side is better.

```
dp[i][j] = max over k in [i, j-1] of:
    L < R  ->  L + dp[i][k]
    R < L  ->  R + dp[k+1][j]
    L == R ->  max(L + dp[i][k], R + dp[k+1][j])
```

That's O(n^3) — about 21M split evaluations at `n = 500`. It can be reduced to **O(n^2)** by noticing that for a fixed `i`, the split threshold (where `L` stops being smaller than `R`) only moves **rightward** as `j` grows, and that the two branch values are prefix/suffix maxima that can be cached.

## Approach

Prefix sums give `sum(i..j)` in O(1). Iterate `i` from `n-1` down to `0`, and `j` from `i+1` up — this order makes both `dp[i][k]` (same `i`, smaller `j`) and `dp[k+1][j]` (larger `i`) already available.

Maintain two tables:
- `mL[i][k] = max over k' in [i..k] of (sum(i..k') + dp[i][k'])` — best value when the **left** part `[i..k']` is kept
- `mR[k][j] = max over k' in [k..j] of (sum(k'..j) + dp[k'][j])` — best value when the **right** part `[k'..j]` is kept

For each `[i, j]`, advance a monotone pointer `p` = the smallest `k` with `2 * sum(i..k) >= total`:
- splits `k < p` keep the left → best is `mL[i][p-1]`
- splits `k >= p` keep the right → best is `mR[p+1][j]`
- if `2 * sum(i..p) == total` exactly, the tie at `k = p` lets Alice keep either side, so extend the left range to `mL[i][p]`

Then `dp[i][j] = max(left candidate, right candidate)`, and update `mL[i][j]`, `mR[i][j]` with the newly computed `dp[i][j]`.

## Complexity

- **Time:** O(n^2) — the pointer `p` advances monotonically for each `i`, so all inner work is amortized O(1)
- **Space:** O(n^2) — the `dp`, `mL`, `mR` tables

## Edge Cases

- Single stone → no split possible → score 0 (Example 3)
- All equal values (Example 2) → ties everywhere; the equality branch matters
- Two stones → keep the smaller one, then stop
- Score is bounded by ~2x the total sum (< 10^9), so `int` suffices, but `long` in Java is safer
- The monotone pointer must be reset per `i` and never moved backward
