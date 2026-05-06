# Approach

**Tags:** `Array`, `Two Pointers`, `Matrix`, `Simulation`

## Intuition

After the box rotates clockwise, stones fall downward. In the original orientation, that is equivalent to stones sliding to the right within each row until blocked by an obstacle or another stone.

So we can first settle stones in each row from right to left, then rotate the settled box.

## Approach

1. For each row, set `empty` to the rightmost column.
2. Scan the row from right to left.
3. If an obstacle `'*'` is found:
   - stones cannot cross it
   - reset `empty` to the cell immediately left of the obstacle
4. If a stone `'#'` is found:
   - move it to `empty`
   - mark the original cell as empty if it moved
   - decrement `empty`
5. After gravity is simulated in all rows, rotate the matrix clockwise:
   - original `(row, col)` moves to `(col, m - 1 - row)`

## Complexity

- **Time:** O(m × n) — each cell is processed a constant number of times
- **Space:** O(m × n) — required for the returned rotated matrix

## Edge Cases

- Single row or single column
- Rows with no stones
- Rows with only obstacles
- Obstacles splitting a row into independent gravity segments
