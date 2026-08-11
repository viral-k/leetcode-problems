# Stone Game IV

**Difficulty:** Hard  
**LeetCode Link:** [Stone Game IV](https://leetcode.com/problems/stone-game-iv/)

## Description

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are `n` stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer `n`, return `true` if and only if Alice wins the game otherwise return `false`, assuming both players play optimally.

## Examples

### Example 1
```
Input: n = 1
Output: true
Explanation: Alice removes 1 stone; Bob has no moves.
```

### Example 2
```
Input: n = 2
Output: false
Explanation: Alice can only remove 1 stone, then Bob removes the last one (2 -> 1 -> 0).
```

### Example 3
```
Input: n = 4
Output: true
Explanation: n is a perfect square; Alice removes all 4 stones.
```

## Constraints

- `1 <= n <= 10^5`
