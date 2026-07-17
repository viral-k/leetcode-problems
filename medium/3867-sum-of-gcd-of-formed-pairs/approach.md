# Approach

**Tags:** `Array`, `Math`, `Number Theory`, `Sorting`, `Two Pointers`, `Simulation`

## Intuition

The problem spells out the procedure, so just follow it efficiently. Two observations keep it linear-ish:

- The running maximum `mx_i` is computed in a single left-to-right pass — no need to recompute a max per index.
- "Repeatedly pair the smallest unpaired with the largest unpaired" on a sorted array is exactly a **two-pointer** walk inward from both ends. The odd middle element is skipped for free when the pointers cross.

## Approach

1. Sweep left to right maintaining `mx` = running max; set `prefixGcd[i] = gcd(nums[i], mx)`.
2. Sort `prefixGcd`.
3. Two pointers `l = 0`, `r = n - 1`; while `l < r`, add `gcd(a[l], a[r])` to the answer, then `l++`, `r--`.
4. Return the sum.

## Complexity

- **Time:** O(n log n + n log V) — the sort dominates; each gcd is O(log V)
- **Space:** O(n) — the `prefixGcd` array

## Edge Cases

- `n = 1` → no pairs can be formed → 0
- `n` odd → the middle element is skipped automatically when `l == r`
- Note `gcd(nums[i], mx_i) == nums[i]` whenever `nums[i]` is itself the running max
- Sum can reach ~n · 10^9 ≈ 10^14 → use `long` in Java
