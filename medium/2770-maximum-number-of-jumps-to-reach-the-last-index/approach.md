# Approach

**Tags:** `Array`, `Dynamic Programming`

## Intuition

Jumps only go from a smaller index to a larger index, so the graph is acyclic. That makes dynamic programming natural.

Let `dp[i]` be the maximum number of jumps needed to reach index `i` from index `0`. If index `i` is unreachable, keep `dp[i] = -1`.

For every reachable index `i`, try jumping to every later index `j`. If the value difference is within `target`, update `dp[j]`.

## Approach

1. Initialize `dp[0] = 0`.
2. Set every other `dp[i]` to `-1`.
3. For each index `i`:
   - skip it if `dp[i] == -1`
   - check every `j > i`
   - if `abs(nums[j] - nums[i]) <= target`, update `dp[j] = max(dp[j], dp[i] + 1)`
4. Return `dp[n - 1]`.

## Complexity

- **Time:** O(n²) — every pair `(i, j)` with `i < j` may be checked
- **Space:** O(n) — for the DP array

## Edge Cases

- `target = 0` -> only equal-valued jumps are valid
- Last index unreachable -> return `-1`
- Negative values -> absolute difference comparison still applies
- Direct jump from `0` to `n - 1` -> valid but may not be maximum
