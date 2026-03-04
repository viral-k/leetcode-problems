# Approach

**Tags:** `Array`, `Hash Table`, `Segment Tree`

## Intuition

For each left boundary `l`, we need to find the rightmost `r` where `distinctOdd[l..r] == distinctEven[l..r]`. Define `diff[r] = distinctOdd - distinctEven` for subarray `[l..r]`. We need to find rightmost `r` where `diff[r] == 0`.

## Solution

1. **Transform to balance array**: For each position, track balance = (distinct odds) - (distinct evens). A subarray is balanced when balance = 0.

2. **Segment tree with lazy propagation**: 
   - Track min and max in ranges to quickly find if 0 exists
   - Use lazy propagation for efficient range updates

3. **Sliding window on left boundary**:
   - For each `l`, find rightmost `r` where balance = 0 using segment tree
   - When moving `l` to `l+1`, update the contribution of `nums[l]`

4. **First occurrence tracking**:
   - For each value, track positions in a deque
   - When a value's first occurrence moves, update the segment tree range

### Key Insight

When left boundary moves from `l` to `l+1`:
- If `nums[l]` was the first occurrence of that value in `[l, n-1]`
- Its contribution (+1 for odd, -1 for even) needs to be removed from range `[l, next_occurrence-1]`

## Complexity

- **Time:** O(n log n) — each position processed once, segment tree operations are O(log n)
- **Space:** O(n) — segment tree and position tracking

## Edge Cases

- All even or all odd → return 0
- Single element → return 0
- All same value → return 0
