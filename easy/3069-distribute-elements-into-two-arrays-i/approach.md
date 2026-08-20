# Approach

**Tags:** `Array`, `Simulation`

## Intuition

The rule is stated procedurally and depends only on the two arrays' **last** elements, so there is nothing to optimize — just follow it step by step. Each array is append-only, so its last element is always available in O(1).

## Approach

1. Seed `arr1 = [nums[0]]` and `arr2 = [nums[1]]` (the first two operations are fixed).
2. For each remaining element `x`:
   - If `arr1[-1] > arr2[-1]`, append `x` to `arr1`.
   - Otherwise append `x` to `arr2`.
3. Return `arr1 + arr2`.

## Complexity

- **Time:** O(n) — one pass, O(1) per element
- **Space:** O(n) — the two arrays / the result

## Edge Cases

- `n >= 3` per constraints, so both seed operations always happen
- Elements are distinct, so the two last elements are never equal — the tie branch is unreachable, but "otherwise → arr2" covers it anyway
- The comparison is strict (`>`); only a strictly larger `arr1` tail sends the element to `arr1`
- The result is a concatenation, not an interleaving
