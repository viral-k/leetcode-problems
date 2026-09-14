# Approach

**Tags:** `String`, `Dynamic Programming`, `Recursion`, `Memoization`

## Intuition

The scrambling process is recursive by definition, so the natural question to ask is also recursive: given a substring of `s1` and a substring of `s2` of the same length, can the first scramble into the second?

At the top level the algorithm split `s1` somewhere and then either kept the halves in place or swapped them. That gives exactly two shapes to check for each split point `k`:

- **No swap:** the first `k` characters of `s1`'s piece scramble into the first `k` of `s2`'s piece, and the rest scramble into the rest.
- **Swap:** the first `k` of `s1`'s piece scramble into the **last** `k` of `s2`'s piece, and the remaining `len - k` of `s1` scramble into the **first** `len - k` of `s2`.

Either shape succeeding for any `k` means the answer is yes.

Two things make this tractable. The state `(i, j, len)` has only O(n^3) distinct values, so memoization caps the work. And a scramble is a permutation of characters, so if two pieces don't have the same letter multiset, no split can possibly work — checking that first prunes the overwhelming majority of branches before any recursion happens.

## Approach

Define `solve(i, j, len)` = whether `s1[i : i+len]` scrambles into `s2[j : j+len]`.

1. If the two substrings are identical, return `true`.
2. If their character counts differ, return `false` (fast rejection).
3. For each split `k` from `1` to `len - 1`:
   - no swap: `solve(i, j, k) and solve(i+k, j+k, len-k)`
   - swap: `solve(i, j+len-k, k) and solve(i+k, j, len-k)`
   - return `true` if either holds.
4. Return `false`; memoize every `(i, j, len)` result.

The answer is `solve(0, 0, n)`.

## Complexity

- **Time:** O(n^4) — O(n^3) states, each trying O(n) splits; the count-mismatch pruning makes the real cost far lower
- **Space:** O(n^3) — the memo table, plus O(n) recursion depth

## Edge Cases

- Length 1 → strings must be equal (Example 3)
- Equal strings at any level short-circuit to `true` without splitting
- Anagrams are necessary but not sufficient (Example 2 is an anagram that still fails)
- Different multisets fail instantly via the count check, never touching the recursion
- The swap branch maps `s1`'s prefix to `s2`'s **suffix**; getting that offset wrong is the classic bug here
