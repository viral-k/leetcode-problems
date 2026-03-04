# Approach

**Tags:** `Array`, `Hash Table`, `Bucket Sort`

## Intuition

Use bucket sort where index = frequency. Since max frequency is n, we create n+1 buckets. Elements with same frequency go in same bucket. Iterate buckets from high to low frequency to get top k.

## Solution

1. **Count frequencies**: Use hash map to count occurrences of each number.

2. **Create frequency buckets**: Array of lists where `buckets[f]` contains all numbers with frequency `f`. Max frequency is `n`, so we need `n+1` buckets.

3. **Collect top k**: Iterate from highest frequency bucket down, collect elements until we have `k` elements.

### Why Bucket Sort?

- Heap approach: O(n log k) — good but not optimal
- Sorting: O(n log n) — doesn't meet follow-up requirement
- Bucket sort: O(n) — optimal, meets follow-up

## Complexity

- **Time:** O(n) — one pass to count, one pass to bucket, one pass to collect
- **Space:** O(n) — frequency map and buckets

## Edge Cases

- Single element → return that element
- All elements same frequency → any k of them is valid
- k equals number of unique elements → return all unique elements
