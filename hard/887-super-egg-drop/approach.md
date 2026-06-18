# Approach

**Tags:** `Math`, `Dynamic Programming`, `Binary Search`

## Intuition

The naive DP "minimum moves for (eggs, floors)" is O(k * n^2) and is too slow for `n = 10^4`. The key is to **invert the question**: instead of asking how many moves a given number of floors needs, ask how many floors a given number of moves can cover.

Let `f(m, k)` be the maximum number of floors we can fully resolve using at most `m` moves and `k` eggs. The answer is the smallest `m` with `f(m, k) >= n`.

## Approach

Consider one drop when we have `m` moves and `k` eggs:

- If the egg **breaks**, we are left with `m - 1` moves and `k - 1` eggs to resolve the floors below — that covers `f(m-1, k-1)` floors.
- If the egg **survives**, we have `m - 1` moves and `k` eggs to resolve the floors above — `f(m-1, k)` floors.
- Plus the floor we just dropped from.

This gives the recurrence:

```
f(m, k) = f(m-1, k-1) + f(m-1, k) + 1
```

Because the number of moves grows only logarithmically (with plenty of eggs it is essentially binary search, ~log2(n)), we iterate `m = 1, 2, 3, ...`, maintaining a 1-D array `dp[j]` = floors reachable with `j` eggs at the current move count:

1. Start with `dp[j] = 0` for all `j` and `moves = 0`.
2. While `dp[k] < n`: increment `moves`, and for `j` from `k` down to `1` set `dp[j] = dp[j] + dp[j-1] + 1`.
   - Updating high to low keeps `dp[j-1]` at its previous-move value, exactly what the recurrence needs.
3. Return `moves` once `dp[k] >= n`.

## Complexity

- **Time:** O(k * m) where `m` is the answer (~O(k log n))
- **Space:** O(k) — the 1-D dp array

## Edge Cases

- `k = 1` -> must scan floors one by one, answer is `n`
- `n = 1` -> a single move suffices, answer is `1`
- Many eggs (`k >= log2(n)`) -> answer is the binary-search bound `ceil(log2(n+1))`
- Large `n` with few eggs -> the `m` loop still terminates quickly because floors grow fast
