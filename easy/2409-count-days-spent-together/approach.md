# Approach

**Tags:** `Math`, `String`

## Intuition

Dates in a fixed, known year are just numbers. Map each `"MM-DD"` to its
day-of-year ordinal and the problem collapses to intersecting two closed
intervals of integers, with no calendar arithmetic left to get wrong.

Two closed intervals `[a1, a2]` and `[b1, b2]` overlap on
`[max(a1, b1), min(a2, b2)]`, which has `min(a2, b2) - max(a1, b1) + 1` days
when that is positive and none otherwise. The clamp at zero is the whole of
the "no overlap" case, including intervals that merely touch end to end without
sharing a day.

## Approach

1. Precompute cumulative month offsets, so `prefix[i]` is the number of days in
   the first `i` months of a non-leap year: `[0, 31, 59, 90, ...]`.
2. Parse a date with fixed-width slicing — month is characters 0 and 1, day is
   characters 3 and 4 — and return `prefix[month - 1] + day`.
3. Convert all four dates, take `lo = max(arriveAlice, arriveBob)` and
   `hi = min(leaveAlice, leaveBob)` as ordinals.
4. Return `max(0, hi - lo + 1)`.

The year is stated to be non-leap, so February is always 28 days and no leap
rule is needed.

## Complexity

- **Time:** O(1) — four parses and a constant amount of arithmetic
- **Space:** O(1)

## Edge Cases

- Disjoint ranges, as in example 2 → `hi - lo + 1` is negative or zero and the
  clamp returns 0
- Ranges that touch but do not overlap, e.g. Alice leaving `03-10` and Bob
  arriving `03-11` → `hi - lo + 1 == 0`, so 0
- Exactly one shared day → `hi == lo`, giving 1, which is why the clamp has to
  be at 0 rather than at 1
- One range fully inside the other → the answer is the length of the inner range
- Identical ranges → the full length
- `01-01` and `12-31` → ordinals 1 and 365, so a full-year range gives 365
- Single-day ranges for both people on the same date → 1
- The statement guarantees arrival is on or before departure, so neither input
  interval is itself empty and no normalisation is needed
