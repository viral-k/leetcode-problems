# Approach

**Tags:** `Array`, `Math`, `Sorting`

## Intuition

Every value is at least 1, so `nums[i] - 1 >= 0` — no negatives to worry about. The product `(x-1)(y-1)` of two non-negative terms is maximized by taking the two largest values. Two different indices are required, but tracking the top two by value (with the second-largest allowed to equal the largest when it appears twice) handles that.

## Approach

1. Scan once, keeping the largest (`max1`) and second-largest (`max2`) values.
2. Return `(max1 - 1) * (max2 - 1)`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Duplicate maximum (Example 2) → both `max1` and `max2` equal that value
- Exactly two elements → they are the two used
- Values of 1 → contribute a `0` factor; only matter if nothing larger exists
- Product ≤ (10³−1)² < 10^6, well within `int`
