# Approach

**Tags:** `Array`, `Greedy`, `Sorting`, `Binary Search`

## Intuition

Each robot can fire left OR right. Bullets are blocked by adjacent robots. This creates intervals of reachable walls for each direction. Use interval scheduling to maximize unique walls destroyed.

## Solution

### Step 1: Sort Robots by Position

Sort robots by position to easily determine blocking by adjacent robots.

### Step 2: Generate Intervals

For each robot at position `p` with range `d`:

**Left shot:** `[max(p - d, prev_robot_pos), p]`
- Blocked by the robot immediately to the left

**Right shot:** `[p, min(p + d, next_robot_pos)]`
- Blocked by the robot immediately to the right

This gives 2n intervals total.

### Step 3: Greedy Interval Selection

Sort intervals by **right endpoint** (classic greedy for interval scheduling).

For each interval, use binary search to find walls in range `[L, R]` and mark them as destroyed (using a set to track used walls).

### Why Sort by Right Endpoint?

Intervals ending earlier leave more room for later intervals to cover remaining walls. This greedy approach maximizes coverage.

## Complexity

- **Time:** O(n log n + m log m + total walls hit)
  - Sorting robots and walls
  - Binary search for each interval
- **Space:** O(n + m) — intervals and used set

## Edge Cases

- Single robot → can only fire one direction
- All robots blocking each other → minimal or zero coverage
- Walls at robot positions → can be destroyed by that robot
- Large gaps between robots → full range available
