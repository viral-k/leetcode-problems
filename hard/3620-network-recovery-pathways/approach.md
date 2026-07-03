# Approach

**Tags:** `Graph`, `Binary Search`, `Dynamic Programming`, `Topological Sort`, `Shortest Path`

## Intuition

The score of a path is its **minimum** edge cost, and we want the largest such minimum subject to a total-cost budget `k`. "Maximize the minimum" with a monotonic feasibility check screams **binary search on the answer**.

Fix a threshold `x`. A path can achieve score `>= x` only if every edge on it has `cost >= x`. So restrict to edges with `cost >= x`; a valid path with score `>= x` exists iff, within that subgraph, the **cheapest** total-cost path from `0` to `n-1` is `<= k`. As `x` grows the subgraph shrinks, so feasibility is monotonically non-increasing — binary-searchable.

## Approach

1. Collect the distinct edge costs and sort them; these are the only candidate answers (the score always equals some edge's cost).
2. Precompute a topological order of the DAG once (Kahn's algorithm).
3. **Feasibility `feasible(x)`:** min-total-cost DP over the topo order.
   - `dist[0] = 0`, everything else `INF`.
   - Relax each edge `u -> v` only if `cost >= x` **and both endpoints are online** (an offline node can never lie on a valid path): `dist[v] = min(dist[v], dist[u] + cost)`.
   - Feasible iff `dist[n-1] <= k`.
4. Binary-search the largest candidate cost `x` with `feasible(x)`; if even the smallest threshold (all edges) is infeasible, return `-1`.

## Complexity

- **Time:** O((n + m) log m) — `log m` feasibility checks, each an O(n + m) topo DP
- **Space:** O(n + m) — adjacency/topo structures and the `dist` array

## Edge Cases

- No path within budget → `-1`
- Offline intermediate nodes prune edges (endpoints 0 and n-1 always online)
- `k` up to 5·10^13 and path sums up to ~n·10^9 → use 64-bit (`long`); `dist` sentinel must exceed any real sum
- Zero-cost edges → threshold `0` is a valid candidate (a path of all-0 edges scores 0)
- `m = 0` → no path unless trivial → `-1`
