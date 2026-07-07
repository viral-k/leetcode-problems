# Concatenate Non-Zero Digits and Multiply by Sum I

**Difficulty:** Easy  
**LeetCode Link:** [Concatenate Non-Zero Digits and Multiply by Sum I](https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/)

## Description

You are given an integer `n`.

Form a new integer `x` by concatenating all the non-zero digits of `n` in their original order. If there are no non-zero digits, `x = 0`.

Let `sum` be the sum of digits in `x`.

Return an integer representing the value of `x * sum`.

## Examples

### Example 1
```
Input: n = 10203004
Output: 12340
Explanation: Non-zero digits are 1, 2, 3, 4 -> x = 1234. sum = 10. x * sum = 12340.
```

### Example 2
```
Input: n = 1000
Output: 1
Explanation: Non-zero digit is 1 -> x = 1, sum = 1. x * sum = 1.
```

## Constraints

- `0 <= n <= 10^9`
