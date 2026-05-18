# Approach

**Tags:** `Array`, `Hash Table`, `BFS`

## Intuition

Treat every index as a node in an unweighted graph. From an index, we can move to the adjacent indices and to every other index with the same value.

Since every jump has the same cost, BFS gives the minimum number of steps.

The main issue is avoiding repeated scans of all indices with the same value. Once BFS expands the teleport edges for a value, those edges never need to be considered again because any later visit would be at the same or a larger distance.

## Approach

1. Build a map from each value to all indices containing that value.
2. Start BFS from index `0`.
3. For each popped index:
   - return the current step count if it is the last index
   - try `index - 1` and `index + 1`
   - try every index with the same value
4. After processing same-value jumps for `arr[index]`, clear that value's list from the map.
5. Mark indices as visited before enqueueing them.

## Complexity

- **Time:** O(n) — each index is enqueued once, and each same-value group is expanded once
- **Space:** O(n) — for the value map, queue, and visited array

## Edge Cases

- Single element array -> return `0`
- First and last elements are equal -> return `1`
- Many duplicate values -> handled efficiently by clearing each value group
- Negative values -> supported as normal hash map keys
