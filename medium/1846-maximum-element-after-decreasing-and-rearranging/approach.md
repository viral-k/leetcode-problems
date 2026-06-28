# Approach

**Tags:** `Array`, `Greedy`, `Sorting`

## Intuition

We can only decrease values and reorder them, never increase. To make the maximum element as large as possible, we want the values to climb as steeply as the rules allow: start at 1 and go up by at most 1 each step. Sorting ascending lets every position contribute its full upward potential.

## Approach

1. Sort `arr` ascending.
2. Force the first element to `1` (`prev = 1`).
3. For each subsequent element, it can be at most `prev + 1` (adjacent difference ≤ 1) and can only be decreased, so set `prev = min(arr[i], prev + 1)`.
4. After the sweep, `prev` is the largest achievable element — return it.

Each value climbs by at most 1 above the previous, capped by its own (sorted) size. Because the array is sorted, no later element ever forces an earlier one down, so this greedy build is optimal.

## Complexity

- **Time:** O(n log n) — dominated by the sort
- **Space:** O(1) extra (in place, ignoring sort)

## Edge Cases

- Single element → must become 1 → answer 1
- Already valid `[1,2,3,4,5]` → answer is the length-bounded max (5)
- Large gaps `[100, 1, 1000]` → values get capped to `1, 2, 3`
- Many duplicates `[2,2,1,2,1]` → climbs slowly, answer 2
- The answer can never exceed `arr.length`
