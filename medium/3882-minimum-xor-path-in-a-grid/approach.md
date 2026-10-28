# Approach

**Tags:** `Array`, `Dynamic Programming`, `Bit Manipulation`, `Matrix`

## Intuition

The normal minimum-path DP keeps one best value per cell. That fails for XOR,
because a larger value at one cell can become a smaller value later. For
example, `4 XOR 4 = 0` while `3 XOR 4 = 7`, so the path that was worse at the
earlier cell ends up better. Keeping only the minimum throws away the path that
would have won.

The constraint that saves us is the value range. Every cell is at most 1023,
which is 10 bits, so the XOR of any path is also in `0..1023`. That means each
cell can afford to keep the whole set of XOR values that some path can have when
it arrives there, and the set never holds more than 1024 numbers.

Keeping the set is exact. Two paths that reach the same cell with the same XOR
behave identically from then on, so one copy per value is enough.

## Approach

1. `reach(0, 0) = {grid[0][0]}`.
2. For every other cell, take the union of the sets from the cell above and the
   cell to the left, and XOR each value with `grid[r][c]`.
3. Return the smallest value in `reach(m - 1, n - 1)`.

Only the previous row is needed to compute the current one, so the sets are
stored one row at a time.

## Complexity

- **Time:** O(m * n * V) with V = 1024, at most about 10^6 steps since
  `m * n <= 1000`
- **Space:** O(n * V) for one row of sets

## Edge Cases

- A single row or a single column has exactly one path, so the answer is the
  XOR of every cell (example 3 gives 0)
- A 1 x 1 grid → the answer is the cell's own value
- All zeros → 0
- Repeated values cancel in pairs, so long paths can still end at small values;
  this is exactly why the minimum cannot be kept greedily
- The set at a cell never exceeds 1024 entries, no matter how many paths reach
  it
