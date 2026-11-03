# Approach

**Tags:** `Array`, `Math`

## Intuition

Moves only increase values, so no element can come down to meet the others. The common target has to be at least `max(nums)`, and every step above it costs `n` extra moves. So the target is the max, and each element `x` needs `max - x` moves.

## Approach

1. Find `max(nums)` and `sum(nums)`.
2. Return `n * max - sum`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- One element or all equal: 0 moves
- Only the max differs from the rest (`[1,1,5]`): every other element climbs to it
- Constraints are tiny (`n, nums[i] <= 100`), so no overflow concerns
