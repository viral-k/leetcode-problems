# Approach

**Tags:** `Array`, `Math`, `Sorting`, `Matrix`

## Intuition

1. All elements must have the same remainder mod x (otherwise impossible)
2. Target value should be the **median** (minimizes sum of absolute differences)
3. Operations = Σ |element - median| / x

## Solution

### Why Median?

The median minimizes the sum of absolute deviations. Classic result from statistics.

For any value v, the total cost is Σ|arr[i] - v|. This is minimized when v = median.

### Algorithm

```python
# Flatten grid
arr = [val for row in grid for val in row]

# Check all have same remainder
if not all(val % x == arr[0] % x for val in arr):
    return -1

# Sort and find median
arr.sort()
median = arr[len(arr) // 2]

# Count operations
return sum(abs(val - median) // x for val in arr)
```

## Complexity

- **Time:** O(mn log(mn)) for sorting
- **Space:** O(mn) for flattened array

## Edge Cases

- Single element → 0 operations
- All elements equal → 0 operations
- Different remainders → impossible (-1)
