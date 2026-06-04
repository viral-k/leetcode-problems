# Approach

**Tags:** `Math`, `Simulation`

## Intuition

The range upper bound is only `10^5`, so we can inspect every number directly.

For each number, only internal digits can contribute to waviness. A digit contributes `1` if it is strictly greater than both neighbors or strictly smaller than both neighbors.

## Approach

1. Initialize the total answer to `0`.
2. For every number from `num1` to `num2`:
   - convert it to a string of digits
   - check each internal digit from index `1` to `len(digits) - 2`
   - add `1` when the digit is a peak or valley
3. Return the total.

## Complexity

Let `R = num2 - num1 + 1` and `D` be the maximum number of digits.

- **Time:** O(R * D)
- **Space:** O(D) — for the digit string

Since `num2 <= 10^5`, `D` is at most `6`.

## Edge Cases

- Numbers with fewer than 3 digits -> waviness is `0`
- Equal neighboring digits -> not a peak or valley because comparisons must be strict
- Single-number range -> return that number's waviness
- Alternating digits like `4848` -> every internal digit may contribute
