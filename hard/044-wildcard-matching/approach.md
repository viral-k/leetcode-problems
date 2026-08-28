# Approach

**Tags:** `String`, `Dynamic Programming`, `Greedy`, `Recursion`

## Intuition

Match prefixes against prefixes. The state "does `s[:i]` match `p[:j]`" is enough, because every pattern character either consumes exactly one character of `s` (a letter or `?`) or, in the case of `*`, may consume any number.

The `*` case is what makes it a DP rather than a scan. When the pattern's current character is `*`, there are two ways to succeed:

- **Let `*` swallow one more character** of `s` — the pattern position stays put, `s` advances (`dp[i-1][j]`).
- **Close `*` off as empty** — `s` stays put, the pattern advances past the star (`dp[i][j-1]`).

Either one succeeding is enough, which is why the star's transition is an `or` of the cell above and the cell to the left.

Unlike regex-style `*` (problem 10), this `*` is standalone — it doesn't bind to a preceding character — so the pattern is always read one position at a time.

## Approach

Let `dp[i][j]` = does `s[:i]` match `p[:j]`.

- **Base:** `dp[0][0] = true`. For `i = 0`, `dp[0][j] = dp[0][j-1] and p[j-1] == '*'` — only a leading run of stars can match the empty string.
- **Transition:**
  - `p[j-1] == '*'` → `dp[i][j] = dp[i-1][j] or dp[i][j-1]`
  - otherwise → `dp[i][j] = dp[i-1][j-1] and (p[j-1] == '?' or p[j-1] == s[i-1])`
- **Answer:** `dp[m][n]`.

Each row depends only on the row above and the cell to its left, so a single 1D array rolled forward replaces the full table.

## Complexity

- **Time:** O(m * n) — one pass per (string, pattern) position pair, up to 4 * 10^6 here
- **Space:** O(n) — one rolling row instead of the full `m x n` table

## Edge Cases

- Empty `s` → true only when `p` is entirely `*`s (or also empty)
- Empty `p` → true only when `s` is empty
- Pattern of only `*` matches anything (Example 2)
- Consecutive stars (`"**"`) behave like a single star; the recurrence handles this with no special-casing
- Matching must cover the entire string, not a prefix (Example 1)
