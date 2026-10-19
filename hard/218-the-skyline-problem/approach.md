# Approach

**Tags:** `Array`, `Divide and Conquer`, `Heap (Priority Queue)`, `Segment Tree`, `Binary Indexed Tree`

## Intuition

The skyline height at a given x is just the maximum height among the buildings
covering x. So the height function is piecewise constant, and a key point
appears precisely where that maximum changes. Nothing has to be drawn — sweep x
from left to right and watch the running maximum of a set that gains a building
at each left edge and loses one at each right edge.

A max-heap keyed by height gives the running maximum, but it cannot delete from
the middle when a building expires. The standard fix is lazy deletion: store
`(height, right)` together, and before reading the maximum, pop anything whose
`right` is at or behind the sweep position. Each building is pushed once and
popped once, so the total work stays O(n log n).

## Approach

1. Build `2n` events. A left edge becomes `(l, -h, r)` and a right edge becomes
   `(r, 0, 0)`.
2. Sort the events. The sort key `(x, -h)` does two necessary things beyond
   ordering by x:
   - At a shared x, starts (negative key) come before ends (key 0). Otherwise a
     building that ends exactly where another begins would momentarily drop the
     maximum and emit a key point that is not on the contour.
   - Among starts at the same x, `-h` ascending means the tallest enters first,
     so a shorter building never emits an intermediate point that the taller one
     immediately overwrites.
3. Sweep the events with a max-heap of `(height, right)`:
   - Pop while the top's `right <= x`. Those buildings no longer cover x.
   - If this is a start event, push `(h, r)`.
   - `cur` = top height, or 0 if the heap is empty.
   - If `cur` differs from the last emitted height, append `[x, cur]`.
4. Return the collected points.

The "no consecutive lines of equal height" rule in the statement is handled by
the single comparison against the last emitted height, which also absorbs
duplicate events at the same x.

No sentinel is kept in the heap. The usual trick pushes `(0, infinity)` so the
heap is never empty, but `right` and `x` both reach `2^31 - 1` here, so a guard
built from an int "infinity" can be popped and leave the heap empty. Testing
for emptiness and defaulting to 0 is shorter and safe at the coordinate limits.

## Complexity

- **Time:** O(n log n) — sorting `2n` events dominates; each building is pushed
  and popped at most once
- **Space:** O(n) for the events and the heap

## Edge Cases

- Gaps of ground between clusters → the heap empties, `cur` reads 0, and
  `[x, 0]` is emitted, which is the required contour along the ground
- Buildings touching at the same height, as in `[[0,2,3],[2,5,3]]` → the start
  at x = 2 is processed before the end at x = 2, so the maximum never dips and
  the equal-height check suppresses a point, giving `[[0,3],[5,0]]`
- A building fully nested inside a taller one → it enters and leaves without
  ever being the maximum, so it emits nothing
- Identical buildings → the second is never the strict maximum, no point emitted
- Many buildings sharing a left edge → taller-first ordering means only the
  tallest emits
- Single building → `[[l, h], [r, 0]]`
- `left = 0` is allowed, so x = 0 can be the first key point
- Heights and coordinates reach `2^31 - 1`, which fits a Java `int` exactly; the
  comparator uses `Integer.compare` rather than subtraction, since `b - a` would
  overflow at those magnitudes
- The input is given sorted by `left`, but the right edges are not, so the
  events still need a sort; relying on the given order would not help the
  complexity
