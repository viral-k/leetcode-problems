# Approach

**Tags:** `Array`, `Two Pointers`

## Intuition

The result is just three groups concatenated in order: everything `< pivot` (original order), then all the copies of `pivot`, then everything `> pivot` (original order). A stable single pass that buckets each value preserves the required relative order automatically.

## Approach

1. Scan `nums` once, splitting into two lists while counting the pivot:
   - `less` — values strictly less than `pivot`, appended in order
   - `greater` — values strictly greater than `pivot`, appended in order
   - `equal_count` — how many values equal `pivot`
2. Build the answer as `less + [pivot] * equal_count + greater`.

Because we append in scan order, the relative order within `less` and within `greater` is preserved.

## Complexity

- **Time:** O(n) — one pass to bucket, one pass to assemble
- **Space:** O(n) — the output array (and the temporary buckets)

## Edge Cases

- All elements equal the pivot -> result is unchanged
- No elements less than (or greater than) the pivot -> that section is empty
- Single element (must equal the pivot per constraints) -> returned as-is
- Negative values -> handled the same as any other value
