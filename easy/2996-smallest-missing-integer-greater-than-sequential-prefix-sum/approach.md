# Approach

**Tags:** `Array`, `Hash Table`, `Simulation`

## Intuition

A "sequential prefix" must start at index 0, so there's exactly one longest such prefix: the maximal run from the front where each element is one more than the previous. Sum it, then walk upward from that sum until hitting a value not in `nums`.

## Approach

1. Start with `total = nums[0]`. Extend while `nums[j] == nums[j-1] + 1`, adding each element to `total`; stop at the first break.
2. Put `nums` into a set.
3. From `x = total` upward, return the first `x` not in the set.

The search terminates quickly: values are bounded by 50, so any `x` above 50 is immediately missing.

## Complexity

- **Time:** O(n + A) where A is how far the upward scan goes (bounded by ~51 here)
- **Space:** O(n) — the membership set

## Edge Cases

- Single element → the prefix is just `nums[0]`, sum is that value
- Prefix breaks immediately (`nums[1] != nums[0]+1`) → sum is `nums[0]`
- The sum itself may exceed all values in `nums` → answer is the sum
- Consecutive values above the sum must be skipped (Example 2: 12, 13, 14 present → 15)
- Note the prefix must start at index 0; a longer sequential run later in the array does not count
