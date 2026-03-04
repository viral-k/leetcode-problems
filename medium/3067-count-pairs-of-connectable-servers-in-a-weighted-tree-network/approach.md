# Approach

**Tags:** `Array`, `Tree`, `DFS`

## Intuition

For each server `c`, count valid servers in each branch (subtree), then count pairs across different branches. Two servers are connectable if they're in different branches and both have distances divisible by `signalSpeed`.

## Solution

1. **Build adjacency list**: Create graph from edges with weights.

2. **For each potential middle server `c`**:
   - For each neighbor (branch), DFS to count servers with distance divisible by `signalSpeed`
   - Store count for each branch

3. **Count pairs across branches**: 
   - Use prefix sum approach: for each branch count, multiply by sum of all previous branch counts
   - This counts all pairs `(a, b)` where `a` and `b` are in different branches

4. **DFS helper**: 
   - Traverse subtree rooted at node (excluding parent)
   - Count nodes where `distance % signalSpeed == 0`

### Why Prefix Sum for Pairs?

If branches have counts `[c1, c2, c3]`:
- Pairs = c1*c2 + c1*c3 + c2*c3
- Using prefix: (0)*c1 + (c1)*c2 + (c1+c2)*c3

## Complexity

- **Time:** O(n²) — for each node, DFS entire tree
- **Space:** O(n) — adjacency list and recursion stack

## Edge Cases

- Linear tree (path graph) → left count × right count
- Star graph → all pairs through center
- signalSpeed = 1 → all distances valid
- No valid pairs → all zeros
