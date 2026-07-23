# Approach

**Tags:** `Bit Manipulation`, `Math`, `Combinatorics`

## Intuition

Because `nums` is a permutation of `{1, 2, ..., n}`, the multiset of available values is *always* exactly `{1..n}` — so the answer depends only on `n`, not on the ordering. And since indices may repeat (`i <= j <= k`), we can pick the same element twice: `x XOR x XOR k = k`, which already makes every single value `1..n` reachable.

- **`n = 1`:** only `1` exists → `1 XOR 1 XOR 1 = 1` → **1** value.
- **`n = 2`:** only `{1, 2}`; any triplet reduces to one of them → **2** values.
- **`n >= 3`:** we additionally reach `0` (e.g. `1 XOR 2 XOR 3 = 0`), and combining three distinct values sets every bit pattern up to the top bit of `n`. The reachable set becomes the whole range `[0, 2^B - 1]` where `B = bit_length(n)`, giving **`2^B`** values.

## Approach

Return:
- `1` if `n == 1`,
- `2` if `n == 2`,
- `1 << n.bit_length()` otherwise.

## Complexity

- **Time:** O(1) (O(n) to read the input for `n`)
- **Space:** O(1)

## Edge Cases

- `n = 1` and `n = 2` are the special cases where the value space isn't yet "full"
- For `n >= 3` the answer is the smallest power of two strictly greater than `n` when `n` is not itself a power of two, and `2n` when it is (both captured by `2^bit_length(n)`)
- Verified by brute force for all `n` up to 14
