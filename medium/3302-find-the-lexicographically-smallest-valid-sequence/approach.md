# Approach

**Tags:** `String`, `Greedy`, `Two Pointers`, `Suffix`

## Intuition

We match `word2` against a subsequence of `word1`, allowing **at most one mismatch** (the single change), and want the lexicographically smallest index array. Two facts drive the greedy:

- **Exact matches are free** — they never consume the change, so grabbing the smallest available exact-match index for each `word2[j]` is always safe.
- **Spend the change as early as it stays feasible.** At the current output position `j`, using the change on a mismatch gives that position a *smaller* index than waiting for a later exact match. A smaller value at the current output position dominates lexicographically, no matter what happens afterward — as long as the remainder can still be completed.

Feasibility of "the rest matches exactly" is answered by a suffix precomputation.

## Approach

1. **Suffix array `f`:** `f[i]` = the number of trailing characters of `word2` that can be matched exactly as a subsequence of `word1[i:]`. Compute right to left: walking `i` from `n-1` down, advance a counter `k` whenever `word1[i] == word2[m-1-k]`; set `f[i] = k`.
2. **Greedy sweep** with pointers `i` (word1), `j` (word2), and a `changed` flag:
   - If `word1[i] == word2[j]`: take it (exact) → append `i`, advance both.
   - Else if the change is unused **and** `f[i+1] >= m-j-1` (the remaining `word2[j+1:]` still fits exactly in `word1[i+1:]`): spend the change here → append `i`, advance both, set `changed`.
   - Else: skip `i`.
3. If `j` reached `m`, return the collected indices; otherwise return `[]`.

## Complexity

- **Time:** O(n) — one suffix pass and one forward sweep
- **Space:** O(n) — the `f` array (plus the output)

## Edge Cases

- No valid sequence (needed character never appears, even with one change) → `[]` (Example 3)
- Change used to shrink the first index (Example 1) → spend at position 0
- `word2` matches exactly with no change needed → still smallest greedy indices
- `word2` shorter than `word1` by more than the used indices → extra `word1` chars ignored
- The change may be spent anywhere; the greedy places it at the earliest feasible mismatch
