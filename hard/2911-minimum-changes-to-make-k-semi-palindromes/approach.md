# Approach

**Tags:** `Two Pointers`, `String`, `Dynamic Programming`

## Intuition

Two independent questions:

1. **What does one piece cost?** For a substring of length `L` and a proper divisor `d` of `L`, the characters split into `d` sequences with step `d`. Making a sequence a palindrome costs one change per mismatched mirror pair. The piece's cost is the minimum over its divisors.
2. **How to split?** Once every substring has a cost, choosing `k` pieces is a standard partition DP.

Computing piece costs directly is O(n^3 * divisors). That's too slow in Python at `n = 200`, and it repeats work: for a fixed step `d`, the sequence `a, a+d, ..., b` is a palindrome problem whose inner part is `a+d, ..., b-d`. That is the same recurrence as palindrome DP, just with stride `d`.

## Approach

1. For each `d` from 1 to `n / 2`:
   - Fill `g[a][b]` (for `b - a` a multiple of `d`) in order of increasing `b - a`: `g[a][b] = g[a+d][b-d] + (s[a] != s[b])`, with the inner term 0 when the sequence has 1 or 2 elements.
   - For every substring `s[i..j]` whose length is a multiple of `d` and at least `2d`, so that `d` is a proper divisor: its cost with this `d` is `Σ g[i+r][j-d+1+r]` for `r` in `0..d-1`. Keep the minimum in `cost[i][j]`.
2. Length-1 substrings keep cost infinity, since 1 has no proper divisor.
3. Partition DP: `dp[j]` is the best split of `s[:j]` into `p` pieces. Start with `p = 1`, `dp[j] = cost[0][j-1]`. Then `dp'[j] = min over i of dp[i] + cost[i][j-1]`, with `2(p-1) <= i <= j-2`, so every piece has length at least 2.
4. Return `dp[n]` after `k` pieces.

## Complexity

- **Time:** O(n^2 log n + k * n^2). The `g` tables total `Σ n^2 / (2d) = O(n^2 log n)`. Filling `cost` takes `Σ_L (n - L) * σ(L)`, around 10^6 at `n = 200`. The partition DP is O(k * n^2).
- **Space:** O(n^2) for `cost` and one `g` table reused across `d`

## Edge Cases

- Single-character pieces are never semi-palindromes (the only divisor of 1 is 1 itself), so every piece needs length at least 2. `k <= n / 2` keeps the problem feasible.
- `d = 1` is the plain palindrome check, and it applies to every length `>= 2`
- A string can be a semi-palindrome with zero changes even though it isn't a palindrome (`"abcabc"` with `d = 3`, `"abab"` with `d = 2`)
- Prime lengths only have `d = 1`, so such a piece must become an actual palindrome
- In Java, the `g` table is shared across all `d` without clearing. Every read for a given `d` is either an entry already written for that `d` or a diagonal `g[x][x]`, which is never written and stays 0.
