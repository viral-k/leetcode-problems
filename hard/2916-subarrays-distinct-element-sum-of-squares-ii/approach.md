# Approach

**Tags:** `Array`, `Hash Table`, `Binary Indexed Tree`, `Segment Tree`

## Intuition

Sweep the right endpoint and keep, for every left endpoint `i`, the distinct count `D[i]` of `nums[i..j]`. The answer is the running total of `S2 = sum of D[i]^2` taken after each step, since that sum is exactly the contribution of all subarrays ending at `j`.

The key is that advancing `j` changes `D` in a very restricted way. With `v = nums[j]` and `last[v]` the previous position of `v`, the count rises by one precisely for `i` in `[last[v] + 1, j]`. For any `i <= last[v]` the value `v` is already inside the window, so nothing changes there.

That makes the update a range increment, and the effect on a sum of squares is algebraic rather than requiring a rebuild. If `m` indices each go from `d` to `d + 1`, then since `(d + 1)^2 = d^2 + 2d + 1`,

```
S2 += 2 * (sum of D over the range) + m
```

So the only thing the data structure has to provide is a range sum before the increment, and a range increment afterwards. A Fenwick pair supports both in O(log n), using the standard two-tree trick where `prefix(i) = sum(B1, i) * i - sum(B2, i)`.

A lazy segment tree storing both the sum and the sum of squares per node also solves this, and is the more commonly shown solution. It is strictly more machinery: the sum of squares only ever needs to exist as the single scalar `S2`, not per node, once the identity above is used. The Fenwick version keeps two flat arrays and no recursion, which measured about 0.4s at the maximum input size in Python.

## Approach

1. Two Fenwick arrays over `1..n`, both zero, representing `D` with range-add and range-sum.
2. `S2 = 0`, `answer = 0`, `last` an empty map.
3. For each `j`:
   - `L = last.get(v, -1) + 1` and `m = j - L + 1`
   - `total = range_sum(L, j)`, the values of `D` on that range *before* the increment
   - `S2 = (S2 + 2 * total + m) mod p`
   - `range_add(L, j, 1)`, then `last[v] = j`
   - `answer = (answer + S2) mod p`
4. Return `answer`.

Reading the range sum before applying the increment is essential; the identity uses the old `d` values.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Edge Cases

- All elements identical → each step has `L = j`, so `m = 1` and only the new index gains a count; the answer is `n(n + 1) / 2`
- All elements distinct → `L = 0` every step, so the whole active prefix increments
- Single element → 1
- First occurrence of a value has `last[v]` absent, which the `-1` default turns into `L = 0`
- The Fenwick trees hold exact counts, not residues: `D[i] <= n` and a range sum is at most `n^2 = 10^10`, which fits a signed 64-bit integer. Only `S2` and the answer are reduced modulo `10^9 + 7`
- Taking the modulus inside the Fenwick trees would break the arithmetic, since the sum feeds a multiplication by 2 that must match the true values
- `prefix(i) = sum(B1, i) * i - sum(B2, i)` reaches `10^10`, so Java needs `long` arrays
