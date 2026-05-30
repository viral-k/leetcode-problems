# Approach

**Tags:** `Array`, `Binary Indexed Tree`, `Segment Tree`

## Intuition

Obstacles split the number line into gaps. For a query `[2, x, sz]`, a block can fit if either:

- there is a complete gap of length at least `sz` ending at an obstacle at or before `x`
- or the tail gap from the last obstacle at or before `x` to `x` has length at least `sz`

So we need two operations:

1. find the nearest obstacle before and after a newly inserted obstacle
2. query the maximum completed gap whose right endpoint is at most `x`

The coordinate values are bounded, so a Fenwick tree can store obstacle positions and find predecessor/successor by order. A segment tree stores completed gap lengths by their right endpoint.

## Approach

1. Add a sentinel obstacle at `0`.
2. Maintain a Fenwick tree over obstacle positions.
   - It supports counting obstacles up to a coordinate.
   - It can find the coordinate of the kth obstacle.
3. Maintain a segment tree where `gap[pos]` is the distance from the previous obstacle to obstacle `pos`.
4. For a type `1` query at `x`:
   - find `prev`, the nearest obstacle before `x`
   - find `next`, the nearest obstacle after `x`, if it exists
   - add the new completed gap `x - prev` at position `x`
   - if `next` exists, its old gap is split, so update `gap[next]` to `next - x`
   - insert `x` into the Fenwick tree
5. For a type `2` query `[2, x, sz]`:
   - find `prev`, the nearest obstacle at or before `x`
   - get the maximum completed gap with right endpoint `<= x`
   - also check the tail gap `x - prev`
   - return whether the larger of those two values is at least `sz`

## Complexity

Let `M` be the maximum coordinate appearing in the queries.

- **Time:** O(q log M)
- **Space:** O(M)

## Edge Cases

- No obstacle before `x` except `0` -> tail gap is `x`
- Obstacle exactly at `x` -> tail gap is `0`, but completed gaps up to `x` still count
- Inserting an obstacle between two existing obstacles -> the right obstacle's gap must be reduced
- A block may touch obstacles, so a gap of length exactly `sz` is valid
