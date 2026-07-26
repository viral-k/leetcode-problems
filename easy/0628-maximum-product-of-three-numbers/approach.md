# Approach

**Tags:** `Array`, `Math`, `Sorting`

## Intuition

If all numbers were non-negative, the answer would just be the three largest. But negatives flip the game: the product of the **two most negative** values is a large positive, which paired with the largest value can beat the top three. So exactly two candidates need comparing:

- `max1 * max2 * max3` (three largest)
- `min1 * min2 * max1` (two smallest × largest)

Every optimal triple falls into one of these two shapes.

## Approach

1. In a single pass, track the three largest values (`max1 >= max2 >= max3`) and the two smallest (`min1 <= min2`).
2. Return `max(max1 * max2 * max3, min1 * min2 * max1)`.

(Sorting and reading the ends works too, at O(n log n); the linear scan avoids the sort.)

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- All negative (Example 3) → three largest (least negative) win: `-1 * -2 * -3 = -6`
- Mix of signs → two-negatives-times-max path may win (e.g. `[-10,-10,1,3,2]` → 300)
- Product magnitude ≤ 1000³ = 10^9, fits in 32-bit `int`, but `long` in Java is harmless
- Exactly three elements → both candidates coincide
