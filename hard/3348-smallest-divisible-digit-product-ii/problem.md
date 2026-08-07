# Smallest Divisible Digit Product II

**Difficulty:** Hard  
**LeetCode Link:** [Smallest Divisible Digit Product II](https://leetcode.com/problems/smallest-divisible-digit-product-ii/)

## Description

You are given a string `num` which represents a positive integer, and an integer `t`.

A number is called zero-free if none of its digits are 0.

Return a string representing the smallest zero-free number greater than or equal to `num` such that the product of its digits is divisible by `t`. If no such number exists, return `"-1"`.

## Examples

### Example 1
```
Input: num = "1234", t = 256
Output: "1488"
Explanation: 1488 is the smallest zero-free number >= 1234 with digit product (256) divisible by 256.
```

### Example 2
```
Input: num = "12355", t = 50
Output: "12355"
Explanation: 12355 is already zero-free; digit product 150 is divisible by 50.
```

### Example 3
```
Input: num = "11111", t = 26
Output: "-1"
Explanation: 26 = 2 * 13, and 13 can never divide a product of digits 1-9.
```

## Constraints

- `2 <= num.length <= 2 * 10^5`
- `num` consists only of digits in the range `['0', '9']`.
- `num` does not contain leading zeros.
- `1 <= t <= 10^14`
