# Approach

**Tags:** `Array`, `Dynamic Programming`, `DFS`, `Memoization`

## Intuition

Think of each index as a node. From an index, we can move only to lower values, and a jump direction is blocked as soon as we meet an equal or higher value.

Because every jump strictly decreases the array value, there is no cycle. That makes the problem a longest path problem on a directed acyclic graph, which can be solved with DFS and memoization.

## Approach

1. Define `dfs(i)` as the maximum number of indices that can be visited when starting from index `i`.
2. Initialize the answer for `i` as `1`, counting index `i` itself.
3. Scan to the right for at most `d` positions:
   - stop if the next value is greater than or equal to `arr[i]`
   - otherwise update the best answer with `1 + dfs(next_index)`
4. Do the same scan to the left.
5. Memoize each `dfs(i)` result so every index is solved once.
6. Return the maximum `dfs(i)` over all starting indices.

## Complexity

- **Time:** O(n * d) — each index scans at most `d` positions in both directions once
- **Space:** O(n) — for memoization and recursion stack

## Edge Cases

- All values equal -> no valid jump, answer is `1`
- Strictly decreasing with `d = 1` -> can visit all indices from the first index
- Single element -> answer is `1`
- A taller or equal value inside the jump range blocks all farther indices in that direction
