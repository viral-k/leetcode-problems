# Approach

**Tags:** `Array`, `String`, `Divide and Conquer`, `Bit Manipulation`, `Tree`, `Depth-First Search`, `Binary Indexed Tree`, `Segment Tree`

## Intuition

A multiset of letters can be rearranged into a palindrome exactly when at most
one letter appears an odd number of times. Only parity matters, so a path can
be summarised by a 26-bit mask where bit `c` is the parity of letter `c`, and
the path is good when the mask has at most one bit set.

Parity masks combine with XOR. Root the tree at 0 and let `P[x]` be the XOR of
the letter bits of every node from the root down to `x`, inclusive. For a path
`u .. v` with lowest common ancestor `l`, `P[u] ^ P[v]` cancels everything from
the root down to `l`, including `l` itself. Adding `l` back gives

`mask(u, v) = P[u] ^ P[v] ^ bit(s[l])`

Updates are the hard part. Changing the letter at `x` from `a` to `b` XORs
`bit(a) ^ bit(b)` into `P[y]` for every `y` in the subtree of `x`, and nothing
else. In Euler-tour order a subtree is one contiguous range, so each update
is a range XOR and each `P[y]` lookup is a point query. A Fenwick tree over a
difference array handles both in O(log n): XOR the delta in at the range start
and again just past the range end, and a point value is the prefix XOR.

## Approach

1. Build the adjacency list and run an iterative DFS from node 0, recording
   preorder positions `tin`, parents, depths and the initial root-to-node masks
   `base`. Subtree sizes (computed in reverse preorder) give
   `tout = tin + size - 1`.
2. Build binary-lifting tables for LCA.
3. Keep a Fenwick tree of XOR deltas, all zero at the start. The current mask
   of `x` is `base[x] ^ prefixXor(tin[x])`.
4. `update x c`: `d = bit(old) ^ bit(c)`. If `d != 0`, XOR `d` at `tin[x]` and
   at `tout[x] + 1`, and store the new letter.
5. `query u v`: find `l = lca(u, v)`, compute
   `mask = P[u] ^ P[v] ^ bit(s[l])`, and answer `mask & (mask - 1) == 0`.

## Complexity

- **Time:** O((n + q) log n) for the DFS, lifting tables, and log-time Fenwick
  and LCA work per query
- **Space:** O(n log n) for the lifting table

## Edge Cases

- `u == v` → the path is one node, its mask has one bit, always `true`
- `n = 1` → every query is `u == v`
- An update that sets a node to its current letter has delta 0 and changes
  nothing
- A path graph of 5 * 10^4 nodes is 5 * 10^4 deep, so the DFS must be iterative
- An update on the root changes every `P`, which is the range `[0, n - 1]`; the
  end marker at `n` falls outside the tree and is skipped
- The LCA's letter is added back after the XOR; leaving it out gives the wrong
  answer whenever `l` is on the path, which is always
