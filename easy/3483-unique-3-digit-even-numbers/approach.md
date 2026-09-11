# Approach

**Tags:** `Array`, `Hash Table`, `Enumeration`, `Counting`

## Intuition

The obvious route is to permute the array and collect results in a set to drop duplicates. That works, but it does the deduplication after the fact and wastes effort whenever the input repeats a digit.

Turn it around: enumerate the **candidate numbers** instead of the permutations. There are only 900 three-digit numbers, and of those only the even ones matter, so the search space is tiny and fixed regardless of the input. For each candidate, the only question is whether the input holds enough copies of each digit it needs.

Because every candidate is generated exactly once, distinctness comes for free and no set is required.

## Approach

1. Tally how many times each digit `0-9` appears in `digits`.
2. For every `h` in `1..9` (no leading zero), `t` in `0..9`, and `u` in `{0, 2, 4, 6, 8}`:
   - Take a working copy of the tally and try to consume `h`, then `t`, then `u`.
   - If any of the three is unavailable at the moment it is needed, the number cannot be formed.
   - Otherwise count it.
3. Return the count.

Consuming the digits one at a time is what enforces the "each copy used once" rule: a number like 222 needs three separate copies, and the third consumption fails when only one exists.

## Complexity

- **Time:** O(1) — at most 10 * 10 * 5 = 500 candidate checks, independent of input size
- **Space:** O(1) — a 10-slot tally

## Edge Cases

- No even digit in the input → 0 (Example 4)
- Repeated digits allow reuse only up to their multiplicity (Example 2 forms 202 but the input must hold two 2s)
- All three digits identical (Example 3) requires three copies
- A `0` may appear in the tens or units place but never the hundreds
- Maximum answer is bounded by the 450 even three-digit numbers, so no overflow concern
