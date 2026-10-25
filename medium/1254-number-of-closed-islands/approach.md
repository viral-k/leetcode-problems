# Approach

**Tags:** `Array`, `Depth-First Search`, `Breadth-First Search`, `Matrix`

## Intuition

An island is closed exactly when none of its cells is on the grid border. A
cell on the border has open space beyond the grid on at least one side, so its
island cannot be surrounded. An island with no border cell is, by maximality,
bounded on every side by water: any land neighbour would belong to the island.

So each island needs one flood fill and one yes/no fact: did it touch the edge?

## Approach

1. Scan every cell. On an unvisited `0`, start a flood fill of its island with
   an explicit stack, marking cells visited by setting them to `1`.
2. While flooding, set `closed = False` if any cell has `r == 0`, `c == 0`,
   `r == m - 1` or `c == n - 1`.
3. When the stack empties, count the island if `closed` is still true.

The fill has to run to completion even after a border cell is found. Stopping
early would leave the rest of the island unmarked, and the scan would later
pick up the leftover piece and count it as a separate island, which may wrongly
look closed.

The stack is explicit because a single winding island in a 100 x 100 grid can
hold around 5000 cells, deeper than Python's default recursion limit.

## Complexity

- **Time:** O(m * n) — every cell is pushed at most once
- **Space:** O(m * n) in the worst case for the stack; the grid doubles as the
  visited set

## Edge Cases

- Grids with one row or one column → every cell is on the border, answer 0
- All water → 0
- All land → one island, touching the border, so 0
- A ring of land around a lake around another island (example 3) → the inner
  island and the ring are both closed, giving 2
- An island that touches the border at a single cell is open, and that cell
  can be far from where the flood started
- Diagonal contact does not connect islands; only the four orthogonal
  neighbours are followed
- The input grid is modified in place. That is fine for LeetCode; a caller that
  needs the grid afterwards should pass a copy
