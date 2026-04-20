# Approach

**Tags:** `Array`, `Greedy`

## Intuition

To maximize distance, one endpoint must be either the first house (index 0) or the last house (index n-1). Check both scenarios.

## Solution

1. From house 0, find the furthest house with a different color (scan from end)
2. From house n-1, find the furthest house with a different color (scan from start)
3. Return the maximum of these two distances

```python
n = len(colors)
dist = 0

# Check from first house
for j in range(n - 1, -1, -1):
    if colors[j] != colors[0]:
        dist = max(dist, j)
        break

# Check from last house
for i in range(n):
    if colors[i] != colors[n - 1]:
        dist = max(dist, n - 1 - i)
        break
```

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Two houses with different colors
- All same color except endpoints
- Alternating colors
