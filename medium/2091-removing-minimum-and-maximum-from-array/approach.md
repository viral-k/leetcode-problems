# Approach

**Tags:** `Array`, `Greedy`

## Intuition

Deletions only ever come off the two ends, so whatever we do, the elements removed form a **prefix and a suffix**. The values in between are irrelevant — all that matters is where the minimum and maximum sit.

Let `lo` and `hi` be the two positions, ordered so `lo <= hi`. To remove both, every strategy falls into one of three shapes:

- **Take both from the front** — the prefix must reach the further one: `hi + 1` deletions.
- **Take both from the back** — the suffix must reach the nearer one: `n - lo` deletions.
- **Take one from each end** — a prefix covering `lo` (`lo + 1`) plus a suffix covering `hi` (`n - hi`).

Nothing else is possible, so the answer is just the smallest of the three.

## Approach

1. Scan once to find the index of the minimum and the index of the maximum.
2. Set `lo = min(i, j)`, `hi = max(i, j)`.
3. Return `min(hi + 1, n - lo, (lo + 1) + (n - hi))`.

## Complexity

- **Time:** O(n) — a single pass to locate both indices
- **Space:** O(1)

## Edge Cases

- Single element (Example 3) → it is both min and max; `lo == hi == 0` and the front/back options both give 1, beating the split option's 2
- Min and max adjacent → the front or back option usually wins (Example 2)
- Min and max at opposite ends → the split option costs exactly 2
- Values are distinct, so the min and max positions are unambiguous
- The split option can be worse than either single-sided option, so all three must be compared
