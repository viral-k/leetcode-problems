# Approach

**Tags:** `Array`, `BFS`, `Graph`, `Matrix`, `Shortest Path`

## Intuition

Health only drops when you step onto an unsafe (`1`) cell, and each such cell costs exactly 1. So the health you have left at the end is `health` minus the number of `1`-cells on your path. To maximize surviving health, minimize the number of unsafe cells passed through — a shortest-path problem where entering a cell costs its grid value (0 or 1).

Because every edge weight is 0 or 1, **0-1 BFS** with a deque solves it in linear time (no heap needed).

## Approach

1. `dist[r][c]` = minimum unsafe cells on any path reaching `(r, c)` (including that cell's own value). Init `dist[0][0] = grid[0][0]`.
2. 0-1 BFS from `(0, 0)` using a deque:
   - Pop the front cell. For each neighbor, the cost to enter it is `grid[neighbor]`.
   - If `dist[cur] + grid[neighbor] < dist[neighbor]`, relax it and push **front** if the added cost is 0, **back** if it's 1 (keeps the deque monotonically ordered by distance).
3. Answer: `health - dist[m-1][n-1] >= 1`.

## Complexity

- **Time:** O(m · n) — each cell relaxed O(1) times, deque keeps ordering without a heap
- **Space:** O(m · n) — distance grid and deque

## Edge Cases

- Start cell is unsafe → its cost counts immediately
- `health = 1` → only survivable if a fully-safe path exists (dist = 0)
- Both corners must be counted; the answer uses strict `>= 1` (must finish with positive health)
- Single row/column grid → BFS still handles it
