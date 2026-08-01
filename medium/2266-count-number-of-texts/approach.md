# Approach

**Tags:** `Hash Table`, `Math`, `String`, `Dynamic Programming`

## Intuition

A run of the same digit can be broken into letters independently of the other runs (a different digit forces a boundary). So the total is the **product** over runs of "how many ways this run splits into letters".

Within a run of length `L`, each letter is one press-group of size 1..`m`, where `m = 4` for keys `7` and `9` (they have four letters), and `m = 3` for the rest. Counting the ways to tile a length-`L` strip with pieces of size 1..`m` is the tribonacci (`m = 3`) or tetranacci (`m = 4`) recurrence:

```
dp3[i] = dp3[i-1] + dp3[i-2] + dp3[i-3]
dp4[i] = dp4[i-1] + dp4[i-2] + dp4[i-3] + dp4[i-4]
```

## Approach

1. Precompute `dp3` and `dp4` up to `n` (mod `1e9 + 7`), with base cases `dp[0] = 1`.
2. Scan `pressedKeys`, grouping maximal runs of equal digits.
3. For each run, multiply the answer by `dp4[len]` if the digit is `7` or `9`, else `dp3[len]`.
4. Return the product modulo `1e9 + 7`.

## Complexity

- **Time:** O(n) — precompute tables and one scan
- **Space:** O(n) — the DP tables

## Edge Cases

- Single-character run → 1 way
- Long uniform run of `2` → pure tribonacci (Example 2)
- Keys `7` and `9` use the 4-term recurrence; all others the 3-term
- Apply the modulus throughout to avoid overflow (`long` in Java)
- Base cases `dp[0] = dp[1] = 1`, `dp[2] = 2`, etc., must be seeded correctly
