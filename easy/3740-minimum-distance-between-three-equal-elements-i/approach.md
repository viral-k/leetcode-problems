# Approach

**Tags:** `Array`, `Hash Table`

## Intuition

For indices i < j < k, the distance simplifies to:
```
|i-j| + |j-k| + |k-i| = (j-i) + (k-j) + (k-i) = 2*(k-i)
```

So we just need to minimize `k - i` for any 3 equal elements.

## Solution

1. Group indices by their value using a hash map
2. For each value with at least 3 occurrences:
   - Indices are naturally sorted (we process left to right)
   - Check every 3 consecutive indices: span = indices[i+2] - indices[i]
3. Return minimum span × 2, or -1 if no valid tuple exists

### Why Consecutive?

For sorted indices, the minimum span covering 3 elements is always achieved by 3 consecutive ones. Skipping an index only increases the span.

## Complexity

- **Time:** O(n) — single pass to group, then process each group
- **Space:** O(n) — hash map storage

## Edge Cases

- Array length < 3 → return -1
- No value appears 3+ times → return -1
- All elements equal → use first 3 indices
