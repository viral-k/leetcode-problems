# Approach

**Tags:** `Array`, `BFS`, `DFS`, `Matrix`, `Union Find`

## Intuition

BFS/DFS with connection validation. When moving between cells, both cells must have compatible street types that connect to each other.

## Solution

### Street Connections

Define which directions each street type connects:

```
Street 1: left, right      (←→)
Street 2: up, down         (↑↓)
Street 3: left, down       (←↓)
Street 4: right, down      (→↓)
Street 5: left, up         (←↑)
Street 6: right, up        (→↑)
```

### Movement Validation

When moving from cell A to cell B in direction D:
1. A must have exit in direction D
2. B must have entrance from opposite direction

```python
# directions: 0=up, 1=right, 2=down, 3=left
connections = {
    1: {1, 3},      # left, right
    2: {0, 2},      # up, down
    3: {2, 3},      # down, left
    4: {1, 2},      # right, down
    5: {0, 3},      # up, left
    6: {0, 1},      # up, right
}
opposite = {0: 2, 1: 3, 2: 0, 3: 1}

# Can move from (i,j) in direction d?
if d in connections[grid[i][j]]:
    ni, nj = i + di[d], j + dj[d]
    if opposite[d] in connections[grid[ni][nj]]:
        # Valid move!
```

## Complexity

- **Time:** O(m × n)
- **Space:** O(m × n)

## Edge Cases

- Single cell grid → always true
- Start cell doesn't connect anywhere
- Dead ends before reaching destination
