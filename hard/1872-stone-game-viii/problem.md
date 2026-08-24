# Stone Game VIII

**Difficulty:** Hard  
**LeetCode Link:** [Stone Game VIII](https://leetcode.com/problems/stone-game-viii/)

## Description

Alice and Bob take turns playing a game, with Alice starting first.

There are `n` stones arranged in a row. On each player's turn, while the number of stones is more than one, they will do the following:

1. Choose an integer `x > 1`, and remove the leftmost `x` stones from the row.
2. Add the sum of the removed stones' values to the player's score.
3. Place a new stone, whose value is equal to that sum, on the left side of the row.

The game stops when only one stone is left in the row.

The score difference between Alice and Bob is `(Alice's score - Bob's score)`. Alice's goal is to maximize the score difference, and Bob's goal is to minimize the score difference.

Given an integer array `stones` of length `n` where `stones[i]` represents the value of the `ith` stone from the left, return the score difference between Alice and Bob if they both play optimally.

## Examples

### Example 1
```
Input: stones = [-1,2,-3,4,-5]
Output: 5
Explanation: Alice removes the first 4 stones (sum 2), leaving [2,-5]. Bob removes both
(sum -3). The difference is 2 - (-3) = 5.
```

### Example 2
```
Input: stones = [7,-6,5,10,5,-2,-6]
Output: 13
Explanation: Alice removes all stones for a score of 13; Bob scores nothing.
```

### Example 3
```
Input: stones = [-10,-12]
Output: -22
Explanation: Alice's only move is to remove both stones, scoring -22.
```

## Constraints

- `n == stones.length`
- `2 <= n <= 10^5`
- `-10^4 <= stones[i] <= 10^4`
