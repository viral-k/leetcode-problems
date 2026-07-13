# Approach

**Tags:** `Enumeration`, `String`, `Math`

## Intuition

Every number with sequential digits is a contiguous run from the string `"123456789"` — e.g. `2345` is the substring `"2345"`. Digits never wrap past 9, so there are very few such numbers (36 in total across lengths 2–9). Just generate them all and filter.

## Approach

1. For each window length `L` from 2 to 9:
   - For each start index `i` with `i + L <= 9`, take `"123456789"[i : i+L]` and convert to an integer.
   - Keep it if it lies in `[low, high]`.
2. Collect and sort the results (generating by increasing length then left-to-right already yields ascending order, but sorting is safe and trivial).

## Complexity

- **Time:** O(1) — a fixed 36 candidates, independent of the range size
- **Space:** O(1) — bounded output

## Edge Cases

- No sequential-digit number in range → empty list
- `low == high` and it's itself sequential → single element
- Digits stop at 9 (no `"...910"`), which the substring approach enforces automatically
- Results are naturally ascending by (length, start), matching the required sorted order
