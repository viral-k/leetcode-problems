# Approach

**Tags:** `Tree`, `DFS`, `Binary Tree`, `Recursion`

## Intuition

Each node's test needs two facts about its own subtree: the sum of the values and how many there are. Both are simple aggregates of the same facts for the left and right subtrees, so a single post-order traversal can compute them bottom-up and answer every node on the way back.

Post-order is forced here rather than chosen. A node cannot be checked until its children have reported their totals, so the recursion has to descend first and do its work while unwinding.

Returning the pair `(sum, count)` up the call chain is what keeps this linear. Computing the subtree sum separately at each node would re-walk the same descendants once per ancestor and degrade to O(n * h).

## Approach

1. Define `dfs(node)` returning `(sum, count)` for the subtree rooted at `node`.
   - Empty node returns `(0, 0)`, which makes a leaf's arithmetic fall out naturally.
2. Recurse left and right, then combine:
   - `total = leftSum + rightSum + node.val`
   - `count = leftCount + rightCount + 1`
3. If `node.val == total // count`, increment the answer. Integer division is
   already the floor the problem asks for, since all values are non-negative.
4. Return `(total, count)` to the caller.
5. The answer is the running count after the traversal finishes.

## Complexity

- **Time:** O(n) — every node visited once, O(1) work each
- **Space:** O(h) recursion stack, up to O(n) for a fully skewed tree

## Edge Cases

- Single node → its own average is itself → 1 (Example 2)
- Every leaf always matches, since `val / 1 == val`; a tree of `L` leaves scores at least `L`
- Values may be `0`, so `0 / 1 == 0` counts (Example 1 includes it)
- Averages are floored, so a node like `5` with subtree sum 11 over 2 nodes matches
- Max subtree sum is `1000 * 1000 = 10^6`, comfortably inside `int`
- Skewed trees reach depth 1000, which stays within default recursion limits
