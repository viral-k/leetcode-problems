# Approach

**Tags:** `Array`, `Two Pointers`

## Intuition

Both arrays are already sorted, so the first equal pair we find while scanning from left to right is the minimum common value.

If the current value in `nums1` is smaller, it can never match the current or any earlier value in `nums2`, so move the `nums1` pointer forward. Do the symmetric move when the current value in `nums2` is smaller.

## Approach

1. Start two pointers at the beginning of both arrays.
2. Compare `nums1[i]` and `nums2[j]`.
3. If they are equal, return that value.
4. Move the pointer with the smaller value.
5. If either pointer reaches the end, no common value exists, so return `-1`.

## Complexity

- **Time:** O(n + m) — each pointer only moves forward
- **Space:** O(1)

## Edge Cases

- The first elements are equal -> return immediately
- No common values -> return `-1`
- Arrays contain duplicates -> duplicates are naturally skipped by pointer movement
- One array's values are all smaller than the other's
