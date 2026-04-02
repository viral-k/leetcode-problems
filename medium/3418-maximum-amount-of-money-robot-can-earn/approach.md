# Approach

**Tags:** `Array`, `Matrix`, `Dynamic Programming`

## Intuition

Standard grid DP with an extra dimension: we can neutralize up to 2 negative cells. Track how many neutralizations have been used at each position.

## Solution

### State Definition

`dp[i][j][k]` = maximum coins at cell `(i, j)` with `k` neutralizations used (k = 0, 1, or 2)

### Transitions

For each cell `(i, j)` with value `val`, coming from top or left:

**Option 1: Don't neutralize**
```
dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k]) + val
```

**Option 2: Neutralize (only if val < 0 and k > 0)**
```
dp[i][j][k] = max(dp[i-1][j][k-1], dp[i][j-1][k-1]) + 0
```

### Base Case

At `(0, 0)`:

- If `coins[0][0] >= 0`: all states start with `coins[0][0]`
- If `coins[0][0] < 0`: 
  - `dp[0][0][0] = coins[0][0]` (no neutralize)
  - `dp[0][0][1] = dp[0][0][2] = 0` (neutralize)

### Answer

`max(dp[m-1][n-1][0], dp[m-1][n-1][1], dp[m-1][n-1][2])`

## Complexity

- **Time:** O(m × n × 3) = O(m × n)
- **Space:** O(m × n × 3) = O(m × n)

## Edge Cases

- All positive values → no need to neutralize
- All negative values → neutralize the 2 largest losses
- Single cell grid
- Start or end cell is negative
