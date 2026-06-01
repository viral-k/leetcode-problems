# Minimum Cost of Buying Candies With Discount

**Difficulty:** Easy  
**LeetCode Link:** [Minimum Cost of Buying Candies With Discount](https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/)

## Description

A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.

The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.

Given a 0-indexed integer array `cost`, where `cost[i]` denotes the cost of the ith candy, return the minimum cost of buying all the candies.

## Examples

### Example 1
```
Input: cost = [1,2,3]
Output: 5
Explanation: Buy candies with costs 2 and 3, then take the candy with cost 1 for free.
```

### Example 2
```
Input: cost = [6,5,7,9,2,2]
Output: 23
Explanation:
Buy candies with costs 9 and 7, then take the candy with cost 6 for free.
Buy candies with costs 5 and 2, then take the last candy with cost 2 for free.
```

### Example 3
```
Input: cost = [5,5]
Output: 10
Explanation: Since there are only 2 candies, buy both of them.
```

## Constraints

- `1 <= cost.length <= 100`
- `1 <= cost[i] <= 100`
