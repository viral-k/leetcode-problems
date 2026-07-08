# Approach

**Tags:** `Array`, `String`, `Prefix Sum`, `Math`, `Number Theory`

## Intuition

Two pieces per query: the digit sum and the concatenated value `x` (mod `p = 1e9 + 7`).

- **Sum:** dropping zeros doesn't change the digit sum (zeros add 0), so `sum` = sum of *all* digit values in `s[l..r]`. A prefix-sum array answers this in O(1).
- **x mod p:** `x` is the concatenation of the non-zero digits, which can be up to `m` digits long — far too big to build. But we only need it mod `p`. The place value of a non-zero digit depends on **how many non-zero digits follow it inside the query range**, which prefix counts give us.

## Approach

Let `cnt[i]` = number of non-zero digits in `s[0..i-1]`. For a non-zero digit `d_q` at position `q` in query `[l, r]`, the count of non-zero digits after it is `cnt[r+1] - cnt[q+1]`, so its contribution is `d_q * 10^{cnt[r+1] - cnt[q+1]}`. Factor out the query-dependent power:

```
x  =  10^{cnt[r+1]}  *  sum_{q in [l,r]}  d_q * 10^{-cnt[q+1]}   (mod p)
```

The per-position weight `w_q = d_q * inv10^{cnt[q+1]} (mod p)` doesn't depend on the query, so:

1. Precompute `pow10[]`, `inv10pow[]`, prefix counts `cnt[]`, prefix digit sums `sumPref[]`, and prefix weight sums `wPref[]` (where `wPref[i] = sum of w_q for q < i`).
2. Per query:
   - `S = (wPref[r+1] - wPref[l]) mod p`
   - `x = pow10[cnt[r+1]] * S mod p`
   - `sum = sumPref[r+1] - sumPref[l]`
   - `answer = x * (sum mod p) mod p`

`inv10 = modpow(10, p-2, p)` (Fermat), since `p` is prime and `gcd(10, p) = 1`.

## Complexity

- **Time:** O(m + q) — linear preprocessing, O(1) per query
- **Space:** O(m) — the prefix arrays

## Edge Cases

- All-zero substring → `S = 0` → `x = 0`, and `sum = 0` → answer 0
- Single zero digit query → 0
- Leading zeros inside the range are naturally skipped (they carry weight 0 and don't advance `cnt`)
- Keep every intermediate mod `p`; use `long` and add `p` before `% p` on subtractions to avoid negatives
