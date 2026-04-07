# Walking Robot Simulation II

**Difficulty:** Medium  
**LeetCode Link:** [Walking Robot Simulation II](https://leetcode.com/problems/walking-robot-simulation-ii/)

## Description

A `width x height` grid is on an XY-plane with the bottom-left cell at `(0, 0)` and the top-right cell at `(width - 1, height - 1)`. The grid is aligned with the four cardinal directions ("North", "East", "South", and "West"). A robot is initially at cell `(0, 0)` facing direction "East".

The robot can be instructed to move for a specific number of steps. For each step, it does the following:

1. Attempts to move forward one cell in the direction it is facing
2. If the cell the robot is moving to is out of bounds, the robot instead turns 90 degrees counterclockwise and retries the step

After the robot finishes moving the number of steps required, it stops and awaits the next instruction.

Implement the `Robot` class:

- `Robot(int width, int height)` — Initializes the grid with the robot at `(0, 0)` facing "East"
- `void step(int num)` — Instructs the robot to move forward `num` steps
- `int[] getPos()` — Returns the current cell `[x, y]`
- `String getDir()` — Returns the current direction: "North", "East", "South", or "West"

## Examples

### Example 1
```
Input:
["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"]
[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]

Output:
[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
```

## Constraints

- `2 <= width, height <= 100`
- `1 <= num <= 10^5`
- At most `10^4` calls in total will be made to `step`, `getPos`, and `getDir`
