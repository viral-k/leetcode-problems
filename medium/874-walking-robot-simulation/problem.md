# Walking Robot Simulation

**Difficulty:** Medium  
**LeetCode Link:** [Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/)

## Description

A robot on an infinite XY-plane starts at point `(0, 0)` facing **north**. The robot receives an array of integers `commands`, which represents a sequence of moves:

- `-2`: Turn left 90 degrees
- `-1`: Turn right 90 degrees
- `1 <= k <= 9`: Move forward `k` units, one unit at a time

Some grid squares are obstacles. The `ith` obstacle is at `obstacles[i] = (xi, yi)`. If the robot runs into an obstacle, it stays in its current location and moves onto the next command.

Return the **maximum squared Euclidean distance** that the robot reaches at any point in its path.

### Notes

- There can be an obstacle at `(0, 0)`. The robot will ignore it until it moves off the origin, but cannot return to `(0, 0)` due to the obstacle.
- North = +Y, East = +X, South = -Y, West = -X

## Examples

### Example 1
```
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: Robot moves to (0,4), turns right, moves to (3,4).
Max distance² = 3² + 4² = 25
```

### Example 2
```
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: Robot reaches (1,8) after being blocked by obstacle at (2,4).
Max distance² = 1² + 8² = 65
```

### Example 3
```
Input: commands = [6,-1,-1,6], obstacles = [[0,0]]
Output: 36
Explanation: Robot reaches (0,6) then gets blocked returning to origin.
Max distance² = 6² = 36
```

## Constraints

- `1 <= commands.length <= 10^4`
- `commands[i]` is `-2`, `-1`, or an integer in `[1, 9]`
- `0 <= obstacles.length <= 10^4`
- `-3 * 10^4 <= xi, yi <= 3 * 10^4`
- The answer is guaranteed to be less than `2^31`
