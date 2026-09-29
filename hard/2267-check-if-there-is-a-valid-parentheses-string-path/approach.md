# Approach

**Tags:** `Array`, `Dynamic Programming`, `Matrix`, `Bit Manipulation`

## Intuition

A parentheses string is valid exactly when the running balance never drops below zero and ends at zero. That makes the balance the only thing a partial path needs to remember: two different paths reaching the same cell with the same balance are interchangeable for the rest of the journey. So the state is `(row, col, balance)`, and the question is whether balance 0 is reachable at the bottom-right cell.

Every path visits exactly `m + n - 1` cells, so an odd total length can never balance out and the answer is false without looking at the contents.

Because the state at a cell is a *set* of balances, it can be packed into a bitmask where bit `b` means "balance `b` is reachable here". Then the whole transition is two bit operations: union the masks coming from above and from the left, and shift by one. A `)` shifts right, and bit 0 falling off the end is exactly the path whose balance would go negative, discarded at no cost.

## Approach

1. If `(m + n - 1)` is odd, return false.
2. For each cell in row-major order:
   - the incoming mask is `dp[i-1][j] | dp[i][j-1]`, or just bit 0 set at the start cell (balance 0 before reading any character)
   - if `grid[i][j] == '('`, the stored mask is `incoming << 1` (capped to the largest possible balance); otherwise `incoming >> 1`
3. Return whether bit 0 is set in the bottom-right mask.

Row-major order works because both predecessors of a cell are already final when it is processed: the one above belongs to the previous row, the one on the left was computed earlier in this row.

The Java version keeps two boolean rows instead of bitmasks, since shifting a multi-word bitset by one is more code than it saves.

## Complexity

- **Time:** O(m * n * (m + n)) — one bitmask op per cell in Python, one balance loop per cell in Java
- **Space:** O(m * n) masks, or O(n * (m + n)) booleans with the rolling row

## Edge Cases

- Odd path length (`m + n - 1` odd, e.g. a 1x1 or 2x2... any grid where `m + n` is even) → false immediately
- `grid[0][0] == ')'` → the shift-right empties the mask on the first cell, so everything downstream is empty
- `grid[m-1][n-1] == '('` → bit 0 can never be set at the end
- A single row or single column: only one path exists, and the DP reduces to validating that one string
- Balance capped at `m + n - 1`; without a cap the Python mask would grow unboundedly wide on all-`(` grids
- An empty mask mid-grid is fine and propagates as "no path through here"
