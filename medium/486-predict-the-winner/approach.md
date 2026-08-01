# Approach

**Tags:** `Array`, `Dynamic Programming`, `Recursion`, `Game Theory`, `Interval DP`

## Intuition

Instead of tracking two separate scores, track the **difference** between the current player's score and the opponent's on each subarray. Whatever the current player takes, the roles then flip, so the opponent's optimal difference on the remaining subarray is *subtracted* from the taken value. Maximizing this difference on the full array tells us whether player 1 comes out non-negative (a win or tie).

## Approach

Let `dp[i][j]` = the maximum achievable (current player − opponent) score difference playing optimally on `nums[i..j]`.

- Base: `dp[i][i] = nums[i]` (take the only element).
- Transition: `dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])`.

Player 1 wins iff `dp[0][n-1] >= 0`.

Since `dp[i][j]` depends only on `dp[i+1][j]` and `dp[i][j-1]`, sweep `i` from high to low with a **1D array** indexed by `j`, updating in place.

## Complexity

- **Time:** O(n²)
- **Space:** O(n) — the rolling 1D DP array

## Edge Cases

- Single element → player 1 takes it → always wins (`dp >= 0`)
- Ties count as a win for player 1 (hence `>= 0`, not `> 0`)
- Two elements → player 1 takes the larger → wins
- All equal values → even length ties, odd length player 1 wins — both non-negative
