# Approach

**Tags:** `Array`, `Math`, `Dynamic Programming`

## Intuition

The direct way is to build every rotated array and compute its weighted sum, but that repeats almost all of the same work. When the array rotates once clockwise, every element's index increases by `1`, except the element moved from the end to the front, whose contribution drops from `(n - 1) * value` to `0`.

That gives a recurrence between consecutive rotation values.

## Solution 1: Brute Force

1. For each rotation `k`, compute every contribution `i * arrk[i]`.
2. Track the maximum value.

This is useful for understanding the problem, but it is too slow for `n <= 10^5` because it takes O(n²) time.

## Solution 2: Optimized Recurrence

Let:

- `total = sum(nums)`
- `current = F(k - 1)`

When moving from `F(k - 1)` to `F(k)`:

1. Every number contributes one extra copy of itself because its index increases by `1`.
2. The number `nums[n - k]` wraps from the last position to the front, so subtract `n * nums[n - k]`.

So:

`F(k) = F(k - 1) + total - n * nums[n - k]`

Compute `F(0)` once, then use this recurrence for `k = 1` to `n - 1`.

## Complexity

- **Time:** O(n) — compute the initial sum once and update each rotation in O(1)
- **Space:** O(1) — only a few variables are needed

## Edge Cases

- Single element → all rotations have value `0`
- Negative numbers → still works because the recurrence is algebraic
- All same elements → every rotation has the same value
- Maximum constraints → avoids constructing rotated arrays
