# Approach

**Tags:** `String`, `Segment Tree`, `Divide and Conquer`, `Array`

## Intuition

Recomputing the longest single-character run after each update would be O(n) per query — O(n * k) overall, far too slow. But the answer is a **mergeable** property: if you know, for two adjacent blocks, their longest internal run plus the runs touching their edges, you can combine them in O(1). That's exactly a segment tree over the string.

The one subtlety is that a run can *span* the boundary between two children, so each node must remember its edge runs, not just its best.

## Approach

Each segment tree node stores:

- `len` — the segment length
- `lc`, `rc` — the characters at its left and right edges
- `pre` — length of the longest run starting at the left edge
- `suf` — length of the longest run ending at the right edge
- `best` — length of the longest run anywhere inside

**Merge (`left`, `right`):**
```
best = max(left.best, right.best)
if left.rc == right.lc:
    best = max(best, left.suf + right.pre)        # run crossing the boundary

pre = left.pre + (right.pre if left.pc spans all of left and left.rc == right.lc else 0)
suf = right.suf + (left.suf if right.suf spans all of right and left.rc == right.lc else 0)
```
The `pre`/`suf` extensions only apply when a child is **entirely** one character, in which case the run continues into the sibling.

**Per query:** set the leaf's character, walk up re-merging along the path, then read `best` at the root.

An iterative array-based tree (size padded to a power of two) avoids recursion overhead; empty padding leaves are handled by treating a zero-length child as identity in the merge.

## Complexity

- **Time:** O((n + k) log n) — O(n) build, O(log n) per update
- **Space:** O(n) — the node arrays

## Edge Cases

- Update that doesn't change the character → still correct (merge is idempotent)
- Entire string one character → `pre = suf = best = n`
- Single-character string → every query answers 1
- Runs crossing node boundaries are the reason `pre`/`suf` are tracked at all
- Padding leaves beyond `n` must not contribute; guard with `len == 0`
