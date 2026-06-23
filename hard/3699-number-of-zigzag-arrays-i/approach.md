# Approach

**Tags:** `Dynamic Programming`, `Prefix Sum`, `Combinatorics`

## Intuition

"No two adjacent equal" plus "no three consecutive strictly monotonic" forces a strict **zigzag**: the sequence must alternate up, down, up, down (or down, up, down, ...). Only the relative order of values matters, so shift the range `[l, r]` to `0 .. m-1` where `m = r - l + 1`; the count depends only on `n` and `m`.

We build the sequence one element at a time, tracking the value of the last element and the direction of the last step (since the next step must be the opposite direction).

## Approach

Let, for the current length:

- `up[v]` = number of valid zigzag sequences ending at value `v` whose last step went **up** (`prev < v`),
- `down[v]` = number ending at `v` whose last step went **down** (`prev > v`).

Because directions must alternate:

```
new_up[v]   = sum over u < v of down[u]      (a down step preceded this up step)
new_down[v] = sum over u > v of up[u]         (an up step preceded this down step)
```

The first sum is a prefix sum of `down`; the second a suffix sum of `up` — each extension is O(m).

1. Base (length 1): `up[v] = down[v] = 1` for all `v`.
2. Repeat the transition `n - 1` times.
3. Answer = `sum(up[v] + down[v]) mod (10^9 + 7)`.

(There is a mirror symmetry `down[v] = up[m-1-v]`, so the total equals `2 * sum(up)`; both arrays are kept for clarity.)

## Complexity

- **Time:** O(n * m) — `n` length steps, each O(m) via prefix/suffix sums
- **Space:** O(m) — two rolling arrays

## Edge Cases

- `m = 2` (e.g. `l, r` adjacent) -> only the two alternating arrays, answer `2`
- Minimum length `n = 3`
- All arithmetic taken modulo `10^9 + 7`
- Symmetry halves the conceptual work but the loop already runs in O(n * m)
