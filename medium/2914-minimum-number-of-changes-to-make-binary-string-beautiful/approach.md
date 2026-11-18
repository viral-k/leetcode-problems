# Approach

**Tags:** `String`

## Intuition

The partition rule looks like it needs a DP over block boundaries, but it collapses to something local. Cut the string into aligned pairs `(s[0], s[1]), (s[2], s[3]), ...`.

- If the string is beautiful, every block starts at an even index (all earlier blocks have even length) and has even length. So no aligned pair crosses a block boundary, and both characters of each pair sit in the same single-character block. Every pair is equal.
- If every pair is equal, make each pair its own block of length 2. That is a valid partition.

So "beautiful" means exactly "every aligned pair is `00` or `11`". The pairs don't interact, and a mismatched pair (`01` or `10`) needs exactly one change, since changing either character fixes it.

## Approach

1. Walk `i = 0, 2, 4, ...`.
2. Count the pairs with `s[i] != s[i + 1]`.
3. Return the count.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Already beautiful (example 3): every pair matches, answer 0
- Length 2: the answer is 0 or 1
- Unaligned runs like `"0110"`: the pairs are `01` and `10`, so the answer is 2. Looking at runs instead of aligned pairs would suggest the middle `11` already fits and get this wrong
- Alternating `"0101..."`: every pair mismatches, so the answer is `n / 2`
