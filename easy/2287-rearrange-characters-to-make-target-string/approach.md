# Approach

**Tags:** `Hash Table`, `String`, `Counting`

## Intuition

Each copy of `target` consumes a fixed number of each of its letters. So the number of copies we can build is limited by whichever target letter runs out first in `s`. Count both strings, then take the bottleneck.

## Approach

1. Count the frequency of each character in `s` and in `target`.
2. For each distinct character `ch` in `target`, `s` can support `count_s[ch] // count_target[ch]` copies.
3. The answer is the minimum of those ratios over all distinct characters of `target`.

## Complexity

- **Time:** O(|s| + |target|) — counting both strings
- **Space:** O(1) — fixed-size frequency maps (26 letters)

## Edge Cases

- A target letter absent from `s` -> ratio is `0`, answer `0`
- Repeated target letters (e.g. "aaaaa") -> integer division by the per-copy count handles it
- `s` shorter than `target` -> some ratio is `0`
- Extra letters in `s` not in `target` -> ignored
