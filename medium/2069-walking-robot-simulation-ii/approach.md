# Approach

**Tags:** `Design`, `Simulation`

## Intuition

The robot only walks along the perimeter of the grid. Use modular arithmetic to handle large step counts efficiently, then convert the perimeter index to coordinates and direction.

## Solution

### Key Insight: Perimeter Walking

The robot traces the perimeter:
```
Bottom edge: (0,0) → (w-1,0)      [East]
Right edge:  (w-1,0) → (w-1,h-1)  [North]
Top edge:    (w-1,h-1) → (0,h-1)  [West]
Left edge:   (0,h-1) → (0,0)      [South]
```

Perimeter length = `2 * (width + height - 2)`

### Step Optimization

Instead of simulating each step:
1. Track position as index along perimeter
2. `index = (index + num) % perimeter`
3. Convert index back to (x, y) and direction

### Index to Position Conversion

Given perimeter index `i`:
- `i < width`: Bottom edge → `(i, 0)`, East
- `i < width + height - 1`: Right edge → `(width-1, i - width + 1)`, North
- `i < 2*width + height - 2`: Top edge → `(2*width + height - 3 - i, height-1)`, West
- Otherwise: Left edge → `(0, perimeter - i)`, South

### Edge Case: Origin After Full Cycle

When robot returns to `(0, 0)` after moving (not initially), it faces "South" (came from left edge), not "East".

## Complexity

- **Time:** O(1) per operation
- **Space:** O(1)

## Edge Cases

- Large num values → use modulo
- Robot at corner → direction based on edge it's on
- Multiple full perimeter cycles
