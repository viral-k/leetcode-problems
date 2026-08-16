# Stone Game IX

**Difficulty:** Medium  
**LeetCode Link:** [Stone Game IX](https://leetcode.com/problems/stone-game-ix/)

## Description

Alice and Bob continue their games with stones. There is a row of `n` stones, and each stone has an associated value. You are given an integer array `stones`, where `stones[i]` is the value of the `ith` stone.

Alice and Bob take turns, with Alice starting first. On each turn, the player may remove any stone from `stones`. The player who removes a stone loses if the sum of the values of all removed stones is divisible by `3`. Bob will win automatically if there are no remaining stones (even if it is Alice's turn).

Assuming both players play optimally, return `true` if Alice wins and `false` if Bob wins.

## Examples

### Example 1
```
Input: stones = [2,1]
Output: true
Explanation: Alice removes either stone; Bob removes the remaining one, making the sum 3
(divisible by 3), so Bob loses.
```

### Example 2
```
Input: stones = [2]
Output: false
Explanation: Alice removes the only stone (sum 2, not divisible by 3). No stones remain,
so Bob wins automatically.
```

### Example 3
```
Input: stones = [5,1,2,4,3]
Output: false
Explanation: Bob can always force Alice into a losing move.
```

## Constraints

- `1 <= stones.length <= 10^5`
- `1 <= stones[i] <= 10^4`
