# Approach

**Tags:** `Math`, `Geometry`

## Intuition

Two axis-aligned rectangles overlap only if they overlap along the X-axis **and** along the Y-axis independently. Each axis reduces to a one-dimensional question: do the intervals `[x1, x2]` of the two rectangles share an open segment?

Two intervals `[a1, a2]` and `[b1, b2]` share positive length exactly when each one starts before the other ends: `a1 < b2` and `b1 < a2`. The strict `<` is what encodes "touching does not count" — if `a2 == b1` the intervals meet at a point, the shared length is zero, and the test correctly fails.

Apply the same test to the Y-intervals and require both to pass.

## Approach

Return `true` iff all four hold:

- `rec1[0] < rec2[2]` — rec1's left edge is left of rec2's right edge
- `rec2[0] < rec1[2]` — rec2's left edge is left of rec1's right edge
- `rec1[1] < rec2[3]` — rec1's bottom is below rec2's top
- `rec2[1] < rec1[3]` — rec2's bottom is below rec1's top

Only comparisons are used, so coordinates at `±10^9` never risk overflow the way a width-times-height product would.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Edge Cases

- Sharing an edge (Example 2) → one comparison hits equality → `false`
- Sharing only a corner → two comparisons hit equality → `false`
- One rectangle fully inside the other → `true` (all four strict inequalities hold)
- Fully disjoint (Example 3) → `false`
- Negative coordinates behave identically; nothing depends on sign
