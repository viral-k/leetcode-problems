# Approach

**Tags:** `Array`, `Binary Search`

## Intuition

This is the same rotated-array minimum problem as problem 153, except duplicates can make one binary-search comparison ambiguous.

Compare `nums[mid]` with `nums[right]`:

- If `nums[mid] > nums[right]`, the minimum is strictly to the right of `mid`.
- If `nums[mid] < nums[right]`, the minimum is at `mid` or to the left of `mid`.
- If `nums[mid] == nums[right]`, we cannot determine which side contains the minimum, but removing `right` is safe because `nums[mid]` has the same value.

## Approach

1. Set `left = 0` and `right = len(nums) - 1`.
2. While `left < right`:
   - compute `mid`
   - if `nums[mid] > nums[right]`, set `left = mid + 1`
   - else if `nums[mid] < nums[right]`, set `right = mid`
   - otherwise, decrement `right`
3. Return `nums[left]`.

## Complexity

- **Time:** O(log n) average, O(n) worst case
- **Space:** O(1)

## Why Duplicates Affect Runtime

When values are unique, comparing `nums[mid]` with `nums[right]` always discards about half the search space.

With duplicates, cases like `[1,1,1,1,0,1]` can produce `nums[mid] == nums[right]`. In that case, we can only shrink `right` by one while preserving correctness. If this happens many times, the algorithm degrades to O(n).

## Edge Cases

- All values are equal
- Array is not visibly rotated
- Minimum appears multiple times
- Single-element array
