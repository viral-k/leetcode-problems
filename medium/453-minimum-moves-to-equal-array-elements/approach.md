# Approach

**Tags:** `Array`, `Math`

## Intuition

Adding 1 to every element except one changes the differences between elements exactly as subtracting 1 from that one element would. Only the differences matter for "all equal", so each move is really "decrease one element by 1". The cheapest target is then the minimum, since nothing can go below it without wasting moves, and every element `x` needs `x - min` moves to get there.

## Approach

1. Find `min(nums)`.
2. Return `sum(x - min for x in nums)`, which equals `sum(nums) - n * min(nums)`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- One element or all equal: 0 moves
- Negative values: only the differences matter, so the formula is unchanged
- `sum(nums)` alone can reach 10^14 and `n * min` can be just as large, so Java sums the differences `x - min` in a `long`; the final answer fits in an `int` by the problem's guarantee
