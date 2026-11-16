# Approach

**Tags:** `String`, `Simulation`

## Intuition

The statement spells out the procedure, so simulate it. The only real question is whether it finishes quickly. It does:

- For `k >= 3`, a full group of `k` digits sums to at most `9k`, which has fewer than `k` digits (27 has 2, 900 has 3). Every round shrinks the string by a constant factor.
- For `k = 2`, a pair sums to at most 18, so a round can keep the length unchanged, but only if every pair sums to 10 or more. Then the new string is made of blocks `"1d"` with `d <= 8`, the next round's pairs line up with those blocks, and each sums to `1 + d <= 9`, a single digit. So the length at least halves every two rounds.

Either way the lengths form a geometric series, and the total work is O(n).

## Approach

1. While `len(s) > k`:
   - Walk `s` in steps of `k`, sum the digits of each chunk (the last chunk may be shorter).
   - Append each sum as a decimal string and replace `s` with the result.
2. Return `s`.

## Complexity

- **Time:** O(n). Round lengths shrink geometrically, so their total is O(n). Measured worst at `n = 100`: 398 characters processed across 12 rounds, with `k = 2`.
- **Space:** O(n) for the next round's string

## Edge Cases

- `len(s) <= k` from the start: no rounds, return `s` unchanged
- Zeros (example 2): a group of zeros becomes `"0"`, not an empty string, so the length still counts it
- The last group can be shorter than `k`, even a single digit
- `k = 2` with large digits (`"999"`): the first round gives `"189"`, the same length, then `"99"`
- A group sum can have up to 3 digits (`k = 100`, all nines: 900), so append the sum as a string, not a single character
