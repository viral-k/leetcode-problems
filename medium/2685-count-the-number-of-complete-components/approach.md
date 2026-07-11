# Approach

**Tags:** `DFS`, `BFS`, `Union Find`, `Graph`

## Intuition

A connected component with `k` vertices is *complete* precisely when it contains every possible edge, i.e. exactly `k * (k - 1) / 2` of them. So for each component we just need its vertex count and edge count and compare.

## Approach

1. Group vertices into components with union-find (or DFS/BFS).
2. For each component, tally:
   - `V` = number of vertices,
   - `E` = number of edges whose endpoints are in the component (each undirected edge counted once).
3. The component is complete iff `E == V * (V - 1) / 2`. Count such components.

With union-find: after unioning all edges, count vertices per root and edges per root (an edge belongs to the root of its endpoints), then check the formula per root.

## Complexity

- **Time:** O(n + m · α(n)) — near-linear with union-find
- **Space:** O(n)

## Edge Cases

- Single isolated vertex → `V=1, E=0`, and `1*0/2 = 0` → complete (counts)
- Component with a missing edge → not complete (Example 2)
- No edges at all → every vertex is its own complete component → answer `n`
- Self-loops don't occur (`a_i != b_i`), and no duplicate edges, so `E` is exact
