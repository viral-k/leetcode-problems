# Approach

**Tags:** `Tree`, `BFS`, `DFS`, `Math`

## Intuition

Only the parity of the path cost matters. A weight of `2` is even and never changes parity; a weight of `1` is odd and flips it. So a path's total cost is odd exactly when an **odd number** of its edges are assigned weight `1`.

For a path with `d` edges, each edge is independently `1` or `2`, giving `2^d` assignments. Exactly half of them have an odd number of `1`s, so the count of odd-cost assignments is `2^(d-1)`.

The node `x` is at maximum depth, so `d` is simply the maximum depth of the tree (the number of edges on the longest root-to-node path). The specific node chosen does not matter — only `d` does.

## Approach

1. Build an adjacency list from `edges`.
2. BFS from node `1` to find the maximum depth `d` (edges from the root to the deepest node).
3. Return `2^(d-1) mod (10^9 + 7)` using fast modular exponentiation.

## Complexity

- **Time:** O(n) — one BFS over the tree
- **Space:** O(n) — adjacency list and BFS queue

## Edge Cases

- A single edge (`n == 2`) -> `d = 1`, answer is `2^0 = 1`
- A path-shaped tree -> `d = n - 1`, the largest possible depth
- Large `d` -> use modular exponentiation to stay within the modulus
