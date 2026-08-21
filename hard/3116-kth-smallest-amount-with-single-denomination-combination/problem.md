# Kth Smallest Amount With Single Denomination Combination

**Difficulty:** Hard  
**LeetCode Link:** [Kth Smallest Amount With Single Denomination Combination](https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/)

## Description

You are given an integer array `coins` representing coins of different denominations and an integer `k`.

You have an infinite number of coins of each denomination. However, you are not allowed to combine coins of different denominations.

Return the `kth` smallest amount that can be made using these coins.

## Examples

### Example 1
```
Input: coins = [3,6,9], k = 3
Output: 9
Explanation:
Coin 3 produces multiples of 3: 3, 6, 9, 12, 15, ...
Coin 6 produces multiples of 6: 6, 12, 18, 24, ...
Coin 9 produces multiples of 9: 9, 18, 27, 36, ...
All combined: 3, 6, 9, 12, 15, ...
```

### Example 2
```
Input: coins = [5,2], k = 7
Output: 12
Explanation: All amounts: 2, 4, 5, 6, 8, 10, 12, 14, 15, ...
```

## Constraints

- `1 <= coins.length <= 15`
- `1 <= coins[i] <= 25`
- `1 <= k <= 2 * 10^9`
- `coins` contains pairwise distinct integers.
