# Approach

**Tags:** `Array`, `Binary Search`, `Sorting`

## Intuition

The obvious route is to sort and then scan for `target`, but sorting is more
than the question needs. After sorting, every copy of `target` sits in one
contiguous block, and where that block starts is decided by a single quantity:
how many elements are strictly smaller than `target`. Those are the only values
that can be placed before it. Elements larger than `target` land after the block
and cannot shift it.

So the answer is a range, and two counters produce it in one pass without ever
rearranging anything.

## Approach

1. Walk `nums` once, keeping `less` (count of `nums[i] < target`) and `count`
   (count of `nums[i] == target`).
2. In sorted order the `count` copies of `target` occupy positions
   `less` through `less + count - 1`.
3. Return that range as a list, which is already in increasing order.

Values greater than `target` are never counted — they contribute nothing to the
block's position.

## Complexity

- **Time:** O(n), against O(n log n) for the sort-then-scan version
- **Space:** O(1) beyond the returned list

## Edge Cases

- `target` absent → `count = 0`, so the range is empty and the required empty
  list falls out without a special case
- Every element equals `target` → `less = 0`, giving `[0 .. n-1]`
- `target` smaller than everything → `less = 0`, block starts at index 0
- `target` larger than everything present → `less = n`, but `count = 0`, so the
  range is still empty and the out-of-bounds start is never used
- Single element array, matching or not
- Duplicates of other values are handled by the same counting; only the
  comparison against `target` matters
