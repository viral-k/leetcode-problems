# Approach

**Tags:** `Array`, `Hash Table`, `Math`, `Geometry`

## Intuition

Two points determine a line, so instead of enumerating lines, fix one point as an anchor and sort the rest by direction. All points sharing a direction from the anchor are collinear with it. The best line through the anchor is the largest such group plus the anchor itself.

Taking every point as the anchor in turn finds every line: a line holding `k >= 2` points is discovered when the anchor is whichever of its points comes first in the iteration, and only later points need to be considered from each anchor.

The part that needs care is the slope key. Floating-point division loses precision and makes near-parallel lines collide, and plain `dy/dx` as a fraction has multiple spellings for the same direction. Reducing `(dy, dx)` by their gcd and then normalising the sign gives one canonical key per direction, exactly, in integer arithmetic.

## Approach

1. If there are fewer than 3 points, the answer is the point count.
2. For each anchor `i`:
   - for each `j > i`, compute `dx = xj - xi`, `dy = yj - yi`
   - divide both by `gcd(|dx|, |dy|)`
   - normalise: if `dx < 0`, negate both; if `dx == 0`, force `dy = 1`
   - count keys in a dictionary
   - track `1 + max(counts)`
3. Return the overall maximum.

Normalising on `dx > 0` collapses opposite directions like `(1, 2)` and `(-1, -2)` into one key, which is what collinearity requires: direction sign is irrelevant to a line.

## Complexity

- **Time:** O(n^2) — one gcd per pair, 45k pairs at `n = 300`
- **Space:** O(n) for the per-anchor dictionary

## Edge Cases

- One or two points → the answer is just the number of points, with no pairs to inspect
- All points on a vertical line (`dx == 0`) → the key must be canonical, hence forcing `dy = 1`
- All points on a horizontal line (`dy == 0`) → after gcd reduction the key is `(0, 1)`
- Opposite directions from the anchor, e.g. anchor between two points, must share a key
- All points collinear → answer `n`
- No three points collinear → answer 2, found on the first anchor
- Points are guaranteed unique, so `dx` and `dy` are never both zero and the gcd is never zero
