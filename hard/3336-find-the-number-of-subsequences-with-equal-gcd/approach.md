# Approach

**Tags:** `Array`, `Dynamic Programming`, `Number Theory`, `Math`

## Intuition

Each index of `nums` is independently placed into `seq1`, into `seq2`, or into neither — three choices. What matters about the two growing subsequences is only their current GCDs, and GCD values never exceed `max(nums) <= 200`. So a DP over `(gcd1, gcd2)` captures everything, and we count assignments where both are non-empty and the GCDs match.

## Approach

- State `dp[g1][g2]` = number of ways to assign the processed prefix so that `seq1` has GCD `g1` and `seq2` has GCD `g2`. Use `0` to denote "still empty" (with the convention `gcd(0, x) = x`).
- Initialize `dp[0][0] = 1` (both empty).
- For each `num`, every existing state `(g1, g2)` with count `c` branches into three:
  - **skip:** `(g1, g2)` unchanged
  - **add to seq1:** `(gcd(g1, num), g2)`
  - **add to seq2:** `(g1, gcd(g2, num))`
  Accumulate into a fresh next-layer table (mod `1e9 + 7`).
- Answer: `sum over g >= 1 of dp[g][g]` — both subsequences non-empty and equal GCD.

Using a fresh next table per element keeps each element's three choices independent (no double-application).

## Complexity

- **Time:** O(n · V²) where V = max value (≤ 200)
- **Space:** O(V²) — two DP tables

## Edge Cases

- Excluding `g = 0` guarantees both subsequences are non-empty
- Repeated values (e.g. all 1s) inflate counts — handled naturally by the per-index branching
- Disjointness is automatic: each index picks exactly one of the three destinations
- Single element → no valid pair (can't fill both) → 0
