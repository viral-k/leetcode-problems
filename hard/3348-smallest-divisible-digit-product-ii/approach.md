# Approach

**Tags:** `String`, `Greedy`, `Math`, `Number Theory`, `Enumeration`

## Intuition

Digits `1..9` only carry the prime factors `2, 3, 5, 7`. So first strip those primes out of `t`; if anything remains, no digit product can ever be divisible by `t` → `"-1"`. What's left is a required exponent tuple `(a2, a3, a5, a7)` that the answer's digits must jointly supply.

Two building blocks:

1. **Minimal covering multiset.** Cover the required exponents with the fewest, largest digits — `9 = 3^2`, `8 = 2^3`, `6 = 2*3`, and forced `5`s / `7`s (only digit `5` gives a factor 5, only `7` gives a factor 7). Sorting the multiset ascending gives the lexicographically smallest arrangement, and its size is the minimum number of "significant" digits needed.
2. **Smallest number of a given length that covers.** Pad the front with `1`s (they contribute nothing) and place the covering multiset at the end.

## Approach

1. **Reduce `t`** by dividing out 2, 3, 5, 7 → exponents `(a2,a3,a5,a7)`; leftover `> 1` → `"-1"`.
2. **Same length as `num`:**
   - If `num` is zero-free and its digit product already covers the exponents → return `num`.
   - Otherwise find the **largest position `i`** to bump: keep the (zero-free) prefix `num[0..i-1]`, set digit `i` to the smallest value `> num[i]` such that the remaining exponents can still be covered by the suffix positions, then fill the suffix with `1`s + minimal covering digits. A larger branch position always yields a smaller result, so the first feasible one (scanning right to left) wins. The valid branch range is capped at the first `0` in `num` (a kept prefix must stay zero-free; the `0` itself can be bumped).
3. **Fallback to a longer number:** if no same-length answer exists, the answer has length `L = max(n+1, mincount)` and is `"1" * (L - mincount) + minimalDigits` — the smallest zero-free covering number of that length.

## Complexity

- **Time:** O(n) — cumulative prefix exponents, one right-to-left scan with O(1) work per position (8 candidate digits), suffix built once
- **Space:** O(n) — prefix arrays and the output

## Edge Cases

- `t` has a prime factor other than 2/3/5/7 → `"-1"` (Example 3)
- `num` already valid → return it (Example 2)
- `num` contains `0`s → branch position is capped at the first `0`
- `t = 1` → any zero-free number works → smallest zero-free `>= num`
- Required `5`s / `7`s force `5` / `7` digits (e.g. `7^3` → `"777"`)
- Use 64-bit for `t` (up to `10^14`); digit exponents are small ints
