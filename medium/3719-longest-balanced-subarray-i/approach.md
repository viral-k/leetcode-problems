# Approach

**Tags:** `Array`, `Hash Table`, `Brute Force`

## Intuition

For each starting index, expand the subarray while tracking distinct even and odd numbers. When counts are equal, we have a balanced subarray.

## Solution

1. **Enumerate all subarrays**: For each starting index `i`, expand `j` from `i` to `n-1`.

2. **Track distinct evens and odds**: Use two sets to track distinct even and odd numbers in current subarray.

3. **Check balance condition**: When `len(even) == len(odd)`, update max length.

4. **Return maximum**: The longest balanced subarray found.

### Why Brute Force Works

- Constraint is small: `n <= 1500`
- O(n²) with O(n) set operations per subarray is acceptable
- Total: O(n²) iterations, each with O(1) amortized set operations

## Complexity

- **Time:** O(n²) — enumerate all subarrays
- **Space:** O(n) — sets can hold up to n distinct elements

## Edge Cases

- All even or all odd → return 0 (no balanced subarray possible)
- Single element → return 0
- Alternating even/odd → likely the entire array is balanced
