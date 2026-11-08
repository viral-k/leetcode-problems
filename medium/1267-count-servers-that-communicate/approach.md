# Approach

**Tags:** `Array`, `Depth-First Search`, `Breadth-First Search`, `Matrix`, `Counting`

## Intuition

A server communicates if at least one other server shares its row or its column. The question is not about chains of servers, so no graph search is needed. All that matters per server is whether its row or its column holds two or more servers, and two arrays of counts answer that.

## Approach

1. Count the servers in each row (`rows[i]`) and each column (`cols[j]`).
2. Walk the grid again and count every server with `rows[i] > 1` or `cols[j] > 1`.

## Complexity

- **Time:** O(m * n), two passes over the grid
- **Space:** O(m + n) for the counts

## Edge Cases

- Servers only on a diagonal: each is alone in its row and column, so the answer is 0 (example 1)
- A server that shares both a row and a column is still counted once
- An L shape: the corner server links the other two, and all three count (example 2)
- One row or one column: either every server counts (two or more servers) or none does
- An empty grid of zeros: 0
