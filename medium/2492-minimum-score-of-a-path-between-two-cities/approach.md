# Approach

**Tags:** `BFS`, `DFS`, `Union Find`, `Graph`

## Intuition

The scoring rule plus the freedom to reuse roads and revisit cities changes the problem completely. A path's score is its **minimum** edge, and since you can wander anywhere in the connected component and backtrack, any road in city 1's component can be included in *some* path from 1 to `n` (walk to that road, cross it, return, then head to `n`). City `n` is guaranteed to be in the same component.

So the minimum achievable score is just the **smallest edge weight among all roads in city 1's connected component**.

## Approach

1. Build an adjacency list (store neighbor + distance).
2. BFS/DFS from city 1, visiting every reachable node.
3. Track the minimum distance of every edge encountered during the traversal.
4. Return that minimum.

(Union-Find gives the same result: union all roads, then take the min edge whose endpoints share city 1's root.)

## Complexity

- **Time:** O(n + m)
- **Space:** O(n + m) — adjacency list and visited set

## Edge Cases

- Direct edge `1 - n` still just contributes to the component min
- Roads in other disconnected components are irrelevant and never visited
- A road can be traversed multiple times, so revisiting doesn't change the min logic
- The component always contains both 1 and n (guaranteed by constraints)
