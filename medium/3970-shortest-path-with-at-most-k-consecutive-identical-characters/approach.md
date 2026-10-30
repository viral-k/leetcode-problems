# Approach

**Tags:** `Graph`, `String`, `Heap (Priority Queue)`, `Shortest Path`

## Intuition

The labels along a path only matter through the length of the current run of identical characters. Moving along `u -> v` either extends the run (same label) or resets it to 1 (different label). So expand each node into states `(node, run)` with `1 <= run <= k`, and run Dijkstra on that layered graph. That's at most `n * k` states, about 2.5 * 10^6.

A state with a shorter run is never worse than one with a longer run at the same node: every continuation that keeps the longer run within `k` also keeps the shorter one within `k`. Dijkstra pops states in order of distance, so once node `u` is settled with run `r`, any later pop of `u` with run `>= r` has both a larger distance and a worse run, and can be skipped.

## Approach

1. Build the adjacency list. For each edge, store whether both endpoints share a label.
2. Keep `dist` over states `node * (k + 1) + run`, and `best[u]` = smallest run settled at `u` so far (starts at `k + 1`, meaning none).
3. Start from `(0, 1)` with distance 0.
4. Pop `(d, u, r)`:
   - skip if stale (`d > dist`) or dominated (`r >= best[u]`);
   - otherwise set `best[u] = r`; if `u == n - 1`, return `d`, since the first pop of the target is the cheapest;
   - for each edge `u -> v` with weight `w`, the new run is `r + 1` if the labels match, else `1`. Skip if it exceeds `k` or is `>= best[v]`; relax as usual.
5. If the heap empties, return `-1`.

Each node is settled at most `k` times, with strictly decreasing runs, and in practice usually once or twice.

## Complexity

- **Time:** O(k * (n + m) log(n * k)) in the worst case, where `m` = number of edges
- **Space:** O(n * k + m)

## Edge Cases

- `n == 1`: the path is just node 0, one character, so the answer is 0
- No edges, or `n - 1` unreachable: `-1`
- Every route to `n - 1` passes through too many same-label nodes in a row: `-1` (example 3)
- Detours that break a run: a longer path through a node with a different label can be the only valid one, which is why the run is part of the state
- Reaching a node again with a shorter run after a longer, cheaper visit: both are kept, since the shorter run may be the one that can continue
- Path weights can exceed 32 bits in principle (a state path can be up to `n * k` edges long), so Java uses `long` distances
