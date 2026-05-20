# Approach

**Tags:** `Array`, `Hash Table`, `Counting`

## Intuition

At each index, one value from `A` and one value from `B` become available in the prefixes.

Because both arrays are permutations of `1` to `n`, a value becomes common exactly when we have seen it twice in total: once from `A` and once from `B`.

## Approach

1. Keep a count array `seen` of size `n + 1`.
2. Keep a running `common` count.
3. For each index `i`:
   - increment `seen[A[i]]`; if it becomes `2`, increment `common`
   - increment `seen[B[i]]`; if it becomes `2`, increment `common`
   - store `common` in the answer
4. Return the answer array.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Edge Cases

- `A[i] == B[i]` -> the value is counted as common at the same index
- No common value in early prefixes -> answer contains `0`
- Last index always reaches `n` because both arrays are permutations
- Single element arrays -> return `[1]`
