# Approach

**Tags:** `Array`, `Math`, `Dynamic Programming`, `Game Theory`

## Intuition

This is the same take-from-either-end game as "Predict the Winner", but the constraints force a constant answer: with an **even** number of piles and an **odd** total (no ties), the first player always wins.

**Proof by parity strategy.** Label piles by their original index parity: evens `{0, 2, 4, ...}` and odds `{1, 3, 5, ...}`. Initially the two exposed ends have *different* parities (index `0` and index `n-1`, and `n-1` is odd since `n` is even). Whatever pile Bob later takes, he flips the parity of one exposed end, so Alice can always respond by taking a pile of her chosen parity. Thus Alice can guarantee collecting *every* even-indexed pile, or *every* odd-indexed pile — her choice.

Since the total is odd, `sum(evens) != sum(odds)`, so one group is strictly larger. Alice commits to the larger group and wins. Hence the answer is always `true`.

## Approach

Return `true`.

(A full O(n²) interval DP — `dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])`, answer `dp[0][n-1] > 0` — also works and is what generalizes when the constraints are relaxed; here it always yields `true`.)

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Edge Cases

- Any valid input (even count, odd sum) → `true`
- The parity argument needs `n` even, which the constraints guarantee
- Odd total guarantees a strict winner (no tie to break)
