# Approach

**Tags:** `Array`, `Heap (Priority Queue)`, `Sparse Table`

## Intuition

We want the `k` distinct subarrays with the largest values, then sum those values. The crucial structural fact: shrinking a subarray can never increase its value. Removing an element from either end can only lower the `max` or raise the `min`, so

```
value([l, r]) >= value([l+1, r])  and  value([l, r]) >= value([l, r-1])
```

Therefore the whole array `[0, n-1]` has the maximum value of all subarrays, and every subarray is reachable from it by repeatedly trimming one end, with value non-increasing along the way. This is exactly the setting where a best-first (Dijkstra-like) heap extraction yields elements in non-increasing value order.

## Approach

1. Build **sparse tables** for range maximum and range minimum so any subarray value `max(l..r) - min(l..r)` can be queried in O(1).
2. Push the full array `[0, n-1]` into a max-heap keyed by value; mark it visited.
3. Repeat `k` times:
   - Pop the interval with the largest value and add that value to the answer.
   - Generate its two "children" by trimming one end: `[l+1, r]` and `[l, r-1]`.
   - For each valid, not-yet-visited child, compute its value and push it, marking it visited (a child has two possible parents, so the visited set prevents pushing duplicates).
4. After `k` pops, the accumulated sum is the maximum total value.

Because every interval's value dominates its children and the root is the unique maximum, the heap pops the global top-`k` values in order.

## Complexity

- **Time:** O(n log n + k log k) — sparse table build plus `k` heap operations, each with O(1) value queries
- **Space:** O(n log n + k) — sparse tables and the heap/visited frontier

## Edge Cases

- All elements equal -> every value is `0`, answer is `0`
- `n == 1` -> only one subarray (value `0`), and `k` is forced to `1`
- Large values and large `k` -> totals can reach ~`10^14`, so use 64-bit integers in Java
- A child interval reachable from two parents -> visited set ensures it is counted once
