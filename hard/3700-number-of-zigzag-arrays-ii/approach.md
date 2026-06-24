# Approach

**Tags:** `Dynamic Programming`, `Matrix Exponentiation`, `Combinatorics`

## Intuition

This is the same counting problem as ZigZag I, but `n` can be up to `10^9`, so the O(n * m) per-length DP is too slow. The DP transition is *linear* in the state, so we can advance many lengths at once with matrix exponentiation. Here `m = r - l + 1 <= 75` is small, which makes an `m x m` matrix power cheap.

## Approach

As in part I, define `up[v]` = number of zigzag sequences ending at value `v` whose last step went up. Using the mirror symmetry `down[v] = up[m-1-v]`, the entire state reduces to the single vector `up`, advanced by one linear map per length:

```
new_up[v] = sum over w >= m - v of up[w]
```

This is multiplication by a fixed `m x m` matrix `M` with `M[v][w] = 1` iff `w >= m - v`.

1. Build `M`.
2. Compute `M^(n-1)` by binary exponentiation (modular `m x m` matrix multiply).
3. The initial vector is all ones (`up` at length 1), so `up` at length `n` is `M^(n-1)` applied to ones — i.e. each `up[v]` is a row sum of the power matrix. Their total is the sum of **all** entries of `M^(n-1)`.
4. By symmetry the grand total is `2 * (sum of all entries)`, taken modulo `10^9 + 7`.

## Complexity

- **Time:** O(m^3 * log n) — `log n` matrix multiplications of size `m`
- **Space:** O(m^2) — the matrices

## Edge Cases

- `m = 2` -> answer `2` for any `n` (only the two alternating arrays)
- Very large `n` (up to `10^9`) -> handled by `log n` exponentiation steps
- Modulo applied throughout to avoid overflow (use `long` accumulation in Java)
- `n - 1` exponent: length-1 base vector is the all-ones vector
