# Approach

**Tags:** `Array`, `Sorting`, `Greedy`

## Intuition

To maximize the square hole area, we need to find the maximum gap we can create by removing consecutive bars in both horizontal and vertical directions. The key insight is that removing consecutive bars creates a larger gap than removing scattered bars.

## Solution

1. **Find maximum consecutive sequence**: For both `hBars` and `vBars`, find the longest sequence of consecutive removable bars.

2. **Calculate gap size**: If we remove `k` consecutive bars, the resulting gap spans `k + 1` unit cells (the space between the bars before and after the removed section).

3. **Square constraint**: The side of the square is limited by the smaller of the two maximum gaps (horizontal and vertical).

4. **Return area**: Square the side length to get the maximum area.

### Algorithm

1. Sort both arrays
2. Find longest consecutive run in each array
3. Gap size = longest consecutive run + 1
4. Side = min(horizontal gap, vertical gap)
5. Area = side²

## Complexity

- **Time:** O(h log h + v log v) where h = len(hBars), v = len(vBars) — dominated by sorting
- **Space:** O(1) — only using constant extra space (excluding input sort)

## Edge Cases

- Single bar in hBars or vBars → gap is 2 (1 bar removed + 1)
- No consecutive bars → gap is 2 for each removed bar
- All bars consecutive → maximum possible gap
