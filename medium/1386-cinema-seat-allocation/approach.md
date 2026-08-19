# Approach

**Tags:** `Array`, `Hash Table`, `Greedy`, `Bit Manipulation`, `Counting`

## Intuition

`n` reaches 10^9, but there are at most 10^4 reservations — so the overwhelming majority of rows are completely empty. An empty row always seats exactly **2** groups: blocks `2-5` and `6-9` are disjoint, and no third group can fit alongside them. That gives a baseline of `2 * n`, and only the handful of rows containing a reservation need individual attention.

Seats 1 and 10 belong to no block, so a row whose only reservations are seats 1 and/or 10 still behaves like an empty row.

Within a row, the three candidate blocks overlap in a specific way: left (`2-5`) and right (`6-9`) are disjoint, while middle (`4-7`) conflicts with both. So a row seats 2 groups only via left + right; otherwise at most 1.

## Approach

1. Group the reservations by row (a hash map from row to a 10-bit mask of taken seats).
2. Start with `total = 2 * n`.
3. For each row that has reservations, compute how many groups it actually supports:
   - `left`  = seats 2,3,4,5 all free
   - `mid`   = seats 4,5,6,7 all free
   - `right` = seats 6,7,8,9 all free
   - value = `2` if `left && right`, else `1` if any of the three is free, else `0`
4. Adjust the baseline: `total += value - 2` for each such row (rows evaluating to 2 contribute nothing, matching the empty-row assumption).
5. Return `total`.

## Complexity

- **Time:** O(m) where m = number of reservations — independent of `n`
- **Space:** O(m) — the per-row masks

## Edge Cases

- Rows with only seat 1 and/or 10 reserved → still 2 groups (those seats are in no block)
- A single reservation at seat 4, 5, 6, or 7 kills the middle block and one side → 1 group
- Rows with no reservations are never enumerated, which is what keeps this O(m) rather than O(n)
- Max answer is `2 * 10^9 < 2^31 - 1`, so it fits in `int`, but use `long` intermediates in Java to be safe
