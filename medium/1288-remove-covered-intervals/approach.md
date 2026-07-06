# Approach

**Tags:** `Array`, `Sorting`, `Greedy`

## Intuition

Sort so that whenever one interval could cover another, the potential coverer is visited first. Sorting by left endpoint ascending guarantees every later interval has `l >= all previous lefts`, so coverage reduces to a single check on the right endpoint: a later interval is covered iff its right endpoint doesn't extend past the largest right seen so far.

The tricky case is equal left endpoints: then the longer interval (larger right) must come first, otherwise it would be wrongly marked as covered by the shorter one. So break ties by right endpoint **descending**.

## Approach

1. Sort intervals by `(l asc, r desc)`.
2. Sweep, tracking `maxRight` = the largest right endpoint seen.
3. For each interval `[l, r]`:
   - If `r <= maxRight`, it's covered (its left is already `>=` a prior left) → skip.
   - Otherwise it survives → increment the count and update `maxRight = r`.
4. Return the survivor count.

## Complexity

- **Time:** O(n log n) — the sort dominates
- **Space:** O(1) extra (in place, ignoring sort)

## Edge Cases

- Equal left endpoints → tie-break by right descending prevents the longer one being marked covered
- Single interval → always 1
- Nested chains `[1,10],[2,9],[3,8]` → only the outermost survives (1)
- Intervals are unique, but coverage (not equality) is what matters
