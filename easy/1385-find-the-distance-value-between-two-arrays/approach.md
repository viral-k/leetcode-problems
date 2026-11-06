# Approach

**Tags:** `Array`, `Two Pointers`, `Binary Search`, `Sorting`

## Intuition

`arr1[i]` counts when no `arr2` value lies within `d` of it, which means the range `[x - d, x + d]` holds no `arr2` value. Once `arr2` is sorted, one binary search answers that: find the smallest value `>= x - d` and check whether it is still `<= x + d`.

## Approach

1. Sort `arr2`.
2. For each `x` in `arr1`, find the first index `i` with `arr2[i] >= x - d`.
3. Count `x` if `i` is past the end or `arr2[i] > x + d`.

## Complexity

- **Time:** O((n + m) log m), where `n = len(arr1)` and `m = len(arr2)`
- **Space:** O(1) beyond the sort (Python's sort uses O(m))

## Edge Cases

- `d = 0`: `x` fails only on an exact match
- Every `arr2` value is below `x - d`: the search runs off the end, and `x` counts
- Every `arr2` value is above `x + d`: the search lands on index 0, the check fails, and `x` counts
- Duplicates in `arr1` are counted separately, and duplicates in `arr2` change nothing
- A value exactly `d` away is within range, because the condition is `<= d`
