# Approach

**Tags:** `Array`, `Math`, `Matrix`

## Intuition

A clockwise rotation moves each value from `(row, col)` to `(col, n - 1 - row)`. Instead of creating another matrix, we can get the same final layout with two in-place operations:

1. Transpose the matrix across the main diagonal.
2. Reverse each row.

After transposing, rows become columns. Reversing each row then puts those columns in clockwise order.

## Approach

1. Let `n` be the matrix size.
2. Transpose the matrix:
   - Swap `matrix[row][col]` with `matrix[col][row]` for every `col > row`.
3. Reverse every row in-place.

## Complexity

- **Time:** O(n²) — each matrix cell is touched a constant number of times
- **Space:** O(1) — only temporary variables are used

## Edge Cases

- `n = 1` → the matrix remains unchanged
- Negative values → values are only moved, not compared or computed
- Even and odd `n` → transpose and row reversal handle both
