# Approach

**Tags:** `Array`, `Dynamic Programming`, `Matrix`

## Intuition

Moves are up / left / up-left, so travelling from `S` (bottom-right) to `E` (top-left) always decreases a coordinate. That makes it a clean grid DP: a cell `(i, j)` can only be entered from `(i+1, j)`, `(i, j+1)`, or `(i+1, j+1)` — the three cells "below/right" of it. We want both the maximum collectable sum and how many distinct paths hit that maximum.

## Approach

Two grids, filled with `i` and `j` decreasing (so predecessors are computed first):

- `best[i][j]` — max sum to reach `(i, j)` from `S` (−∞ if unreachable).
- `cnt[i][j]` — number of paths achieving `best[i][j]`, modulo `1e9 + 7`.

Base: `best[S] = 0`, `cnt[S] = 1`.

For every other non-`X` cell, look at the three predecessors, take the maximum reachable `best`, and:
- `best[i][j] = maxPred + value(i, j)` (value is 0 for `E`, digit otherwise),
- `cnt[i][j] = sum of cnt over predecessors that attain that maximum`.

If no predecessor is reachable (and the cell isn't `S`), the cell stays unreachable.

Answer: `[best[0][0], cnt[0][0]]` if `E` is reachable, else `[0, 0]`.

## Complexity

- **Time:** O(n²)
- **Space:** O(n²) — the two DP grids

## Edge Cases

- `E` unreachable (walled off by `X`) → `[0, 0]`
- `S` or `E` cells count as value 0 (don't add to the sum)
- Multiple predecessors tie on max sum → counts add (mod)
- Diagonal move allowed only onto a non-obstacle cell (handled by skipping `X`)
- Even the sum must be taken from a real path — an unreachable `E` returns `[0,0]`, not `[0, 1]`
