# Approach

**Tags:** `Math`, `Counting`

## Intuition

Same counting argument as part I, but `n` now reaches `10^15`, so iterating over the range is out and the result no longer fits in 32 bits.

A number with `d` digits carries `(d - 1) / 3` commas. Rather than computing that per number, count how many numbers earn each comma. A value gets its first comma at 1,000, its second at 1,000,000, its third at 1,000,000,000, and so on, one per grouping threshold it reaches:

```
total = sum over k >= 1 of  max(0, n - 10^(3k) + 1)
```

Each term counts the values from `10^(3k)` up to `n`, which is exactly the set that has earned the k-th comma.

At the upper bound five thresholds contribute (`10^3` through `10^15`) and the sum approaches `4 * 10^15`, well past `Integer.MAX_VALUE`. Both the input and the accumulator have to be 64-bit.

## Approach

1. Start `total = 0` and `threshold = 1000`.
2. While `threshold <= n`: add `n - threshold + 1` to `total`, then multiply `threshold` by 1000.
3. Return `total`.

## Complexity

- **Time:** O(log n) — five iterations at most under these constraints
- **Space:** O(1)

## Edge Cases

- `n < 1000` → loop never runs → 0
- `n = 10^15` → 4,000,000,000,000,005 total commas, which requires `long`
- Threshold boundaries are inclusive, hence the `+ 1`
- `threshold *= 1000` overflows a 32-bit int on the fourth iteration, so the loop variable must be `long` as well as the accumulator
- Part I capped `n` at `10^5`, where only the first threshold applies and the answer fits in `int`; the same loop covers both
