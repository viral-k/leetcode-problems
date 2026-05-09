# Approach

**Tags:** `Array`, `Matrix`, `Simulation`

## Intuition

Each layer is an independent cycle. If we list a layer's cells around the border, one rotation moves each value into the adjacent cell in the counter-clockwise direction. With the coordinate order used below, the value written at position `i` should come from position `(i - k) % length`.

Because `k` can be large, reduce it by the layer length.

## Approach

1. Process each layer from outside to inside.
2. Collect the layer coordinates in counter-clockwise order:
   - down the left column
   - right along the bottom row
   - up the right column
   - left along the top row
3. Store the values at those coordinates.
4. For each coordinate index `i`, write `values[(i - k) % length]` back to that coordinate.

## Complexity

- **Time:** O(m × n) — every cell belongs to exactly one layer
- **Space:** O(m + n) — temporary storage for one layer at a time

## Edge Cases

- `2 x 2` grid -> one layer with four cells
- Large `k` -> use modulo per layer
- Rectangular grids -> layer boundaries handle unequal dimensions
