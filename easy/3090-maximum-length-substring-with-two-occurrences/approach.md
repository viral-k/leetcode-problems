# Approach

**Tags:** `Hash Table`, `String`, `Sliding Window`

## Intuition

"At most two occurrences of each character" is preserved when a window shrinks, so a two-pointer sliding window applies: extend the right edge greedily, and whenever the constraint breaks, pull the left edge in until it holds again.

Only the character just added can push a count above 2, so the shrink loop only needs to watch that one.

## Approach

1. Keep a count array of size 26 and a `left` pointer.
2. For each right index `r`:
   - Increment the count of `s[r]`.
   - While that count exceeds 2, decrement the count of `s[left]` and advance `left`.
   - Update the answer with `r - left + 1`.
3. Return the largest window seen.

## Complexity

- **Time:** O(n) — `left` only moves forward, so the work is amortized linear
- **Space:** O(26) = O(1)

## Edge Cases

- All identical characters (Example 2) → answer is exactly 2
- All distinct characters → the whole string qualifies → answer `n`
- Length is at least 2 per constraints, so the answer is at least 2
- This is the `k = 2` case of the general "at most k frequency" window (see problem 2958)
