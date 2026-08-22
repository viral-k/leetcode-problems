# Approach

**Tags:** `Math`, `Simulation`

## Intuition

Straight transcription of the definition: accumulate the digit sum and digit product in one pass, then test divisibility.

The only thing worth checking is whether the divisor can be zero. It can't — `n` is positive, so it has at least one non-zero digit, making the digit sum at least 1. Even when a `0` digit forces the product to 0, the total stays `>= 1`.

## Approach

1. Peel digits off `n` with `% 10` and `/ 10`, accumulating `sum` and `product` (product seeded at 1, sum at 0).
2. Return `n % (sum + product) == 0`.

Keep a copy of `n` since the loop destroys it.

## Complexity

- **Time:** O(d) where d = number of digits (at most 7)
- **Space:** O(1)

## Edge Cases

- A `0` digit zeroes the product, so the divisor reduces to just the digit sum (e.g. `n = 10` → 1 + 0 = 1 → always true)
- Single-digit `n` → sum = product = `n` → divisor `2n`, so only `n % 2n == 0` when... it never divides, so false for every single digit
- Divisor is never 0, so no guard is needed
- Values stay well within `int` (max digit product is 9^7 < 5 * 10^6)
