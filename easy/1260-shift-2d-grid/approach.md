# Approach

**Tags:** `Array`, `Matrix`, `Simulation`

## Intuition

The three shift rules together describe one simple thing: read the grid in **row-major order** and everything moves one step forward, wrapping from the last cell back to the first. So the 2D shift is just a **right rotation of the flattened 1D array**, and applying it `k` times is a rotation by `k`.

Since rotating by `m * n` returns the grid to its original state, only `k mod (m * n)` matters — no need to loop `k` times.

## Approach

1. Let `total = m * n` and reduce `k %= total`.
2. For each cell `(i, j)`, its flat index is `idx = i * n + j`; it moves to flat index `(idx + k) % total`.
3. Write each value into a fresh result grid at row `newIdx / n`, column `newIdx % n`.

## Complexity

- **Time:** O(m · n) — a single pass, independent of `k`
- **Space:** O(m · n) — the output grid

## Edge Cases

- `k = 0` → grid unchanged
- `k` a multiple of `m * n` (Example 3) → unchanged after the modulo
- `k > m * n` → handled by the modulo
- Single row or single column → still a plain rotation of the flattened order
- Negative values are just data; they don't affect the index math
