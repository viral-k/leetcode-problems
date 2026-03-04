# Approach

**Tags:** `Array`, `Greedy`, `Sorting`, `Counting Sort`

## Intuition

To maximize count, buy cheapest items first. Use counting sort to efficiently process items by cost in ascending order without explicit sorting.

## Solution

1. **Build frequency array**: Count how many ice creams exist at each price point.

2. **Iterate from cheapest**: Process costs from 1 to maxCost.

3. **Buy greedily**:
   - If we can afford all items at current cost: buy all, subtract total cost
   - If we can't afford all: buy as many as possible (`coins / cost`), then stop

4. **Return count**: Total number of ice creams purchased.

### Why Counting Sort?

- Problem explicitly requires counting sort
- Efficient when cost range is bounded: O(n + maxCost)
- Avoids O(n log n) comparison sort

## Complexity

- **Time:** O(n + m) where n = number of items, m = max cost
- **Space:** O(m) — frequency array

## Edge Cases

- Can't afford any → return 0
- Can afford all → return n
- Large coins value → use `long` in Java to prevent overflow on `cost * frequency`
