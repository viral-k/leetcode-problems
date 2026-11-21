# Approach

**Tags:** `Array`, `Hash Table`, `String`, `Tree`, `Depth-First Search`

## Intuition

Every move uses the **original** tree, since all changes happen at once. The new parent of `x` is the nearest ancestor with the same letter. A DFS can track that directly. Keep `last[c]`, the deepest node on the current root-to-node path with letter `c`. When the DFS enters `x`, `last[s[x]]` is exactly the closest matching ancestor.

A new parent is always an ancestor in the original tree. So every node of the new tree comes after its new parent in the original DFS preorder. Walking that preorder backwards therefore visits children before parents, and subtree sizes can be summed with no second traversal.

## Approach

1. Build children lists from `parent`.
2. Iterative DFS from root `0`, keeping `last[26]` (initially `-1`):
   - **Enter `x`:** append `x` to `order`. Set `newParent[x] = last[s[x]]` if that is not `-1`, else keep `parent[x]`. Save the old `last[s[x]]` and set it to `x`.
   - **Exit `x`:** restore `last[s[x]]` to the saved value.
3. Start every size at `1`. For `x` in reversed `order` (skipping the root), add `size[x]` into `size[newParent[x]]`.

The DFS is iterative because the tree can be a chain of `10^5` nodes, which would hit Python's recursion limit.

## Complexity

- **Time:** O(n) (the alphabet is a fixed 26)
- **Space:** O(n)

## Edge Cases

- `n = 1`: answer `[1]`
- No repeated letters on any path: the tree is unchanged
- Every node has the same letter: every node keeps its parent, because its own parent is already the nearest match
- Deep chain (`10^5` nodes): handled by the iterative DFS
- Moves are simultaneous (example 2): node 2 skips node 4 and goes to node 1 based on the original paths, even though node 4 itself moves too
