# Approach

**Tags:** `Math`, `Greedy`

## Intuition

Three independent questions, each with a short answer.

**When does a good integer exist?** An integer with exactly `num` digits has no leading zero, so its digit sum is at least 1 (reached by `10...0`) and at most `9 * num`. Since `sum >= 1` is given, the only impossible case is `sum > 9 * num`.

**Which multiset of digits maximises the score?** The score `sum of d_i^2` is a convex function, and the feasible region is the box `0 <= d_i <= 9` intersected with the plane `sum of d_i = sum`. A convex function over a polytope attains its maximum at a vertex, and the vertices here have every coordinate at 0 or 9 except at most one. So the answer uses `q = sum // 9` nines, one digit equal to `r = sum % 9`, and zeros for the rest. Every vertex is a permutation of that same multiset, which makes it the unique optimum, with score `81q + r^2`.

That also means there is no tension between the two objectives: the score fixes the multiset, and the tie-break only chooses an arrangement of it.

**Which arrangement is the largest number?** Digits sorted descending. Because `sum >= 1` the multiset always contains a nonzero digit, so the leading position is never a zero and the result is a valid `num`-digit integer automatically.

The counts fit whenever the feasibility test passes: if `r > 0` then `q < num`, since `q = num` would force `sum >= 9 * num` and `r > 0` would push it above, contradicting `sum <= 9 * num`. So `q + (1 if r else 0) <= num` needs no separate check.

## Approach

1. If `sum > 9 * num`, return `""`.
2. `q, r = divmod(sum, 9)`.
3. Return `"9" * q`, then `str(r)` when `r > 0`, then `"0"` repeated `num - q - (1 if r else 0)` times.

## Complexity

- **Time:** O(num), which is also the size of the output
- **Space:** O(num) for the result string

## Edge Cases

- `num = 1, sum = 10` → `""`, since one digit cannot exceed 9 (Example 3)
- `sum` an exact multiple of 9 → `r = 0` and no middle digit, e.g. `num = 3, sum = 18` gives `"990"`
- `sum = 9 * num` → all nines, no zeros, e.g. `num = 3, sum = 27` gives `"999"`
- `sum = 1` → `"10...0"`, the smallest valid digit sum
- `sum < 9` → a single digit followed by zeros, e.g. `"30"` for `num = 2, sum = 3` (Example 1)
- `num = 1` with `sum <= 9` → the single digit itself
- A leading zero can never occur, because `sum >= 1` guarantees a nonzero digit exists
- The output reaches `2 * 10^5` characters, so it must be built by repetition rather than by appending in a loop with string concatenation
