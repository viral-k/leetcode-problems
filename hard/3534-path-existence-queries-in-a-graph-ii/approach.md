# Approach

**Tags:** `Array`, `Binary Lifting`, `Sorting`, `Two Pointers`, `Greedy`

## Intuition

Sort the nodes by value. Then, exactly as in part I, connected components are **contiguous runs** in sorted order (a consecutive gap larger than `maxDiff` can't be crossed by any edge). Cross-component queries answer `-1`.

Within a component, a node at sorted index `i` connects to every node whose value lies in `[val_i - maxDiff, val_i + maxDiff]` — a contiguous sorted range `[L_i, R_i]`. To reach a target on the right in the fewest hops, always jump as far right as possible. Because `R_i` is non-decreasing in `i`, the single most valuable jump from `i` lands exactly at `R_i` (that node's reach dominates every other choice in the range). This turns the shortest path into a classic **greedy farthest-jump** count, which **binary lifting** answers in `O(log n)` per query.

## Approach

1. Sort node indices by `nums`; record each node's sorted rank and the sorted value array.
2. Two pointers compute `R[i]` = farthest sorted index reachable in one hop from `i` (largest `j` with `val_j <= val_i + maxDiff`).
3. Component ids via consecutive gaps (`val_i - val_{i-1} > maxDiff` starts a new component).
4. Binary-lifting table `up[k][i]` = position after `2^k` greedy jumps, with `up[0][i] = R[i]`.
5. Per query `[u, v]` with ranks `su, sv` (swap so `su <= sv`):
   - Different components → `-1`.
   - `su == sv` → `0`.
   - Otherwise binary-lift from `su`: for `k` high→low, if `up[k][cur] < sv`, take the jump (`cur = up[k][cur]`, add `2^k`). One final jump reaches `sv`, so answer is `count + 1`.

## Complexity

- **Time:** O((n + q) log n) — sort, lifting table build, `O(log n)` per query
- **Space:** O(n log n) — the lifting table

## Edge Cases

- Self query `[u, u]` → `0`
- Isolated node (both neighbors' gaps exceed `maxDiff`) → only reaches itself
- Duplicate values → all in one range, distance 1 between any two (or 0 if same node)
- `maxDiff = 0` → edges only between equal values
- Same component always guarantees progress (`R[i] > i` for non-last nodes in a run), so the final `+1` jump always lands
