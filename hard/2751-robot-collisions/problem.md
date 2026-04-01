# Robot Collisions

**Difficulty:** Hard  
**LeetCode Link:** [Robot Collisions](https://leetcode.com/problems/robot-collisions/)

## Description

There are `n` robots on a line, each having:
- A position
- A health value
- A direction (`'L'` for left or `'R'` for right)

All robots move simultaneously at the same speed.

### Collision Rules

When two robots collide:
- The robot with **smaller health** is removed
- The other robot **loses 1 health** and continues
- If both have **equal health** → both are removed

Return the health of surviving robots **in original input order**.

## Examples

### Example 1
```
Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
Output: [2,17,9,15,10]
Explanation: All robots move in the same direction → no collisions.
```

### Example 2
```
Input: positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
Output: [14]
Explanation: Collisions reduce all but one robot.
```

### Example 3
```
Input: positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
Output: []
Explanation: All robots are destroyed in collisions.
```

## Constraints

- `1 <= positions.length <= 10^5`
- `positions.length == healths.length == directions.length`
- `1 <= positions[i], healths[i] <= 10^9`
- `directions[i]` is either `'L'` or `'R'`
- All values in `positions` are distinct
