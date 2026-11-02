# Approach

**Tags:** `Array`, `Math`, `Sorting`

## Intuition

Every element moves to a common target `t`, at a cost of `sum(|x - t|)`. Picture `t` on the number line: shifting it one step right makes it 1 closer to every element on its right and 1 farther from every element on its left. So the total keeps falling while more elements lie on one side than on the other, and it stops at the point where both sides are equal. That point is the median.

Sorting finds the median in O(n log n), but only the median is needed, not the whole order. Quickselect finds it in expected O(n).

## Approach

1. Quickselect the element of rank `n // 2`:
   - pick a random pivot and three-way partition the range into `< pivot`, `== pivot`, `> pivot`;
   - if the target rank is in the middle band, the pivot is the median; otherwise keep only the side that holds it.
2. Return `sum(|x - median|)`.

For an even `n`, any `t` between the two middle values gives the same total, so the upper middle works.

## Complexity

- **Time:** O(n) expected (quickselect with a random pivot); O(n^2) only with vanishingly unlikely pivot choices
- **Space:** O(1) extra in Java (in-place partition); O(n) in Python, which partitions into new lists because list comprehensions are much faster than index swaps there

## Edge Cases

- One element or all equal: 0 moves
- Many duplicates: the three-way partition keeps quickselect linear instead of degrading on runs of equal values
- Even `n`: either middle element is optimal
- Already sorted or reverse sorted input: the random pivot keeps the expected time linear
- A single difference can be up to `2 * 10^9`, past `int`, so Java sums `|x - median|` in a `long`; the total fits in an `int` by the problem's guarantee
