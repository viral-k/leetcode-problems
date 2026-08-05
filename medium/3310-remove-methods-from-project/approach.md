# Approach

**Tags:** `Array`, `DFS`, `BFS`, `Graph`

## Intuition

The suspicious set is everything reachable from `k` along the invocation edges (directed graph). Those can be removed only if nothing *outside* the set calls into it — otherwise removing them would break a caller. If even one external caller points in, the rule forbids removal, so we keep everything.

## Approach

1. Build the directed adjacency list from `invocations`.
2. **Mark suspicious:** BFS/DFS from `k`, marking every reachable method.
3. **Safety check:** scan all edges `a -> b`; if some `a` is *not* suspicious but `b` *is*, an outside method invokes the group → removal impossible → return all methods `0..n-1`.
4. Otherwise return every method not marked suspicious.

## Complexity

- **Time:** O(n + m) — traversal plus one edge scan
- **Space:** O(n + m) — adjacency list and visited array

## Edge Cases

- External caller into the suspicious set (Example 1) → return everything
- Suspicious set fully self-contained (Examples 2, 3) → remove it
- All methods suspicious → return empty list
- No invocations → only `k` is suspicious, and no external caller exists → remove just `k`
- Cycles among suspicious methods → handled by the visited marking
