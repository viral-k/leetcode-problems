# Robot Return to Origin

**Difficulty:** Easy  
**LeetCode Link:** [Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)

## Description

There is a robot starting at position `(0, 0)` on a 2D plane.

You are given a string `moves` where:
- `'U'` → move up
- `'D'` → move down
- `'L'` → move left
- `'R'` → move right

Each move has equal magnitude.

Return `true` if the robot returns to the origin `(0, 0)` after all moves, otherwise return `false`.

## Examples

### Example 1
```
Input: moves = "UD"
Output: true
Explanation: Moves cancel out → back to origin.
```

### Example 2
```
Input: moves = "LL"
Output: false
Explanation: Robot ends at (-2, 0).
```

## Constraints

- `1 <= moves.length <= 2 * 10^4`
- `moves` only contains `'U'`, `'D'`, `'L'`, `'R'`
