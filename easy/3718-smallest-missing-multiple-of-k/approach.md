# Approach

**Tags:** `Array`, `Hash Table`, `Math`, `Simulation`

## Intuition

Walk the multiples of `k` in increasing order and return the first one that isn't present. A hash set makes each membership test O(1).

The scan is guaranteed to end quickly: every value in `nums` is at most 100, so the first multiple exceeding 100 cannot possibly be in the array. At worst that's `k, 2k, ..., ` up to just past 100 — about `100 / k + 1` checks.

## Approach

1. Build a set from `nums`.
2. Starting at `m = k`, increment by `k` while `m` is in the set.
3. Return the first `m` not in the set.

## Complexity

- **Time:** O(n + 100/k) — building the set dominates
- **Space:** O(n) — the membership set

## Edge Cases

- `k` itself missing → answer is `k` immediately (Example 2)
- `k > 100` → `k` can never appear in `nums`, so the answer is `k`
- Every multiple up to 100 present (e.g. `k = 1` with `nums` covering 1..100) → answer is 101
- Values in `nums` that aren't multiples of `k` are simply irrelevant
- The answer can exceed the largest value in `nums`, so a fixed-size lookup must be bounds-checked
