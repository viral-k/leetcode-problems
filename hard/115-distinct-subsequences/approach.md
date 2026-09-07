# Approach

**Tags:** `String`, `Dynamic Programming`

## Intuition

Walk both strings from the left and ask, at each position, "how many ways can the first `j` characters of `t` be formed from the first `i` characters of `s`?" Every occurrence of `t` inside `s` is picked out by choosing, for each character of `t`, which position in `s` supplies it — so the count naturally decomposes into per-character decisions.

At `s[i-1]` there are only two things that can happen:

- **Skip it.** The count is whatever was achievable without this character: `dp[i-1][j]`.
- **Use it**, available only when `s[i-1] == t[j-1]`. Then it supplies `t[j-1]`, and the remaining `t[:j-1]` must come from `s[:i-1]`: `dp[i-1][j-1]`.

These two cases are disjoint (the character is either used or not), so they add. Repeated characters in `s` — the three `b`s in `"rabbbit"` — each contribute their own branch, which is exactly why the answer is 3 rather than 1.

## Approach

Let `dp[i][j]` = the number of distinct subsequences of `s[:i]` equal to `t[:j]`.

- **Base:** `dp[i][0] = 1` for all `i` — the empty target is matched exactly one way (delete everything). `dp[0][j] = 0` for `j > 0` — a non-empty target cannot come from an empty source.
- **Transition:**
  ```
  dp[i][j] = dp[i-1][j] + (s[i-1] == t[j-1] ? dp[i-1][j-1] : 0)
  ```
- **Answer:** `dp[m][n]`.

Each row depends only on the row above, so a single 1D array suffices — but the inner loop must run **`j` descending**, so that `dp[j-1]` still holds the previous row's value when it's read. Ascending order would clobber it.

## Complexity

- **Time:** O(m * n) — up to 10^6 cells here
- **Space:** O(n) — one rolling row instead of the full table

## Edge Cases

- `t` longer than `s` → 0
- `t` equal to `s` → 1
- Characters of `t` absent from `s` → 0
- Repeated characters create multiple branches (Examples 1 and 2)
- The problem guarantees the answer fits in a signed 32-bit int, so no modulus is needed — but `long` accumulation in Java is harmless insurance
