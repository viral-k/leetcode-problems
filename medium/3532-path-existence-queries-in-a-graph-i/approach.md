# Approach

**Tags:** `Array`, `Union Find`, `Prefix Sum`

## Intuition

`nums` is sorted, which collapses the whole graph structure: a connected component is always a **contiguous range** of indices. Two neighbors `i` and `i+1` are joined iff `nums[i+1] - nums[i] <= maxDiff`. If that consecutive gap exceeds `maxDiff`, nothing can bridge it — any edge crossing the gap connects two values at least that far apart (sorted order), so it also exceeds `maxDiff`. Hence the components are exactly the maximal runs where every consecutive gap is `<= maxDiff`.

## Approach

1. Build a component id array in one pass:
   - `comp[0] = 0`.
   - `comp[i] = comp[i-1]` if `nums[i] - nums[i-1] <= maxDiff`, else `comp[i-1] + 1`.
2. For each query `[u, v]`, answer `comp[u] == comp[v]`.

## Complexity

- **Time:** O(n + q)
- **Space:** O(n) — the component-id array

## Edge Cases

- Self query `[u, u]` → always `true`
- `maxDiff = 0` → nodes connected only if their values are exactly equal (equal adjacent values still merge)
- All equal values → one component → every query `true`
- Single node → trivially its own component
