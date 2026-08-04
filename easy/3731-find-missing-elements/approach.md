# Approach

**Tags:** `Array`, `Hash Table`, `Sorting`

## Intuition

The original range is exactly `[min(nums), max(nums)]` (endpoints are guaranteed present). Any value in that range not found in `nums` is missing.

## Approach

1. Put `nums` into a set for O(1) membership checks; find `lo = min` and `hi = max`.
2. For every value `v` in `[lo, hi]`, add it to the answer if it's not in the set.
3. Iterating in increasing order yields the sorted result directly.

## Complexity

- **Time:** O(n + R) where R = `max - min`
- **Space:** O(n) — the membership set

## Edge Cases

- No missing values (Example 2) → empty list
- Only two elements far apart (Example 3) → the whole interior is missing
- Consecutive min/max with nothing between → empty list
- Values are unique per constraints, so no duplicate handling needed
