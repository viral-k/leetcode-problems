# Approach

**Tags:** `Array`, `Binary Search`, `Matrix`, `Prefix Sum`

## Intuition

Use 2D prefix sum to compute any submatrix sum in O(1). Binary search on the side length since if a square of size L works, all smaller squares also work (monotonic property).

## Solution

1. **Build prefix sum matrix**: `pref[i][j]` = sum of all elements in submatrix from (0,0) to (i-1,j-1).

2. **Binary search on side length**: Search for the maximum L where at least one L×L square has sum ≤ threshold.

3. **Check if side L is possible**: For each possible top-left corner, compute the L×L square sum using prefix sum formula:
   ```
   sum = pref[i+L][j+L] - pref[i][j+L] - pref[i+L][j] + pref[i][j]
   ```

4. **Return maximum valid side**: The largest L where `possible(L)` returns true.

## Complexity

- **Time:** O(m × n × log(min(m, n))) — prefix sum O(mn), binary search O(log(min)) with O(mn) check each
- **Space:** O(m × n) — prefix sum matrix

## Edge Cases

- All elements exceed threshold → return 0
- Single cell ≤ threshold → return 1
- Entire matrix sum ≤ threshold → return min(m, n)
