# Approach

**Tags:** `Array`, `BFS`, `DFS`

## Intuition

Treat each index as a node in a graph. From index `i`, there are at most two outgoing edges:

- `i + arr[i]`
- `i - arr[i]`

The question is whether any reachable node has value `0`.

Because cycles are possible, we need a `visited` array.

## Approach

1. Start BFS from `start`.
2. Mark `start` as visited.
3. While the queue is not empty:
   - pop an index
   - if `arr[index] == 0`, return `true`
   - try both next indices
   - enqueue valid, unvisited indices
4. If BFS finishes without finding `0`, return `false`.

## Complexity

- **Time:** O(n) — each index is visited at most once
- **Space:** O(n) — for the queue and visited array

## Edge Cases

- `arr[start] == 0` -> return `true`
- Jump value is `0` at a non-start index
- Cycles between indices -> handled by `visited`
- Jumps outside bounds -> ignored
