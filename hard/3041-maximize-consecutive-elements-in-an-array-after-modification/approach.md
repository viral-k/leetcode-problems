# Approach

**Tags:** `Array`, `Dynamic Programming`, `Sorting`

## Intuition

The selected values have to be distinct and form a run `v, v+1, ..., v+k-1`. Each element can stand for its own value `x` or for `x + 1`. In sorted order, an element can only extend a run that ends at `x - 1` (by staying `x`) or at `x` (by becoming `x + 1`). So track, for every value `v`, the longest run that ends exactly at `v`, using elements seen so far.

## Approach

1. Sort `nums`.
2. Keep `dp[v]` = longest consecutive run ending at value `v`, using the processed elements (missing = 0).
3. For each `x` in sorted order:
   - `dp[x + 1] = dp[x] + 1`: use this element as `x + 1`, extending a run that ended at `x`.
   - `dp[x] = dp[x - 1] + 1`: use it as `x`, extending a run that ended at `x - 1`.

   The `x + 1` update must come first, because it needs `dp[x]` from before this element. Otherwise one element would count twice, once as `x` and once as `x + 1`.
4. The answer is the largest value written to `dp`.

Sorting is what makes plain assignment safe. Every element that could write `dp[x]` or `dp[x + 1]` has value `x - 1`, `x` or `x + 1`, so it comes in order, and each new write is at least as large as the old one. A duplicate `x` works too: the first copy sets `dp[x]`, and the second turns that into `dp[x + 1] = dp[x] + 1`, so a pair `x, x` covers both `x` and `x + 1`.

## Complexity

- **Time:** O(n log n) for the sort; the DP pass is O(n)
- **Space:** O(n) for the dp map (Python) / O(max) for the dp array (Java)

## Edge Cases

- Single element: answer 1
- All values equal (`[5, 5, 5]`): only two copies help, giving `5, 6`. Answer 2.
- Duplicates filling a gap (`[1, 1, 3]`): becomes `1, 2, 3`. Answer 3.
- No usable neighbours (example 2, values 3 apart): answer 1
- `x + 1` can reach `10^6 + 1`, so the Java array needs size `max + 2`
