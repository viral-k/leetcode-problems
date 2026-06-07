# Approach

**Tags:** `Array`, `Hash Table`, `Tree`, `Binary Tree`

## Intuition

Each description tells us a parent-child link. If we can quickly look up (or create) a node by its value, building the tree is just wiring those links together. The only real question is finding the root: it is the one value that is a parent but never a child.

## Approach

1. Keep a hash map from value -> `TreeNode`, creating a node lazily the first time a value is seen.
2. Track the set of values that appear as a child.
3. For each `[parent, child, isLeft]`:
   - get/create the parent and child nodes
   - attach the child as the left or right child based on `isLeft`
   - mark `child` as a seen child
4. The root is the single value present as a parent (a key in the map) that is never marked as a child.
5. Return that root node.

## Complexity

- **Time:** O(n) — one pass over the descriptions; each node is touched a constant number of times
- **Space:** O(n) — the hash map of nodes and the child set

## Edge Cases

- Single description -> tree of two nodes, root is the parent
- Same value appearing as parent in one row and child in another -> node reused via the map, not duplicated
- Root determined purely by "parent but never child"; valid input guarantees exactly one
