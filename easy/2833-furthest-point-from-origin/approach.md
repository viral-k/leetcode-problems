# Approach

**Tags:** `String`, `Greedy`

## Intuition

To maximize distance from origin, use all `'_'` moves in the same direction that extends the furthest.

## Solution

1. Count `L`, `R`, and `_` characters
2. Fixed displacement = `|L_count - R_count|`
3. Use all `_` to extend in the dominant direction

```python
return abs(L_count - R_count) + underscore_count
```

### Why This Works

- L's and R's have fixed directions, giving net displacement `|L - R|`
- All underscores should move in whichever direction is already dominant (or either if tied)
- This maximizes the absolute distance from origin

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- All underscores → distance = n
- No underscores → distance = |L - R|
- Equal L and R → distance = underscore_count
