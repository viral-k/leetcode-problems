# Approach

**Tags:** `Array`, `Prefix Sum`

## Intuition

The altitude at each point is the running sum of the gains up to that point, starting from `0`. So the highest altitude is simply the maximum prefix sum of `gain`, including the starting altitude of `0`.

## Approach

1. Track the current altitude, starting at `0`.
2. Track the highest altitude seen, also starting at `0` (the start point counts).
3. For each value in `gain`, add it to the current altitude and update the maximum.
4. Return the maximum.

## Complexity

- **Time:** O(n) — single pass over `gain`
- **Space:** O(1)

## Edge Cases

- All negative gains -> the altitude only drops, so the answer is the starting `0`
- All positive gains -> the answer is the total sum (the final point)
- Single element -> max of `0` and that one altitude
