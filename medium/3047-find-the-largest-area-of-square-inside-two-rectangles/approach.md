# Approach

**Tags:** `Array`, `Math`, `Geometry`

## Intuition

For each pair of rectangles, compute their intersection. If the intersection exists, the largest square that fits inside it has a side length equal to the minimum of the intersection's width and height.

## Solution

1. **Iterate all pairs**: Check every pair of rectangles `(i, j)` where `i < j`.

2. **Compute intersection**: For rectangles A and B:
   - `left = max(A.x1, B.x1)`
   - `right = min(A.x2, B.x2)`
   - `bottom = max(A.y1, B.y1)`
   - `top = min(A.y2, B.y2)`

3. **Check validity**: Intersection exists if `right > left` and `top > bottom`.

4. **Compute max square side**: If intersection exists, the largest square side is `min(right - left, top - bottom)`.

5. **Track maximum**: Keep the maximum side across all pairs.

6. **Return area**: Return `maxSide * maxSide`.

## Complexity

- **Time:** O(n²) — checking all pairs of rectangles
- **Space:** O(1) — only storing max side

## Edge Cases

- No rectangles intersect → return 0
- Intersection is a line (width or height is 0) → no square fits
- Multiple pairs have same max square → any valid answer works
