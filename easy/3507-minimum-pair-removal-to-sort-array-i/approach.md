# Approach

**Tags:** `Array`, `Simulation`, `Greedy`

## Intuition

Simulate the process: repeatedly find the adjacent pair with minimum sum, merge them, and count operations until the array is non-decreasing.

## Solution

1. **Check if sorted**: If array is already non-decreasing, return 0.

2. **Find minimum sum pair**: Scan all adjacent pairs, find the one with minimum sum (leftmost if tie).

3. **Merge pair**: Replace the two elements with their sum, reducing array size by 1.

4. **Repeat**: Continue until array is non-decreasing.

5. **Count operations**: Return the number of merge operations performed.

## Complexity

- **Time:** O(n³) — each operation is O(n) to find min pair + O(n) to check sorted, up to O(n) operations
- **Space:** O(1) — in-place modifications (or O(n) if using list copy)

## Edge Cases

- Already sorted → return 0
- Single element → return 0 (trivially sorted)
- All elements equal → return 0
- Descending array → may need multiple merges
