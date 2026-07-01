# Approach

**Tags:** `Array`, `BFS`, `Heap (Priority Queue)`, `Matrix`, `Binary Search`

## Intuition

Two independent pieces:

1. Every cell has a fixed "safeness" = its Manhattan distance to the nearest thief. A multi-source BFS starting from **all** thieves at once fills this in — on an open 4-neighbor grid, BFS layers coincide exactly with Manhattan distance.
2. A path's safeness factor is the **minimum** cell-safeness along it. We want the path from `(0,0)` to `(n-1,n-1)` that **maximizes that minimum** — a classic max-min (bottleneck) path problem.

## Approach

**Phase 1 — distance grid (BFS):**
- Push all thief cells (distance 0) into a queue.
- Standard BFS outward; each cell records its distance to the nearest thief.

**Phase 2 — max-min path (Dijkstra with a max-heap):**
- `best[r][c]` = the largest bottleneck value with which we can reach `(r, c)`. Start at `(0,0)` with `best = dist[0][0]`.
- Pop the cell with the greatest bottleneck. For each neighbor, the bottleneck of extending the path is `min(current_bottleneck, dist[neighbor])`; if that improves `best[neighbor]`, push it.
- When `(n-1, n-1)` is popped, its bottleneck is the answer.

(An equivalent solution binary-searches the safeness threshold and runs a plain BFS/DFS over cells with `dist >= mid`; the heap approach avoids the extra log factor of repeated searches conceptually but has the same asymptotics.)

## Complexity

- **Time:** O(n² log n) — BFS is O(n²); the heap phase processes O(n²) cells with heap ops
- **Space:** O(n²) — distance grid, best grid, queue/heap

## Edge Cases

- `n = 1` → single cell; answer is its own distance (0 if it's a thief)
- Start or end is a thief → distance 0 there → answer 0 (Example 1)
- Whole grid reachable → answer is the max achievable bottleneck
- At least one thief always exists (per constraints), so BFS always has a source
