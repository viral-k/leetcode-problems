# Approach

**Tags:** `Digit DP`, `Dynamic Programming`, `Math`

## Intuition

The range can go up to `10^15`, so scanning every number is impossible.

Instead, count the total waviness for all numbers from `0` to `limit` with digit DP. Then:

```
answer = count(num2) - count(num1 - 1)
```

When building a number from left to right, a digit can only be classified as a peak or valley after its right neighbor is known. So the DP keeps the last two significant digits. When a new digit is appended, the previous digit becomes an internal digit with both neighbors known.

## State

`dp(position, tight, started, previousPreviousDigit, previousDigit)` returns:

- how many numbers can be formed from this state
- the total waviness contributed by all those numbers

`previousPreviousDigit = -1` means only one significant digit has been placed so far.

## Transition

For each possible next digit:

1. If the number has not started and the digit is `0`, keep skipping leading zeros.
2. If this is the first significant digit, store it as `previousDigit`.
3. If there is only one previous significant digit, store the pair.
4. Otherwise, check whether `previousDigit` is a peak or valley using:
   ```
   previousPreviousDigit, previousDigit, currentDigit
   ```
   Add that contribution for every number formed by the suffix.

At the end of the digits, return one formed number with no additional contribution. The last digit is never counted because it never becomes internal.

## Complexity

Let `D` be the number of digits in `limit`.

- **Time:** O(D * 10 * 11 * 11 * 10)
- **Space:** O(D * 11 * 11) for memoization

Since `num2 <= 10^15`, `D` is at most `16`.

## Edge Cases

- Numbers with fewer than 3 digits -> no digit ever has both neighbors, so contribution is `0`
- Equal neighboring digits -> strict peak and valley comparisons fail
- Leading zeros -> ignored until the first non-zero digit
- Single-number range -> handled by prefix subtraction
