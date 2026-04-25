# Approach

**Tags:** `Array`, `Binary Search`, `Greedy`

## Intuition

Key insight: For points on a square boundary, Manhattan distance equals the minimum of clockwise and counter-clockwise perimeter distances.

1. Map 2D boundary points to 1D perimeter positions
2. Binary search on the minimum distance
3. Greedy check: can we select k points with all consecutive gaps >= d?

## Solution

### Step 1: Map to Perimeter Positions

Traverse boundary clockwise from (0,0):
- Bottom (y=0): position = x
- Right (x=side): position = side + y
- Top (y=side): position = 2*side + (side - x)
- Left (x=0): position = 3*side + (side - y)

### Step 2: Binary Search + Greedy Check

For a candidate minimum distance `d`:
- Try each point as starting point
- Greedily select next point with gap >= d
- After selecting k points, verify wrap-around gap is also >= d

```python
def canAchieve(d):
    for start in range(n):
        count = 1
        last_idx = start
        
        for _ in range(k - 1):
            # Binary search for next valid position
            target = extended[last_idx] + d
            next_idx = bisect_left(extended, target, last_idx + 1, start + n)
            
            if next_idx >= start + n:
                break
            count += 1
            last_idx = next_idx
        
        if count == k:
            wrap_dist = extended[start + n] - extended[last_idx]
            if wrap_dist >= d:
                return True
    return False
```

## Complexity

- **Time:** O(n × k × log n × log(perimeter/k))
- **Space:** O(n)

## Edge Cases

- All points at corners
- Points evenly distributed
- k equals number of points
