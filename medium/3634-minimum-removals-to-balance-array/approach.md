# Approach

**Tags:** `Array`, `Sorting`, `Two Pointers`, `Sliding Window`

## Intuition

After sorting, we need the longest contiguous subarray where `max <= min * k`. Since array is sorted, max is the rightmost element and min is the leftmost. Use two pointers to find the longest valid window.

## Solution

1. **Sort the array**: After sorting, any contiguous subarray has min at left and max at right.

2. **Two pointer / sliding window**: 
   - Expand right pointer to include more elements
   - If `nums[r] > nums[l] * k`, shrink from left until valid

3. **Track maximum length**: The longest valid window gives the maximum elements we can keep.

4. **Return removals**: `n - maxLen` = minimum elements to remove.

### Why Contiguous After Sort?

After sorting, keeping a contiguous subarray is optimal because:
- Removing middle elements doesn't help (doesn't change min/max of remaining)
- We want elements as close in value as possible
- Contiguous subarray in sorted order minimizes the max/min ratio

## Complexity

- **Time:** O(n log n) — sorting dominates, two-pointer scan is O(n)
- **Space:** O(1) — ignoring sort space, only constant extra variables

## Edge Cases

- Single element → return 0 (always balanced)
- All elements equal → return 0
- All elements already satisfy condition → return 0
- Large values → use `long` in Java to prevent overflow on `nums[l] * k`
