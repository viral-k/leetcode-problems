# Approach

**Tags:** `Array`, `Hash Table`, `Simulation`

## Intuition

Simulate the robot's movement step by step. Use direction vectors and a set for O(1) obstacle lookup. Track maximum squared distance after each step.

## Solution

### Direction Handling

Use direction vectors in order: North, East, South, West
```
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
           =  North   East    South    West
```

- Turn right: `dir = (dir + 1) % 4`
- Turn left: `dir = (dir + 3) % 4` (or `(dir - 1 + 4) % 4`)

### Obstacle Set

Convert obstacles to a set of tuples for O(1) lookup:
```
obstacle_set = {(x, y) for x, y in obstacles}
```

### Movement

For each move command k:
1. Move one step at a time (k times)
2. Check if next position is an obstacle
3. If blocked, stop moving for this command
4. Update max squared distance after each step

### Why Step One at a Time?

We can't jump k units — obstacles might block partway through.

## Complexity

- **Time:** O(n + m) where n = total steps, m = obstacles
- **Space:** O(m) for obstacle set

## Edge Cases

- Obstacle at origin `(0, 0)`
- No obstacles
- All turns, no movement
- Blocked immediately
