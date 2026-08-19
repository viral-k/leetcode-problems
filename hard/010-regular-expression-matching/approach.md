# Approach

**Tags:** `String`, `Dynamic Programming`, `Recursion`, `Memoization`

## Intuition

Match the two strings from the left, one decision at a time. The only real complication is `*`, because `x*` may consume any number of characters — including none — so at each `*` the pattern branches:

- **Skip it entirely** (zero repetitions): jump the pattern forward by 2, leaving `s` where it is.
- **Use one repetition**: if the current character matches `x`, consume one character of `s` and keep the pattern at the same `*` group (so it can be used again).

Everything else is a plain character-by-character step. Since both branches only ever move forward, the state `(i, j)` — "does `s[i:]` match `p[j:]`?" — is enough, and the overlapping subproblems make it a clean DP.

The `*` must be read together with the character *before* it, which is why the pattern is examined two positions at a time (`p[j]` and `p[j+1]`), never one.

## Approach

Let `dp[i][j]` = does `s[i:]` match `p[j:]`.

- **Base:** `dp[m][n] = true` (both exhausted). `dp[m][j]` may still be true if the rest of the pattern is all `x*` pairs — the recurrence handles this via the skip branch.
- **First-character test:** `first = i < m and (p[j] == s[i] or p[j] == '.')`.
- **Transition:**
  - If `j + 1 < n and p[j+1] == '*'`:
    `dp[i][j] = dp[i][j+2] or (first and dp[i+1][j])`
  - Else:
    `dp[i][j] = first and dp[i+1][j+1]`

Fill `i` from `m` down to `0` and `j` from `n-1` down to `0`, then return `dp[0][0]`.

## Complexity

- **Time:** O(m * n) — each state computed once with O(1) work
- **Space:** O(m * n) — the DP table (reducible to O(n) with a rolling row)

## Edge Cases

- `p = ".*"` matches any string, including one longer than the pattern
- Patterns that are entirely `x*` groups (e.g. `"a*b*c*"`) must match the empty string
- `s` exhausted but pattern remaining → only true if the remainder is all `x*` pairs
- `*` always has a valid preceding character (guaranteed), so `p[0] == '*'` never occurs
- Matching must cover the **entire** string, not a prefix (Example 1)
