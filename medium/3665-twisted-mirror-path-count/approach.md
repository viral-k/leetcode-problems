# Approach

**Tags:** `Array`, `Dynamic Programming`, `Matrix`

## Intuition

Plain grid path counting, except a mirror cell is never a place the robot stands. It is a turn whose result depends on the direction the robot came from: entering moving right sends it down, entering moving down sends it right. So the DP needs one extra bit per cell, the direction of entry. Moves still only go right or down, so row-major order works and chains of mirrors resolve on their own, one cell at a time.

## Approach

1. Let `R[i][j]` = ways to enter `(i, j)` moving right, and `D[i][j]` = ways to enter it moving down.
2. Walk the grid row by row, left to right. At each cell:
   - **Empty:** the robot stops here and picks either move. With `t = R + D`, add `t` to `R[i][j+1]` and to `D[i+1][j]`.
   - **Mirror:** add `R[i][j]` to `D[i+1][j]` (right turns into down), and `D[i][j]` to `R[i][j+1]` (down turns into right).
   - Anything sent past the grid edge is dropped, since those paths are invalid.
3. Start with `t = 1` at `(0, 0)`. The answer is `R + D` at `(m-1, n-1)`, mod `10^9 + 7`.
4. `D` only flows to the next row and `R` only to the next column, so keep one `down` array for the row and one running `right` value.

## Complexity

- **Time:** O(m * n)
- **Space:** O(n)

## Edge Cases

- Chains of mirrors (example 3): each mirror passes its count on with the turn applied, so a chain needs no special loop
- A mirror on the last row hit while moving right, or on the last column hit while moving down, sends the robot out of the grid: the count is dropped
- A mirror's two incoming streams swap directions instead of merging, so the two counts must stay separate
- Start and end are guaranteed empty, so `(0, 0)` seeds with 1 and the answer is read at an empty cell
- Take the mod on every addition. In Java, `R + D` of two values below `10^9 + 7` can overflow `int`, so the sum is done in `long`
