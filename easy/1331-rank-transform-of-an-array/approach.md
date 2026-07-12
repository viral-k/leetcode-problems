# Approach

**Tags:** `Array`, `Hash Table`, `Sorting`

## Intuition

The rank of a value is simply its 1-based position among the **distinct** sorted values: the smallest distinct value is rank 1, the next distinct value rank 2, and so on. Equal elements naturally share a rank.

## Approach

1. Take the sorted set of distinct values in `arr`.
2. Map each distinct value to its index + 1 (its rank).
3. Replace every element of `arr` with its mapped rank.

## Complexity

- **Time:** O(n log n) — sorting the distinct values
- **Space:** O(n) — the value→rank map

## Edge Cases

- Empty array → empty output
- All equal → all rank 1
- Duplicates map to the same rank (Example 3)
- Negative values handled the same way (ordering is numeric)
