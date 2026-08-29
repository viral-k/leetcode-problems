# Approach

**Tags:** `Array`, `Union Find`, `Sorting`, `Greedy`

## Intuition

Swappability is **transitive** even though the stated condition isn't. If `a` can swap with `b` and `b` with `c`, then `a` and `c` can be exchanged too — route the values through `b`. So the real structure is the connected components of the "differs by at most `limit`" graph, and within a component **any** permutation of its values is reachable (transpositions along a spanning tree generate the full symmetric group).

Sorting the values exposes those components cheaply: after sorting, a component is exactly a **contiguous run**. If two consecutive sorted values differ by more than `limit`, nothing can bridge that gap — any pair straddling it differs by at least as much. Conversely, inside a run every neighbouring pair is directly swappable, so the whole run is connected.

Once components are known, the greedy is forced: a component owns a fixed set of positions and a fixed multiset of values, so to be lexicographically smallest, put the smallest value at the smallest position, and so on.

## Approach

1. Pair each value with its original index and sort by value.
2. Walk the sorted list, starting a new group whenever `value[i] - value[i-1] > limit`.
3. For each group:
   - Collect its original indices and sort them ascending.
   - Its values are already ascending from step 1.
   - Write the `k`th smallest value to the `k`th smallest index.
4. Return the filled array.

## Complexity

- **Time:** O(n log n) — dominated by the sort (the per-group index sorts total O(n log n) as well)
- **Space:** O(n) — the sorted pairs and the output

## Edge Cases

- No swaps possible (every consecutive gap exceeds `limit`) → the array is returned unchanged (Example 3)
- Entire array in one group → the answer is simply `nums` fully sorted (Example 1)
- Duplicate values → gap `0 <= limit`, so they always join the same group
- A group's positions are scattered, not contiguous — the indices must be sorted separately from the values (Example 2 places `1` at index 4 and `2` at index 5)
- Values up to 10^9 with `limit` up to 10^9; differences fit comfortably in `int`
