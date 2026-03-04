# Approach

**Tags:** `Array`, `Matrix`

## Intuition

A position is special if it's a `1` and it's the only `1` in both its row and column. Pre-compute the count of `1`s in each row and column, then check each `1` against these counts.

## Solution

1. **First pass**: Count the number of `1`s in each row and column
   - `rowCount[i]` = number of 1s in row i
   - `colCount[j]` = number of 1s in column j

2. **Second pass**: For each cell with value `1`, check if:
   - `rowCount[i] == 1` (only one 1 in this row)
   - `colCount[j] == 1` (only one 1 in this column)
   
   If both conditions are true, it's a special position.

## Complexity

- **Time:** O(m × n) — two passes through the matrix
- **Space:** O(m + n) — arrays for row and column counts

## Edge Cases

- All zeros → return 0
- Identity matrix → return min(m, n)
- Single row/column → at most 1 special position
- All ones → return 0
