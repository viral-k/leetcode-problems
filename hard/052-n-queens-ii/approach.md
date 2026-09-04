# Approach

**Tags:** `Backtracking`, `Bit Manipulation`, `Recursion`

## Intuition

Identical search to N-Queens (problem 51) — place one queen per row, so rows never conflict and only column and diagonal attacks need checking — but here only the **count** matters, so no board is ever built.

That frees the state to be three **bitmasks** instead of sets:

- `cols` — columns already occupied.
- `diag` — squares attacked along `\` diagonals.
- `anti` — squares attacked along `/` diagonals.

The trick that makes diagonals work as plain bitmasks: when moving down one row, a `\` threat shifts one column left and a `/` threat one column right. So instead of indexing by `row - col` / `row + col`, shift the masks by one (`diag << 1`, `anti >> 1`) as the recursion descends, and they stay aligned with the current row.

Then all safe columns are computed at once:

```
avail = ~(cols | diag | anti) & full
```

and the standard `p = avail & -avail` isolates the lowest set bit to iterate candidates without scanning every column.

## Approach

1. Let `full = (1 << n) - 1`.
2. Recurse with `(cols, diag, anti)`; if `cols == full`, every row is placed — count one solution.
3. Compute `avail = ~(cols | diag | anti) & full`.
4. While `avail` is nonzero:
   - `p = avail & -avail` (lowest available column), then clear it: `avail -= p`.
   - Recurse with `(cols | p, (diag | p) << 1 & full, (anti | p) >> 1)`.
5. Return the accumulated count.

Masking `& full` after the left shift keeps the mask from growing past `n` bits.

## Complexity

- **Time:** O(n!) worst case, with a small constant — the bitmask does all three conflict checks in one operation
- **Space:** O(n) recursion depth, and no board storage

## Edge Cases

- `n == 1` → one solution
- `n == 2`, `n == 3` → no solutions, so `0`
- `n == 9` → 352 solutions, the largest case under the constraints
- Passing masks by value means backtracking is implicit — nothing needs to be undone on return
- The right shift needs no masking; bits falling off the low end are genuinely off-board
