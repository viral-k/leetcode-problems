# Approach

**Tags:** `Array`, `Hash Table`, `Math`, `Number Theory`, `Binary Search`, `Counting`, `Prefix Sum`

## Intuition

There are up to `n*(n-1)/2 ≈ 5 * 10^9` pairs, so `gcdPairs` can never be built explicitly. But the **values** are small (`<= 5 * 10^4`), and the queries only ask "what value sits at sorted index q?". That's answerable from the *distribution* of GCD values: if we know how many pairs have each GCD `g`, the sorted array is fully determined, and a prefix sum plus binary search resolves any index.

Counting pairs with GCD **exactly** `g` is the classic divisor inclusion-exclusion (a Mobius-style sieve): it's easy to count pairs whose GCD is a *multiple* of `g`, then subtract the exact counts of the larger multiples.

## Approach

1. `cnt[v]` = frequency of value `v` in `nums`; let `V = max(nums)`.
2. **Harmonic sieve:** `multiples[g] = sum of cnt[g], cnt[2g], cnt[3g], ...` — how many elements are divisible by `g`. Total work is `V/1 + V/2 + ... = O(V log V)`.
3. **Exact counts, descending `g`:**
   - Pairs whose GCD is divisible by `g` = `C(multiples[g], 2)`.
   - `f[g] = C(multiples[g], 2) - sum of f[m] for every multiple m = 2g, 3g, ...`
   Processing `g` from `V` down to `1` means all `f[m]` are already final when needed.
4. **Prefix sums:** `prefix[g] = prefix[g-1] + f[g]` gives, for each `g`, how many entries of sorted `gcdPairs` are `<= g`.
5. **Query:** binary search for the smallest `g` with `prefix[g] > queries[i]`; that `g` is the answer.

## Complexity

- **Time:** O(V log V + q log V) — the sieve dominates preprocessing; each query is a binary search
- **Space:** O(V) — the count, sieve, and prefix arrays

## Edge Cases

- Duplicate values contribute pairs with GCD equal to the value itself (Example 3)
- `C(m, 2) = m*(m-1)/2` can reach ~5 * 10^9 → use `long` for counts and prefix sums
- Queries are guaranteed in range, so the binary search always lands
- Values not present simply have `cnt = 0` and contribute nothing
