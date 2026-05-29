# Approach

**Tags:** `Array`, `Math`

## Intuition

Each number is independent. Replace a number by repeatedly taking its last digit and adding it to a running sum, then removing that digit.

After computing the digit sum for every number, keep the smallest value seen.

## Approach

1. Initialize the answer to infinity.
2. For each number in `nums`:
   - compute its digit sum using modulo `10` and integer division by `10`
   - update the answer with the smaller digit sum
3. Return the answer.

## Complexity

Let `D` be the maximum number of digits in any number.

- **Time:** O(n * D)
- **Space:** O(1)

Since `nums[i] <= 10^4`, `D` is at most `5`.

## Edge Cases

- Single element array -> return that element's digit sum
- One-digit numbers -> digit sum is the number itself
- Values like `10000` -> zeros do not change the sum
