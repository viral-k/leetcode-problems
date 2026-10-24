# Approach

**Tags:** `Array`, `Sliding Window`, `Sorting`, `Bucket Sort`

## Intuition

The textbook solution slides a window of width `indexDiff` and keeps its values
in an ordered set, asking for the nearest neighbour of each new value. That is
O(n log k). Bucketing gets the same answer in O(n).

Choose the bucket width `w = valueDiff + 1`. Then:

- two values in the *same* bucket differ by at most `w - 1 = valueDiff`, so
  finding the bucket already occupied is an immediate answer, and
- two values within `valueDiff` of each other must sit in the same bucket or in
  adjacent ones. They cannot be two buckets apart, because that forces a gap of
  more than `w - 1`, which is at least `valueDiff`.

So each new value needs exactly three lookups: its own bucket and the two
neighbours. Nothing has to be ordered.

The map from bucket id to value holds at most one value per bucket, and that is
not an assumption to maintain — a second value landing in an occupied bucket is
precisely the condition that returns `true`, so the situation never persists.

The `+1` in the width is what makes `valueDiff = 0` fall out with no special
case: `w = 1` puts every integer in its own bucket, so sharing a bucket means
being equal.

## Approach

1. `w = valueDiff + 1`, and an empty map `bucket -> value`.
2. For each index `i`:
   - If `i > indexDiff`, evict `nums[i - indexDiff - 1]` from its bucket, so the
     map holds exactly the indices `[i - indexDiff, i - 1]`.
   - `b = floor(nums[i] / w)`. If `b` is in the map, return `true`.
   - If `b - 1` is in the map and `nums[i] - map[b-1] <= valueDiff`, return
     `true`. Likewise for `b + 1` with `map[b+1] - nums[i]`.
   - Store `map[b] = nums[i]`.
3. Return `false`.

No `abs` is needed in the neighbour comparisons: bucket `b - 1` only holds
values below `b * w`, which is at most `nums[i]`, so the difference is already
non-negative, and symmetrically for `b + 1`.

## Complexity

- **Time:** O(n) — three hash lookups and one eviction per element
- **Space:** O(min(n, indexDiff)) — the map never holds more than one window

## Edge Cases

- `valueDiff = 0` → `w = 1`, so a repeated bucket means an exactly equal value,
  which is example 1
- Negative values need *floor* division, not truncation toward zero. `-1 / 3`
  has to be `-1`; truncating gives `0` and lumps `-1` with the non-negatives,
  which misses pairs straddling zero. Python's `//` floors already, Java needs
  `Math.floorDiv`
- The difference `nums[i] - prev` reaches `2 * 10^9` and overflows a Java `int`,
  so the comparison is done in `long`
- `valueDiff = 10^9` → `w = 10^9 + 1`, which still fits an `int`
  (`2^31 - 1 = 2147483647`)
- `indexDiff = 1` → only adjacent indices are compared, and the eviction keeps
  exactly one value in the map
- `indexDiff >= n` → nothing is ever evicted, so the whole array is one window
- The window must be `[i - indexDiff, i - 1]`, so the eviction at step `i`
  removes index `i - indexDiff - 1`; evicting index `i - indexDiff` instead
  would narrow the window by one and miss valid pairs
- Eviction uses a defaulted pop, though the invariant guarantees the bucket is
  present: buckets only free up in index order, so the departing value is still
  the one occupying its bucket
