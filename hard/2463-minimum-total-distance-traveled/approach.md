# Approach

**Tags:** `Array`, `Dynamic Programming`, `Sorting`

## Intuition

After sorting both robots and factories by position, optimal assignments don't cross (if robot A is left of robot B, A's factory is not to the right of B's factory). This allows a DP solution.

## Solution

### Step 1: Sort

Sort robots and factories by position. This ensures optimal non-crossing assignments.

### Step 2: Expand Factories

Convert each factory with limit L into L individual "slots" at that position. This simplifies the DP to 1-to-1 matching.

### Step 3: DP

`dp[i][j]` = minimum distance to assign first `i` robots to first `j` factory slots

**Transitions:**
- Don't use slot j for robot i: `dp[i][j] = dp[i][j-1]`
- Use slot j for robot i: `dp[i][j] = dp[i-1][j-1] + |robot[i-1] - slot[j-1]|`

### Base Cases

- `dp[0][j] = 0` — no robots to assign
- `dp[i][0] = infinity` for i > 0 — can't assign robots without slots

### Answer

`dp[n][m]` where n = number of robots, m = total slots

## Complexity

- **Time:** O(n × m) where m = sum of all factory limits
- **Space:** O(n × m), can optimize to O(m)

## Edge Cases

- Single robot, single factory
- All robots at same position
- Factory with limit 0 (skip it)
- Large negative/positive positions
