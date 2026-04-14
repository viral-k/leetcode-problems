# Minimum Total Distance Traveled

**Difficulty:** Hard  
**LeetCode Link:** [Minimum Total Distance Traveled](https://leetcode.com/problems/minimum-total-distance-traveled/)

## Description

There are some robots and factories on the X-axis. You are given an integer array `robot` where `robot[i]` is the position of the ith robot. You are also given a 2D integer array `factory` where `factory[j] = [positionj, limitj]` indicates that `positionj` is the position of the jth factory and that the jth factory can repair at most `limitj` robots.

The positions of each robot are **unique**. The positions of each factory are also **unique**.

All the robots are initially broken; they keep moving in one direction. When a robot reaches a factory that did not reach its limit, the factory repairs the robot, and it stops moving.

Your target is to **minimize the total distance** traveled by all the robots.

Return the minimum total distance traveled by all the robots.

### Notes

- All robots move at the same speed
- Robots do not collide
- If a robot passes by a factory that reached its limits, it crosses it as if it does not exist
- Distance moved from x to y is `|y - x|`

## Examples

### Example 1
```
Input: robot = [0,4,6], factory = [[2,2],[6,2]]
Output: 4
Explanation:
- Robot at 0 → factory at 2: distance = 2
- Robot at 4 → factory at 2: distance = 2
- Robot at 6 → factory at 6: distance = 0
Total = 4
```

### Example 2
```
Input: robot = [1,-1], factory = [[-2,1],[2,1]]
Output: 2
Explanation:
- Robot at 1 → factory at 2: distance = 1
- Robot at -1 → factory at -2: distance = 1
Total = 2
```

## Constraints

- `1 <= robot.length, factory.length <= 100`
- `factory[j].length == 2`
- `-10^9 <= robot[i], positionj <= 10^9`
- `0 <= limitj <= robot.length`
- The input is generated such that all robots can be repaired
