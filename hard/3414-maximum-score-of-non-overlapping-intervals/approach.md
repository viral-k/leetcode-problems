# Approach

**Tags:** `Array`, `Binary Search`, `Dynamic Programming`, `Sorting`

## Intuition

This is weighted interval scheduling with a cap of 4 picks, plus a tiebreak on the returned index array.

Sorting by left endpoint makes the structure usable: once intervals are in that order, taking the interval at position `p` forbids everything until the first interval whose left endpoint clears `r_p`. That boundary is a single binary search, and it never moves, so it can be precomputed once per position.

The cap of 4 just adds a second dimension to the state. From any position the choice is binary — skip this interval, or take it and jump past its conflicts with one fewer pick remaining.

**The tiebreak is the part that needs care.** The output is the chosen original indices in ascending order, but the DP walks intervals in left-endpoint order, so an interval taken early can carry a large index and land at the end of the sorted result. Each state therefore stores the full index tuple, not just a score, and states are ranked by `(-score, indices)`.

That composition is only valid if merging a fixed index into the lexicographically smaller suffix still yields the lexicographically smaller merged list. It does: two sorted suffixes of equal score agree up to their first difference, and inserting the same element into both preserves the relative order at that point. Verified against brute force on inputs built to maximise ties (identical weights, index order scrambled relative to position order).

## Approach

1. Sort positions by left endpoint, keeping the original index alongside.
2. Precompute `nxt[p]` = `bisect_right(lefts, r_p)`, the first position whose left endpoint is strictly greater than `r_p`. Strictness matters — touching boundaries count as overlapping.
3. `dp[p][k]` = best `(score, sorted index tuple)` using positions `>= p` with at most `k` picks; base `dp[n][k] = (0, ())`.
4. Sweep `p` from `n-1` down to `0`, and for each `k` in `1..4`:
   - **skip:** `dp[p+1][k]`
   - **take:** `(dp[nxt[p]][k-1].score + w_p, sorted(dp[nxt[p]][k-1].indices + (idx_p,)))`
   - keep whichever compares smaller under `(-score, indices)`
5. Answer is `dp[0][4]`'s index tuple.

## Complexity

- **Time:** O(n log n) — the sort and one binary search per interval; the DP is O(4n) with O(1) tuple work (at most 4 elements)
- **Space:** O(n) — the DP table holds 5 tuples of length <= 4 per position

## Edge Cases

- Intervals sharing an endpoint overlap, so `nxt` must use a strict comparison (`bisect_right` on the right endpoint)
- Equal scores reachable with different counts, e.g. one weight-5 interval versus weights 2 and 3, so index tuples of different lengths get compared; standard tuple comparison handles this
- Weights are all positive, so more intervals is never worse on score alone; the cap of 4 is what binds
- Scores reach `4 * 10^9`, which overflows 32-bit; use `long` in Java
- Single interval → that one index
- Duplicate left endpoints are fine; the binary search keys on the right endpoint
