# Predict the Winner

**Difficulty:** Medium  
**LeetCode Link:** [Predict the Winner](https://leetcode.com/problems/predict-the-winner/)

## Description

You are given an integer array `nums`. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of `0`. At each turn, the player takes one of the numbers from either end of the array (i.e., `nums[0]` or `nums[nums.length - 1]`) which reduces the size of the array by `1`. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

Return `true` if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return `true`. You may assume that both players are playing optimally.

## Examples

### Example 1
```
Input: nums = [1,5,2]
Output: false
Explanation: Player 1 can score at most 3 (1+2), player 2 scores 5. Player 1 cannot win.
```

### Example 2
```
Input: nums = [1,5,233,7]
Output: true
Explanation: Player 1 takes 1, then can always take 233; final 234 vs 12.
```

## Constraints

- `1 <= nums.length <= 20`
- `0 <= nums[i] <= 10^7`
