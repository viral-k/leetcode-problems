# Approach

**Tags:** `Array`, `Greedy`, `Math`

## Intuition

For any subarray, `max - min` can never exceed the difference between the global maximum and the global minimum of the whole array, because narrowing the window can only lower the max or raise the min. The full array itself achieves exactly `globalMax - globalMin`, so that is the largest value any single subarray can have.

Since we may pick the same subarray as many times as we like, the greedy choice is to pick this single best subarray all `k` times.

## Approach

1. Find `globalMax` and `globalMin` of `nums` in one pass.
2. The best per-pick value is `globalMax - globalMin`.
3. The answer is `k * (globalMax - globalMin)`.

Use 64-bit arithmetic: `k` can be up to `10^5` and the spread up to `10^9`, so the product can reach ~`10^14`.

## Complexity

- **Time:** O(n) — single pass to find the min and max
- **Space:** O(1)

## Edge Cases

- All elements equal -> spread is `0`, answer is `0`
- Single element (`n == 1`) -> only subarray has value `0`, answer is `0`
- Large `k` and large spread -> result overflows 32-bit, requires `long`
