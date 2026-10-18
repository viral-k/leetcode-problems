# Approach

**Tags:** `Array`, `Math`, `Divide and Conquer`, `Dynamic Programming`, `Tree`, `Memoization`, `Combinatorics`, `Binary Tree`

## Intuition

An insertion order determines the tree through one recursive rule: `nums[0]` becomes the root, every smaller value falls into the left subtree in the relative order it appeared, every larger value into the right. Two orders give the same tree exactly when they agree on the root and each side, read in order, rebuilds that side.

So the count is multiplicative over the tree. Suppose the root has `L` nodes below it on the left and `R` on the right. The root has to come first; the remaining `L + R` slots are filled by the two subtrees, and *any* interleaving is fine — interleaving preserves the relative order within each side, which is the only thing the tree sees. Choosing which `L` of the `L + R` slots hold left-subtree values is `C(L + R, L)`, and the two sides are then independent:

```
ways(T) = C(L + R, L) * ways(left) * ways(right)
```

The answer is `ways(whole tree) - 1`, discarding the original ordering.

The standard implementation recurses on the array and partitions it by the root at every step. That is O(n^2) in the worst case: a sorted input builds a chain, so there are `n` levels each costing O(n). In Python it also recurses `n` deep, which at `n = 1000` sits on the default recursion limit.

This solution builds the tree in O(n) instead, using a fact that makes the construction a stack sweep rather than repeated partitioning: **the BST produced by inserting a permutation is the treap on (value, insertion index)** — a BST by value and simultaneously a min-heap by insertion index. The earliest-inserted element has the smallest index and is the root, the rest split by value against it, and the same holds in each half, so the tree is unique and identical to what insertion produces.

A treap can be built from its keys in sorted order by the classic right-spine stack algorithm. Walking values `1..n` ascending is walking the tree in order, so each new value is appended on the right spine: pop everything with a *larger* insertion index (those are younger, so they belong below the new node), the last popped becomes the new node's left child, and the new node becomes the right child of whatever remains on top.

Subtree sizes need no post-order pass. In a BST over `1..n` every subtree covers a contiguous interval of values, so a top-down sweep from `(root, 1, n)` that splits into `(left, lo, v-1)` and `(right, v+1, hi)` yields `size = hi - lo + 1` directly.

With sizes known and `L + R = size(v) - 1`, the whole answer collapses to a single product:

```
ways = product over nodes v of C(size(v) - 1, size(left(v)))
```

## Approach

1. `pos[v]` = index of value `v` in `nums`. The input is a permutation of `1..n`, so every value is present.
2. Factorials and inverse factorials mod `10^9 + 7` up to `n`, the inverses seeded by Fermat (`fact[n]^(p-2)`) and filled downward.
3. Build the treap with the right-spine stack over `v = 1..n`, popping while `pos[top] > pos[v]`. The value left on the bottom of the stack is the root.
4. Sweep intervals from `(root, 1, n)` with an explicit stack to fill `size[v] = hi - lo + 1`.
5. Multiply `C(size[v] - 1, size[left[v]])` over all `v`, treating a missing child as size 0.
6. Return `(product - 1) mod p`.

Every step is iterative, so a sorted input — the deepest possible tree — carries no recursion-depth risk.

## Complexity

- **Time:** O(n log n), and only because of the single `pow` for the inverse factorial; the tree build, interval sweep, factorial table and final product are each O(n)
- **Space:** O(n)

## Edge Cases

- `n = 1` → the product is `C(0, 0) = 1` and the answer is 0
- Already sorted ascending or descending → a chain, every node has one empty side, so every factor is `C(size - 1, 0) = 1`, product 1, answer 0 (example 3)
- A perfectly balanced tree gives the largest product, which is where the modulus matters
- The `- 1` happens after the modular product, so it is taken mod `p` as well; the product is never 0 mod `p` in practice for `n <= 1000`, but reducing after the subtraction keeps the result non-negative regardless
- Values are a permutation of `1..n`, which is what lets subtree sizes be read off value intervals; with arbitrary distinct values the sizes would need a post-order pass instead
- The treap equivalence needs insertion indices to be distinct, which they are
