# Check Divisibility by Digit Sum and Product

**Difficulty:** Easy  
**LeetCode Link:** [Check Divisibility by Digit Sum and Product](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/)

## Description

You are given a positive integer `n`. Determine whether `n` is divisible by the sum of the following two values:

- The digit sum of `n` (the sum of its digits).
- The digit product of `n` (the product of its digits).

Return `true` if `n` is divisible by this sum; otherwise, return `false`.

## Examples

### Example 1
```
Input: n = 99
Output: true
Explanation: digit sum = 9 + 9 = 18, digit product = 9 * 9 = 81, total = 99.
99 is divisible by 99, so the answer is true.
```

### Example 2
```
Input: n = 23
Output: false
Explanation: digit sum = 2 + 3 = 5, digit product = 2 * 3 = 6, total = 11.
23 is not divisible by 11, so the answer is false.
```

## Constraints

- `1 <= n <= 10^6`
