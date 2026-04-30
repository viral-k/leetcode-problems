# Approach

**Tags:** `Array`, `Matrix`, `Dynamic Programming`

## Intuition

Grid DP with one extra dimension for the cost budget. A 2D `dp[i][j]` is insufficient: the budget couples decisions across the path, so we must track how much cost has been spent so far. Per cell, cost is binary (`0` if value `0`, else `1`) and score is the cell value.

Greedy ("prefer `2`s") fails — path connectivity (only right/down) forces specific cells onto every path.

## Solution

### State

`dp[i][j][c]` = maximum score reaching cell `(i, j)` using **exactly** `c` units of cost.

### Transition

Let `val = grid[i][j]`, `cost = 0 if val == 0 else 1`. From top or left:

```
dp[i][j][c] = val + max(dp[i-1][j][c - cost], dp[i][j-1][c - cost])
```

with `-inf` sentinels for unreachable states. `c` ranges from `cost` upward.

### Base Case

`dp[0][0][0] = 0` (problem guarantees `grid[0][0] == 0`). All other entries start at `-inf`.

### Cost Cap

The path has exactly `m + n - 1` cells, so total cost cannot exceed `m + n - 1`. Use `K = min(k, m + n - 1)` as the third-dimension size — important when `k` is loose (`k = 1000`, grid `200x200`) to avoid wasted work.

### Answer

`max(dp[m-1][n-1][c] for c in 0..K)`. If all are `-inf`, return `-1`.

### Space Optimization

Only the previous row is needed for transitions. Use two rolling rows of size `n × (K + 1)` instead of the full `m × n × (K + 1)` cube. Cuts memory from ~16M ints to ~80K ints for worst-case input.

## Complexity

- **Time:** `O(m * n * min(k, m + n - 1))` — worst case ≈ 200 × 200 × 399 ≈ 16M ops.
- **Space:** `O(n * min(k, m + n - 1))` with rolling rows.

## Edge Cases

- `1x1` grid: `grid[0][0] == 0`, cost 0, score 0 → return 0 regardless of `k`.
- `k = 0`: only paths through all-zero cells are valid; otherwise `-1`.
- Bottom-right cell value is `1` or `2`: budget must accommodate its mandatory cost.
- `k >= m + n - 1`: budget is effectively unlimited; problem reduces to plain max-score grid DP.
