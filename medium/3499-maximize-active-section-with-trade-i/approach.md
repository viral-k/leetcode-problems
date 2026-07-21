# Approach

**Tags:** `String`, `Greedy`, `Enumeration`, `Two Pointers`

## Intuition

Augment to `t = '1' + s + '1'` and view it as alternating runs. A trade must pick a `1`-run **surrounded by `0`s** — i.e. an interior `1`-run. Around it the runs look like:

```
... [0-run A] [1-run B] [0-run C] ...
```

Zeroing `B` fuses `A`, `B`, `C` into a single `0` block. That block is now bounded by `1`s on both sides, so the second step converts all of it to `1`s.

Accounting the change: we lose the `B` ones, then gain `A + B + C` ones. The `B` cancels, leaving:

```
net gain = A + C
```

So a trade is only ever worth the sum of the two zero-runs flanking the chosen `1`-run — and the best trade is simply the largest sum of **two adjacent zero-runs** in `t`.

## Approach

1. Build `t = '1' + s + '1'` (the sentinels guarantee every interior `1`-run is genuinely surrounded by `0`s, and that any merged `0` block has `1`s on both sides).
2. Scan `t` collecting the lengths of its `0`-runs in order. Consecutive entries in this list are, by construction, separated by exactly one `1`-run.
3. The best gain is `max(z[i] + z[i+1])` over adjacent pairs, or `0` if fewer than two zero-runs exist (no valid trade).
4. Return `(number of '1' in s) + bestGain`.

## Complexity

- **Time:** O(n) — one scan to collect runs, one to compare adjacent pairs
- **Space:** O(n) — the list of zero-run lengths (O(1) achievable by tracking only the previous run)

## Edge Cases

- Fewer than two zero-runs → no valid trade → return the original count (Example 1)
- All `1`s → no zero-runs → gain 0
- All `0`s → one zero-run only → gain 0 (the single `1`-run required in the middle doesn't exist)
- The augmenting `1`s are never counted in the answer — only `'1'`s from `s` plus the gain
- Adjacent zero-runs of length 1 each (e.g. `"01010"`) still yield a gain of 2
