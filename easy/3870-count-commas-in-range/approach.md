# Approach

**Tags:** `Math`, `Counting`

## Intuition

A number with `d` digits carries `(d - 1) / 3` commas. Rather than computing that per number and summing, flip the counting around: ask **how many numbers earn each comma**.

A number gets its first comma once it reaches 1,000, its second once it reaches 1,000,000, its third at 1,000,000,000, and so on — one comma per grouping threshold it meets or exceeds. So instead of iterating over numbers, iterate over thresholds and count how many values in `[1, n]` clear each one:

```
total = sum over k >= 1 of  max(0, n - 10^(3k) + 1)
```

Each term counts the numbers from `10^(3k)` through `n`, i.e. exactly those that have earned the `k`-th comma.

Under the given constraint (`n <= 10^5`) only the `k = 1` term can be nonzero, so this reduces to `max(0, n - 999)` — but writing it as the loop keeps it correct if the bound ever grows.

## Approach

1. Start `total = 0` and `threshold = 1000`.
2. While `threshold <= n`: add `n - threshold + 1` to `total`, then multiply `threshold` by 1000.
3. Return `total`.

## Complexity

- **Time:** O(log n) — one iteration per grouping threshold (at most a handful)
- **Space:** O(1)

## Edge Cases

- `n < 1000` → the loop never runs → 0 (Example 2)
- `n == 1000` → exactly one number has a comma → 1
- `n = 10^5` → `100000 - 999 = 99001` commas
- Numbers at a threshold boundary (1000, 10^6) are inclusive, hence the `+ 1`
- Multiplying `threshold` by 1000 can overflow a 32-bit int for large bounds; use `long` in Java
