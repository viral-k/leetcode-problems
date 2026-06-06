# Approach

**Tags:** `Array`, `Prefix Sum`

## Intuition

For each index, the left sum can be tracked while scanning from left to right.

If we know the total sum of the array, then the right sum at index `i` is:

```
total - leftSum - nums[i]
```

So we do not need to build separate `leftSum` and `rightSum` arrays.

## Approach

1. Compute the total sum of `nums`.
2. Initialize `leftSum = 0`.
3. For each index `i`:
   - compute `rightSum = total - leftSum - nums[i]`
   - append `abs(leftSum - rightSum)` to the answer
   - add `nums[i]` to `leftSum`
4. Return the answer.

## Complexity

- **Time:** O(n) — scan the array once after computing the total
- **Space:** O(1) extra, excluding the returned answer

## Edge Cases

- Single element -> both side sums are `0`
- First index -> left sum is `0`
- Last index -> right sum is `0`
- Large values -> sums fit within normal integer ranges for the constraints
