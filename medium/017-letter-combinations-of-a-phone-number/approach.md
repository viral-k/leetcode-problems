# Approach

**Tags:** `Hash Table`, `String`, `Backtracking`, `Recursion`

## Intuition

Every digit independently contributes one of its letters, so the full set of combinations is the Cartesian product of the per-digit letter groups. Backtracking builds each combination one digit at a time, branching over that digit's letters.

## Approach

1. Map each digit `2..9` to its letter group.
2. Recurse over digit positions, carrying a partial string:
   - At the end (all digits consumed), record the partial string.
   - Otherwise, for each letter of the current digit, append it and recurse.
3. Return all collected strings. (An empty `digits` yields an empty list.)

## Complexity

- **Time:** O(4^n · n) — up to `4^n` combinations (digits 7 and 9 have 4 letters), each of length `n` to build
- **Space:** O(n) recursion depth, plus the output

## Edge Cases

- Empty input → `[]` (not `[""]`)
- Single digit → that digit's letters (Example 2)
- Digits `7` and `9` map to 4 letters, others to 3
- Constraints cap length at 4, so at most `4^4 = 256` combinations
