# Approach

**Tags:** `Math`, `Geometry`

## Intuition

Total area covered = Area of rectangle A + Area of rectangle B - Overlapping area (to avoid double counting).

## Solution

1. **Calculate individual areas**: Compute area of each rectangle using `width × height`.

2. **Find intersection bounds**:
   - `left = max(ax1, bx1)`
   - `right = min(ax2, bx2)`
   - `bottom = max(ay1, by1)`
   - `top = min(ay2, by2)`

3. **Calculate intersection area**: 
   - If `right > left` and `top > bottom`, intersection exists
   - Intersection area = `(right - left) × (top - bottom)`
   - Otherwise, intersection area = 0

4. **Return total**: `areaA + areaB - intersectionArea`

## Complexity

- **Time:** O(1) — constant arithmetic operations
- **Space:** O(1) — no extra space

## Edge Cases

- Rectangles don't overlap → intersection area is 0
- One rectangle inside another → intersection is the smaller rectangle
- Rectangles are identical → result is area of one rectangle
- Rectangles touch at edge/corner → intersection area is 0 (no overlap)
