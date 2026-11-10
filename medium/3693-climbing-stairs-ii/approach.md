# Approach

**Tags:** `Array`, `Dynamic Programming`

## Intuition

The cost of landing on step `j` depends only on where the jump started, and that can only be `j - 1`, `j - 2` or `j - 3`. So the cheapest way to reach `j` is the cheapest way to reach one of those three steps, plus the jump. The jump costs `costs[j]` plus a penalty of 1, 4 or 9 for a jump of length 1, 2 or 3.

## Approach

1. `dp[0] = 0`. Steps below 0 don't exist, so treat them as unreachable (infinite).
2. For `j = 1..n`: `dp[j] = costs[j] + min(dp[j-1] + 1, dp[j-2] + 4, dp[j-3] + 9)`, where `costs` is 1-indexed as in the statement.
3. Only the last three values are ever read, so keep three variables and shift them along.
4. Return `dp[n]`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- `n = 1`: the only move is `0 → 1`, costing `costs[1] + 1`
- `n = 2` or `n = 3`: a single long jump from step 0 can win (example 3), so steps below 0 must be unreachable rather than cost 0
- A big jump penalty versus an expensive middle step: `+9` for skipping two steps is often still cheaper (example 2 skips step 1 and step 3)
- The array is 1-indexed in the statement but 0-indexed in code, so step `j` uses `costs[j - 1]`
- The total is at most about `10^5 * (10^4 + 1) ≈ 1.0 * 10^9`, which fits in an `int`
