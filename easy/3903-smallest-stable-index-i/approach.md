# Approach

**Tags:** `Array`, `Prefix Sum`, `Prefix Maximum`, `Suffix Minimum`

## Intuition

The score at index `i` needs two aggregates that both extend over ranges, but each is monotone as `i` moves:

- `max(nums[0..i])` only ever grows as `i` increases — a running prefix maximum.
- `min(nums[i..n-1])` only ever grows as `i` increases too — a suffix minimum, computed right to left.

Neither needs to be recomputed per index. Two linear passes give every score in O(1), so the whole thing is a single sweep afterwards.

## Approach

1. Build `prefMax[i] = max(nums[0..i])` in a left-to-right pass.
2. Build `sufMin[i] = min(nums[i..n-1])` in a right-to-left pass.
3. Scan `i` from `0` upward and return the first index where `prefMax[i] - sufMin[i] <= k`.
4. If no index qualifies, return `-1`.

Scanning left to right returns the smallest qualifying index automatically.

## Complexity

- **Time:** O(n) — two aggregate passes plus one scan
- **Space:** O(n) — the two arrays (reducible to O(n) for just the suffix array, with the prefix max kept as a running scalar)

## Edge Cases

- Single element → `prefMax == sufMin == nums[0]`, score `0`, so index `0` is stable whenever `k >= 0` (Example 3)
- No stable index → `-1` (Example 2)
- Both ranges are inclusive of `i` and overlap at that element, so the score is never negative
- Values up to `10^9` and `k` up to `10^9`; the difference fits in a signed 32-bit int
- The score is not monotone in `i`, so the first qualifying index must be found by scanning — not by binary search
