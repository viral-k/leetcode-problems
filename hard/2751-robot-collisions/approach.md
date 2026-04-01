# Approach

**Tags:** `Array`, `Stack`, `Sorting`, `Simulation`

## Intuition

Similar to asteroid collision problems. Robots only collide when one moves right (`'R'`) and another moves left (`'L'`). Use a stack to track right-moving robots and simulate collisions when a left-moving robot appears.

## Solution

### Step 1: Sort by Position

Collisions depend on spatial order, so sort robots by position while keeping track of original indices.

### Step 2: Use Stack for Right-Moving Robots

- Push indices of `'R'` robots onto stack
- When encountering an `'L'` robot, check for collisions with stack top

### Step 3: Collision Simulation

While stack is not empty and current `'L'` robot is alive:

**Case 1:** Right robot health < Left robot health
- Right robot removed (pop stack, set health to 0)
- Left robot health -= 1
- Continue checking next right robot

**Case 2:** Right robot health > Left robot health
- Left robot removed (set health to 0)
- Right robot health -= 1
- Stop (left robot is gone)

**Case 3:** Equal health
- Both removed (pop stack, both healths to 0)
- Stop

### Step 4: Collect Survivors

Iterate through original order and collect robots with health > 0.

## Complexity

- **Time:** O(n log n) — sorting dominates; each robot pushed/popped at most once
- **Space:** O(n) — stack and sorting

## Edge Cases

- All same direction → no collisions
- All collide → empty result
- Single robot → return its health
- Alternating R-L pattern → chain collisions
