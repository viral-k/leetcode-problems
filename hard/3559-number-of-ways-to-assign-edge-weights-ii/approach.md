# Approach

**Tags:** `Tree`, `Binary Lifting`, `Depth-First Search`, `Math`

## Intuition

As in the easy version, only parity matters: weight `2` keeps parity, weight `1` flips it, so a path's cost is odd exactly when an odd number of its edges get weight `1`. For a path with `d` edges there are `2^d` assignments and exactly half are odd, giving `2^(d-1)` (and `0` when `d = 0`, i.e. `u == v`).

So every query reduces to: how many edges lie on the path between `u` and `v`? In a tree that distance is

```
d = depth[u] + depth[v] - 2 * depth[lca(u, v)]
```

The only real work is answering many LCA queries quickly, which **binary lifting** handles in O(log n) each after O(n log n) preprocessing.

## Approach

1. Build an adjacency list and BFS from the root (node `1`) to record `depth[v]` and the immediate parent `up[0][v]`.
2. Fill the binary-lifting table: `up[k][v] = up[k-1][up[k-1][v]]` for each level `k`.
3. Precompute `pow2[i] = 2^i mod (10^9 + 7)` up to `n`.
4. For each query `[u, v]`:
   - find `lca(u, v)` via binary lifting,
   - compute `d = depth[u] + depth[v] - 2 * depth[lca]`,
   - append `pow2[d - 1]` if `d >= 1`, else `0`.

## Complexity

- **Time:** O((n + q) log n) — table build plus one LCA per query
- **Space:** O(n log n) — the binary-lifting ancestor table

## Edge Cases

- Query with `u == v` -> `d = 0`, answer is `0`
- Query where one node is an ancestor of the other -> LCA is that ancestor
- Deepest possible path (`d = n - 1`) -> still O(log n) per query, modular power handles the size
- Repeated/duplicate queries -> each answered independently in O(log n)
