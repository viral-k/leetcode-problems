# Approach

**Tags:** `Array`, `Hash Table`, `Matrix`

## Intuition

A translation is fully described by one offset vector `(dr, dc)`. Under that translation, a `1` at `(r, c)` in `img1` lands on `(r + dr, c + dc)`, and it contributes to the overlap exactly when `img2` has a `1` there.

Flip the question around. Instead of picking a translation and counting overlaps, look at every pair of a `1` in `img1` and a `1` in `img2`. That pair overlaps under exactly **one** translation, the vector that carries the first onto the second: `(r2 - r1, c2 - c1)`. So if each pair casts a vote for its vector, the number of votes a vector receives is precisely the overlap that translation produces. The answer is the largest vote count.

This also makes the border rule automatic. A `1` that would be shifted off the grid never aligns with any `1` in `img2`, so it simply never appears in a pair.

## Approach

1. Collect the coordinates of every `1` in `img1` and every `1` in `img2`.
2. For every pair `(p1, p2)`, increment a counter keyed by the vector `(p2.r - p1.r, p2.c - p1.c)`.
3. Return the maximum counter value, or `0` if either image has no `1`s.

Encoding the vector as a single integer (offset both components by `n` so they are non-negative) allows a flat array instead of a hash map in Java.

## Complexity

- **Time:** O(k1 * k2), where `k1`, `k2` are the counts of `1`s (each at most `n^2 = 900`), so about 8 * 10^5 pair checks at worst
- **Space:** O(n^2) — at most `(2n - 1)^2` distinct vectors

## Edge Cases

- Either image entirely `0` → no pairs → 0 (Example 3)
- Both images `[[1]]` → the zero vector gets one vote → 1 (Example 2)
- The zero translation (no shift) is just another vector and needs no special handling
- Identical images → the zero vector wins with a count equal to the number of `1`s
- Vector components range over `[-(n-1), n-1]`, so an array index needs an offset of `n - 1` or larger
