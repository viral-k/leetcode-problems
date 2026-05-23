# Approach

**Tags:** `Array`

## Intuition

In a non-decreasing sorted array, every adjacent pair satisfies `nums[i] <= nums[i + 1]`.

After rotation, there can be one drop where the end of the larger suffix wraps to the start of the smaller prefix. If we also compare the last element with the first element, a valid sorted-and-rotated array has at most one drop.

## Approach

1. Initialize `drops = 0`.
2. For every index `i`, compare `nums[i]` with `nums[(i + 1) % n]`.
3. If `nums[i] > nums[(i + 1) % n]`, increment `drops`.
4. Return `true` if `drops <= 1`, otherwise return `false`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Already sorted array -> zero or one circular drop, so return `true`
- Single-element array -> return `true`
- Duplicates -> allowed because the sorted order is non-decreasing
- More than one drop -> cannot be a rotation of a sorted array
