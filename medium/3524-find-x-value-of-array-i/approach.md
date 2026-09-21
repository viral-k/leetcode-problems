# Approach

**Tags:** `Array`, `Math`, `Dynamic Programming`

## Intuition

Removing a prefix and a suffix leaves a contiguous non-empty subarray, so the task is to count subarrays by their product modulo `k`. With `k <= 5` there are only five possible residues, which makes a per-residue count over subarrays ending at the current index cheap to maintain.

If `cnt[x]` is the number of subarrays ending at index `r` with product `≡ x`, then every one of them extended by `nums[r+1]` has product `≡ x * nums[r+1]`, and the one-element subarray `[nums[r+1]]` is new. That is a full description of the subarrays ending at `r+1`.

## Approach

1. Keep `cnt` of size `k`, all zero, and `result` of size `k`.
2. For each value `v` in `nums`, with `m = v % k`:
   - build `next` of size `k`; for each residue `x`, `next[x * m % k] += cnt[x]`
   - `next[m] += 1` for the single-element subarray
   - add `next` into `result`, then `cnt = next`
3. Return `result`.

## Complexity

- **Time:** O(n * k), with `k <= 5` effectively O(n)
- **Space:** O(k)

## Edge Cases

- `k = 1` → every product is `≡ 0`, `result = [n(n+1)/2]`
- Values up to `10^9`: reduce each value mod `k` before multiplying so intermediate products stay tiny
- Counts up to `n(n+1)/2 ≈ 5 * 10^9` exceed 32-bit; Java must accumulate in `long`
- A zero residue is absorbing: once a subarray contains a multiple of `k`, every extension stays at residue 0 (Example 2 shows 18 of 21 subarrays landing on 0)
- Single element array → `result[nums[0] % k] = 1`
