# Approach

**Tags:** `Array`, `Prefix Sum`, `Prefix Maximum`, `Suffix Minimum`

## Intuition

Identical to part I; only the input size grows (`n` from 100 to 10^5), which rules out recomputing `max` and `min` per index — that would be O(n^2) and roughly 10^10 operations. The linear formulation already handles it.

Both aggregates are monotone as `i` advances:

- `max(nums[0..i])` only grows — a running prefix maximum, maintained in O(1) per step.
- `min(nums[i..n-1])` only grows too, but is computed from the right — a suffix minimum array.

So one backward pass and one forward pass give every score in O(1) each.

## Approach

1. Build `sufMin[i] = min(nums[i..n-1])` in a right-to-left pass.
2. Sweep `i` left to right, maintaining `prefMax` as a running scalar.
3. Return the first `i` where `prefMax - sufMin[i] <= k`.
4. If none qualifies, return `-1`.

Sweeping left to right returns the smallest qualifying index automatically, so no extra comparison is needed.

## Complexity

- **Time:** O(n) — one suffix pass plus one scan
- **Space:** O(n) — the suffix array (the prefix max needs only a scalar)

## Edge Cases

- Single element → `prefMax == sufMin == nums[0]`, score `0`, stable whenever `k >= 0` (Example 3)
- No stable index → `-1` (Example 2)
- Both ranges include index `i`, so they overlap there and the score is never negative
- Values and `k` up to `10^9`; the difference stays within signed 32-bit range
- The score is **not** monotone in `i`, so the first qualifying index must be found by scanning rather than binary search
