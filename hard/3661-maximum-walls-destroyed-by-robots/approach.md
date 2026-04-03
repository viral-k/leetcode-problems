# Approach

**Tags:** `Array`, `Greedy`, `Sorting`, `Binary Search`, `Dynamic Programming`

## Intuition

Each robot can fire left OR right. Bullets are blocked by adjacent robots. Use DP to track the best outcome when each robot fires left vs right, accounting for overlapping wall coverage between adjacent robots.

## Solution

### Step 1: Sort Robots by Position

Sort robots by position to determine blocking by adjacent robots.

### Step 2: Compute Intervals for Each Robot

For each robot at position `p` with range `d`:

**Left shot interval:** `[max(p - d, prev_robot + 1), p]`
**Right shot interval:** `[p, min(p + d, next_robot - 1)]`

Use binary search to find wall indices within each interval.

### Step 3: Count Walls and Overlaps

- `left[i]` = walls destroyed if robot i fires left
- `right[i]` = walls destroyed if robot i fires right
- `overlap[i]` = walls in intersection of `right[i-1]` and `left[i]` intervals

Overlap matters because if robot i-1 fires right and robot i fires left, they may both cover the same walls (counted twice).

### Step 4: DP Transition

Track two states:
- `sub_left` = max walls if current robot fires left
- `sub_right` = max walls if current robot fires right

For each robot i:
```
current_left = max(sub_left + left[i], sub_right + left[i] - overlap[i])
current_right = max(sub_left + right[i], sub_right + right[i])
```

The overlap subtraction handles double-counting when adjacent robots' ranges intersect.

## Complexity

- **Time:** O(n log n + m log m) — sorting and binary search
- **Space:** O(n) — interval arrays and DP states

## Edge Cases

- Single robot → max of left or right shot
- No walls in range → return 0
- All robots blocking each other → minimal coverage
- Walls at robot positions → included in both left and right
