# Approach

**Tags:** `Array`, `Hash Table`, `Counting`

## Intuition

If `nums` is good, then `n` must be the maximum value in the array. For that `n`, the required array has:

- length `n + 1`
- each value from `1` to `n - 1` exactly once
- value `n` exactly twice

So checking the maximum, length, and frequencies is sufficient.

## Approach

1. Let `n = max(nums)`.
2. If `len(nums) != n + 1`, return `false`.
3. Count the frequency of every value.
4. For each value from `1` to `n - 1`, verify frequency is `1`.
5. Verify frequency of `n` is `2`.

## Complexity

- **Time:** O(m), where `m = len(nums)`
- **Space:** O(m), for the frequency table

## Edge Cases

- `nums = [1, 1]` -> valid `base[1]`
- Wrong length -> immediately invalid
- Missing values from `1..n-1`
- Maximum value appears fewer or more than two times
