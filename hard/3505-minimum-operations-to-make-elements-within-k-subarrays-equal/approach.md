# Approach

**Tags:** `Array`, `Hash Table`, `Math`, `Dynamic Programming`, `Sliding Window`, `Heap (Priority Queue)`

## Intuition

The problem splits into two independent parts.

Making one window of `x` elements equal costs the sum of distances to its median, because the median minimises `sum(|a - t|)`. So every window start `s` has a fixed price `cost[s]`, and a sliding median gives all of them.

After that the values no longer matter. It's a selection problem: pick `k` non-overlapping intervals of length `x` with the smallest total price. Since `k <= 15`, a DP indexed by `(windows used, prefix length)` is small enough. Prices are never negative, so "at least `k`" and "exactly `k`" have the same answer.

## Approach

**Window costs.**

1. Sort the indices by `(value, index)` to give each element a unique rank, so the heaps can hold plain integers.
2. Keep two heaps: `lo` (max-heap) with the lower half and `hi` (min-heap) with the upper half. Track how many live elements each has and their sums, and hold `lo` to `ceil(x / 2)` elements, so its top is the median.
3. Removal is lazy. `side[i]` records which heap element `i` is in, so removing it only updates that heap's count and sum. Its entry is discarded when it reaches the top of a heap, recognised by its index being left of the window.
4. With `m` as the median, `cost = m * |lo| - sum(lo) + sum(hi) - m * |hi|`.

**Choosing windows.**

5. `dp[j][i]` = minimum cost of `j` windows inside the first `i` elements. `dp[0][i] = 0`, and `dp[j][i]` is infinite when `i < j * x`.
6. Either no chosen window ends at `i`, or one does: `dp[j][i] = min(dp[j][i-1], dp[j-1][i-x] + cost[i-x])`.
7. Only the previous row is needed. The answer is `dp[k][n]`.

## Complexity

- **Time:** O(n log n + n * k): the sort and heap work are O(n log n) in total, since each slide moves at most a couple of elements between heaps and every stale entry is popped once, and the DP is O(n * k)
- **Space:** O(n)

## Edge Cases

- `k * x == n`: the windows must fill the whole array, so there is exactly one choice
- `x == n`, `k == 1`: a single window
- `x == 2`: the two-element median is either element, and the cost is their difference
- Even `x`: `lo` holds the lower middle, and any value between the two middles costs the same
- Duplicate values: unique ranks stop equal elements from being confused during lazy removal
- All windows already equal: answer 0
- Negative values: only distances matter, and `m * |lo|` handles the sign correctly
- A window can cost about `2 * 10^11`, so Java uses `long` for sums and `dp`, and the infinity value must leave room for adding a cost without overflowing
