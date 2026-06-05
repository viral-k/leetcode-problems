# Total Waviness of Numbers in Range II

**Difficulty:** Hard  
**LeetCode Link:** [Total Waviness of Numbers in Range II](https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/)

## Description

You are given two integers `num1` and `num2` representing an inclusive range `[num1, num2]`.

The waviness of a number is defined as the total count of its peaks and valleys:

- A digit is a peak if it is strictly greater than both of its immediate neighbors.
- A digit is a valley if it is strictly less than both of its immediate neighbors.
- The first and last digits of a number cannot be peaks or valleys.

Any number with fewer than `3` digits has a waviness of `0`.

Return the total sum of waviness for all numbers in the range `[num1, num2]`.

## Examples

### Example 1
```
Input: num1 = 120, num2 = 130
Output: 3
Explanation:
120, 121, and 130 each have one peak. All other numbers in the range have waviness 0.
```

### Example 2
```
Input: num1 = 198, num2 = 202
Output: 3
Explanation:
198 has one peak. 201 and 202 each have one valley.
```

### Example 3
```
Input: num1 = 4848, num2 = 4848
Output: 2
Explanation:
In 4848, the second digit 8 is a peak and the third digit 4 is a valley.
```

## Constraints

- `1 <= num1 <= num2 <= 10^15`
