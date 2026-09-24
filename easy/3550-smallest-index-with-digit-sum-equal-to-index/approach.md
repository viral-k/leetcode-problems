# Approach

**Tags:** `Array`, `Math`

## Intuition

The condition is per-index and independent of everything else, so a single left-to-right scan finds the smallest matching index. Returning on the first match is what makes it smallest.

## Approach

1. For each index `i`, compute the digit sum of `nums[i]` by repeatedly taking `value % 10` and dividing by 10.
2. Return `i` as soon as the digit sum equals `i`.
3. Return -1 after the loop.

## Complexity

- **Time:** O(n * d) where `d <= 4` is the digit count
- **Space:** O(1)

## Edge Cases

- `nums[0] = 0` → digit sum 0 matches index 0, so answer 0
- Index 0 with a non-zero value never matches, since every positive number has digit sum at least 1
- `nums[i] = 1000` → digit sum 1, matches only at index 1
- Max digit sum here is 9 + 9 + 9 = 27 (from 999), so indices above 27 can never match; not worth special-casing at `n <= 100`
- No match anywhere → -1 (Example 3)
