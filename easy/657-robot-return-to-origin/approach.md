# Approach

**Tags:** `String`, `Simulation`

## Intuition

Track x and y coordinates. The robot returns to origin if and only if the net displacement is zero in both directions.

## Solution

1. Initialize `x = 0, y = 0`
2. For each move:
   - `'U'` → `y++`
   - `'D'` → `y--`
   - `'R'` → `x++`
   - `'L'` → `x--`
3. Return `x == 0 && y == 0`

**Alternative:** Count characters
- Return `count('U') == count('D') && count('L') == count('R')`

## Complexity

- **Time:** O(n) — single pass through moves
- **Space:** O(1) — only two variables

## Edge Cases

- Empty moves → true (already at origin)
- All same direction → false
- Alternating UD or LR → true
