# Approach

**Tags:** `Math`, `Dynamic Programming`, `Combinatorics`, `Number Theory`

## Intuition

A configuration is a sequence of `2k` endpoints `l_1 <= r_1 <= l_2 <= r_2 <= ... <= l_k <= r_k` drawn from `{0, ..., n-1}`, with two rules about equality:

- `l_i < r_i` strictly, since a segment must cover at least two points.
- `r_i <= l_{i+1}`, with equality allowed, since consecutive segments may share an endpoint.

So the sequence is "strict inside a segment, weak between segments". That mixed pattern converts to a fully strict one with a standard shift: bump every endpoint of segment `i` up by `i - 1`. The `k - 1` gaps between segments each absorb one extra unit, turning `r_i <= l_{i+1}` into `r_i < l_{i+1}` while leaving the within-segment strictness intact. The shifted values now live in `{0, ..., n + k - 2}`, a set of `n + k - 1` points, and any strictly increasing choice of `2k` of them maps back to exactly one valid configuration.

That gives the count directly:

```
answer = C(n + k - 1, 2k)
```

Check: `n = 30, k = 7` gives `C(36, 14) = 3,796,297,200`, matching Example 3's stated total before the modulus.

## Approach

1. Let `N = n + k - 1` and `r = 2k`. If `r > N`, return 0 (impossible).
2. Compute `C(N, r)` modulo `10^9 + 7` with the multiplicative formula, multiplying by `(N - r + i)` and by the modular inverse of `i` for `i = 1..r`. The inverse comes from Fermat's little theorem since the modulus is prime.

An equivalent state DP (walk the points, tracking segments completed and whether one is currently open) also solves it in O(n * k). The closed form is preferred because it is O(k) and the DP served only to cross-check the formula's off-by-one details.

## Complexity

- **Time:** O(k log MOD) — `2k` multiplications, each with one modular exponentiation for the inverse (O(k) with a precomputed inverse table)
- **Space:** O(1)

## Edge Cases

- `k = 1` → `C(n, 2)`, i.e. every pair of distinct points forms a segment (Example 2 gives `C(3, 2) = 3`)
- `k = n - 1` → the only layout is `n - 1` unit segments end to end → exactly 1 way, and `C(2n - 2, 2n - 2) = 1`
- `2k > n + k - 1` never occurs under the constraints (`k <= n - 1` implies `2k <= n + k - 1`), but the guard is cheap
- Intermediate products must be reduced modulo at each step to avoid overflow in Java (`long` is required)
- Segments may share an endpoint but never overlap in interior, which is exactly what the "weak between, strict inside" ordering encodes
