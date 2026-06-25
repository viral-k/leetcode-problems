# Approach

**Tags:** `Array`, `Counting`

## Intuition

A subarray is valid if `target` appears strictly more than half the time. With n ≤ 1000, checking all O(n²) subarrays is fast enough.

## Approach

For each left boundary `i`, scan right and maintain a running count of how many times `target` appears. At each right boundary `j`:

- `length = j - i + 1`
- valid iff `count * 2 > length`

Incrementally extending the right boundary keeps each inner step O(1), so the total is O(n²).

## Complexity

- **Time:** O(n²)
- **Space:** O(1)

## Edge Cases

- `target` not in `nums` → count stays 0 for all subarrays → return 0
- All elements equal `target` → every subarray qualifies → n*(n+1)/2
- Single-element subarray `[target]` → count=1, length=1, 2>1 ✓
