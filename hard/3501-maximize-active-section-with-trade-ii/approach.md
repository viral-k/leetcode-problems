# Approach

**Tags:** `String`, `Binary Search`, `Sparse Table`, `Prefix Sum`, `Greedy`

## Intuition

Part I established the core accounting: on `t = '1' + substring + '1'`, a trade around a `1`-run `B` flanked by `0`-runs `A` and `C` nets exactly `A + C` (you lose `B`, then regain it inside the merged block). So per query:

```
answer = total_ones(s) + bestGain(l, r)
```

`total_ones(s)` is a constant — the characters outside `[l, r]` are untouched, and the ones inside are fully accounted for by the gain. What changes per query is `bestGain(l, r)` = the largest sum of two **adjacent zero-runs** inside the augmented substring.

The only subtlety versus part I is **clipping**: the first and last zero-runs touching `[l, r]` are cut off at the query boundary, while every run strictly inside keeps its full length.

## Approach

**Preprocessing:**
1. Collect all maximal zero-runs of `s` as `(start, end)` with full lengths.
2. Build `P[i] = len[i] + len[i+1]` — the adjacent-pair sums, which never depend on a query.
3. Build a **sparse table** over `P` for O(1) range-maximum queries.

**Per query `[l, r]`:**
1. Binary-search the range of runs intersecting `[l, r]`: `a` = first run with `end >= l`, `b` = last run with `start <= r`. If `a > b`, no zero-runs → gain 0.
2. If `a == b`, only one zero-run exists → no adjacent pair → gain 0.
3. Compute the clipped boundary lengths:
   - `lenA = min(end_a, r) - max(start_a, l) + 1`
   - `lenB = min(end_b, r) - max(start_b, l) + 1`
4. Take the max of:
   - the leading pair `(a, a+1)`: `lenA + (a+1 == b ? lenB : fullLen[a+1])`
   - the trailing pair `(b-1, b)`: `(b-1 == a ? lenA : fullLen[b-1]) + lenB`
   - the interior pairs: sparse-table range max of `P` over `[a+1, b-2]` (only when `a+1 <= b-2`)
5. `answer = total_ones + gain`.

## Complexity

- **Time:** O(n log n) preprocessing + O(log n) per query for the binary searches (range max is O(1))
- **Space:** O(n log n) — the sparse table

## Edge Cases

- Query range with no zeros, or only one zero-run → gain 0 (no valid trade)
- `a == b` must return 0, not `2 * lenA` — a single run has no adjacent partner
- `b == a + 1` → exactly one pair, both lengths clipped
- Boundary runs partially outside `[l, r]` → must use clipped, not full, lengths
- Answer counts ones across all of `s`, not just the substring (untouched characters still count)
