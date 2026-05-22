# Approach

**Tags:** `Array`, `Binary Search`

## Intuition

Even after rotation, at least one half of the current search interval is sorted.

At each step, compare `nums[left]`, `nums[mid]`, and `nums[right]` to determine which half is sorted. If the target falls inside the sorted half, continue searching there. Otherwise, discard that half and search the other side.

## Approach

1. Set `left = 0` and `right = len(nums) - 1`.
2. While `left <= right`:
   - compute `mid`
   - if `nums[mid] == target`, return `mid`
   - if the left half is sorted:
     - search left if `target` is between `nums[left]` and `nums[mid]`
     - otherwise search right
   - otherwise the right half is sorted:
     - search right if `target` is between `nums[mid]` and `nums[right]`
     - otherwise search left
3. Return `-1` if the target is not found.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)

## Edge Cases

- Single-element array
- Array is not rotated
- Target is at the pivot
- Target is absent
- Target is at either boundary
