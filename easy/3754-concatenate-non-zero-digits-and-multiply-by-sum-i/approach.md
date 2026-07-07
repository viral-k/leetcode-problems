# Approach

**Tags:** `Math`, `String`, `Simulation`

## Intuition

Directly follow the definition: filter out zero digits, rebuild the number, sum its digits, multiply.

## Approach

1. Iterate over the digits of `n` (left to right).
2. Keep the non-zero digits: append each to `x` (as `x = x * 10 + d`) and add `d` to `sum`.
3. Return `x * sum`. If there were no non-zero digits, `x` and `sum` stay 0, giving 0.

## Complexity

- **Time:** O(d) where d = number of digits (at most 10)
- **Space:** O(1) (or O(d) if using a string)

## Edge Cases

- `n = 0` → no non-zero digits → answer 0
- All-zero-except-one (e.g. `1000`) → `x = 1`, `sum = 1`
- Order matters: `x` preserves the original digit order
- Max value `x * sum` fits comfortably in 64-bit (`x <= 10^9`, `sum <= 81`)
