# Approach

**Tags:** `Math`, `Geometry`

## Intuition

A circle and a rectangle overlap exactly when the rectangle's nearest point to the circle's center lies inside the circle. For an axis-aligned rectangle the nearest point is easy: clamp the center's x into `[x1, x2]` and its y into `[y1, y2]`. Each coordinate is independent because the rectangle is a product of two intervals, and clamping minimises each squared difference separately.

If the center is inside the rectangle, clamping leaves it unchanged and the distance is 0. If it is outside, the clamped point sits on the nearest edge or corner.

## Approach

1. `cx = min(max(xCenter, x1), x2)`, `cy = min(max(yCenter, y1), y2)`.
2. `dx = xCenter - cx`, `dy = yCenter - cy`.
3. Return `dx*dx + dy*dy <= radius*radius`.

Everything stays in integers, so there is no floating point tolerance to worry about, and the largest value (`2 * 10^4` squared, times two) fits comfortably in a 32-bit int.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Edge Cases

- Circle touching the rectangle at a single boundary point (Example 1) → `<=` makes tangency count as overlap
- Center inside the rectangle → distance 0, always `true`
- Center diagonally past a corner, close in each axis but far along the diagonal → the corner distance decides, not the per-axis gap
- Center aligned with an edge but far away → clamped point is on that edge
- Large coordinates: `dx`, `dy` up to `2 * 10^4`, squared sum up to `8 * 10^8`, still within `int`
