# Approach

**Tags:** `Array`, `DFS`, `BFS`, `Union Find`, `Matrix`

## Intuition

Standard cycle detection in an undirected graph. A cycle exists if during DFS we reach a visited cell that is not our immediate parent.

## Solution

### DFS Approach

```python
def dfs(i, j, pi, pj, char):
    visited[i][j] = True
    
    for ni, nj in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
        if 0 <= ni < m and 0 <= nj < n and grid[ni][nj] == char:
            if not visited[ni][nj]:
                if dfs(ni, nj, i, j, char):
                    return True
            elif (ni, nj) != (pi, pj):
                # Visited cell that's not parent = cycle!
                return True
    
    return False
```

### Why Track Parent?

In an undirected graph, when we go from A → B, we can immediately go back B → A. This isn't a cycle. We need to detect when we reach a visited node via a **different** path.

### Union-Find Alternative

For each cell, check if adjacent cells with same value are already in the same connected component. If yes → cycle exists.

## Complexity

- **Time:** O(m × n)
- **Space:** O(m × n) for visited array and recursion stack

## Edge Cases

- Single row or column (no cycle possible with length ≥ 4)
- All same characters forming a large cycle
- No cycles exist
