# Approach

**Tags:** `Array`, `Backtracking`, `Recursion`

## Intuition

Two queens attack along a row, a column, or a diagonal. Placing **exactly one queen per row** satisfies the row constraint by construction, so the search only has to choose a column for each row — turning the board into a sequence of `n` decisions rather than `n^2` cell choices.

The remaining three conflicts have cheap constant-time tests if the right quantities are tracked:

- **Column:** the column index itself.
- **Main diagonal (`\`):** every cell on it shares the same `row - col`.
- **Anti-diagonal (`/`):** every cell on it shares the same `row + col`.

Keeping a set for each means "is this square attacked?" is three lookups, and undoing a placement is three removals — the essence of backtracking.

## Approach

1. Recurse on the current row, starting at row 0.
2. For each column `c` in that row:
   - Skip if `c` is in `cols`, or `row - c` is in `diags`, or `row + c` is in `antis`.
   - Otherwise record the placement, add the three keys, and recurse on `row + 1`.
   - On return, remove the keys and undo the placement (backtrack).
3. When the row index reaches `n`, every row holds a queen — render the placement into strings and append it to the results.

## Complexity

- **Time:** O(n!) in the worst case — the branching shrinks by at least one column per row, and pruning cuts far more in practice
- **Space:** O(n) for the recursion and the three sets, plus O(number of solutions * n) for the output

## Edge Cases

- `n == 1` → a single solution, `[["Q"]]`
- `n == 2` and `n == 3` → no solutions, so an empty list is returned
- Diagonal keys `row - col` can be negative; a set (or an offset array) handles that
- Each solution is generated once because rows are filled in a fixed order, so no de-duplication is needed
- `n <= 9` keeps the search small (the largest case, `n = 9`, has 352 solutions)
