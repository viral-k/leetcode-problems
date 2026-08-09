# Stone Game V

**Difficulty:** Hard  
**LeetCode Link:** [Stone Game V](https://leetcode.com/problems/stone-game-v/)

## Description

There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array `stoneValue`.

In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.

The game ends when there is only one stone remaining. Alice's score is initially zero.

Return the maximum score that Alice can obtain.

## Examples

### Example 1
```
Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: Split [6,2,3] | [4,5,5] -> keep 11. Then [6] | [2,3] -> keep 5 (total 16).
Then [2] | [3] -> keep 2 (total 18).
```

### Example 2
```
Input: stoneValue = [7,7,7,7,7,7,7]
Output: 28
```

### Example 3
```
Input: stoneValue = [4]
Output: 0
```

## Constraints

- `1 <= stoneValue.length <= 500`
- `1 <= stoneValue[i] <= 10^6`
