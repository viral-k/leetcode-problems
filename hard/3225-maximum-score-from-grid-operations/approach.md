# Approach

**Tags:** `Array`, `Dynamic Programming`, `Matrix`, `Prefix Sum`

## Intuition

For each column j, choose a "height" h[j] = number of black cells (0 to n). A white cell (i,j) scores if it's white (i >= h[j]) AND has adjacent black cell (i < h[j-1] OR i < h[j+1]).

Score from column j = sum of grid[i][j] for h[j] <= i < max(h[j-1], h[j+1]).

## Solution

### DP State

`dp[a][b]` = max score where h[prev_col] = a, h[curr_col] = b, with all previous columns fully scored.

### Transition

When moving from column j to j+1:
- Column j's contribution = psum[j][max(a, c)] - psum[j][b] if max(a, c) > b

Where a = h[j-1], b = h[j], c = h[j+1].

### Optimization

Use prefix/suffix max arrays to reduce from O(n^4) to O(n^3):
- `suffix[a][b]` = max over k >= a of (dp[k][b] + psum[j][k])
- `prefix[a][b]` = max over k < a of dp[k][b]

For c > b: contribution comes from either a >= c or a < c case.
For c <= b: contribution only from a > b.

## Complexity

- **Time:** O(n³)
- **Space:** O(n²)

## Edge Cases

- Single column → score is 0
- All zeros → score is 0
- Large values requiring long long in Java
