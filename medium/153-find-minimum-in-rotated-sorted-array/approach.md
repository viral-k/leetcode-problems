# Approach

**Tags:** `Array`, `Binary Search`

## Intuition

The array consists of two sorted parts after rotation. The minimum is the first element of the right sorted part.

Compare `nums[mid]` with `nums[right]`:

- If `nums[mid] > nums[right]`, the minimum must be to the right of `mid`.
- Otherwise, `nums[mid]` could be the minimum, or the minimum is to its left.

This works because all values are unique.

## Approach

1. Set `left = 0` and `right = len(nums) - 1`.
2. While `left < right`:
   - compute `mid`
   - if `nums[mid] > nums[right]`, set `left = mid + 1`
   - otherwise, set `right = mid`
3. Return `nums[left]`.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)

## Edge Cases

- Array is not visibly rotated -> first element is the minimum
- Single-element array
- Rotation places minimum at the last index
