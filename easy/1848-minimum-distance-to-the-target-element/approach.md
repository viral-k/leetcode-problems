# Approach

**Tags:** `Array`

## Intuition

Simple linear scan to find the target value closest to the start index.

## Solution

Iterate through the array. For each index where `nums[i] == target`, compute `|i - start|` and track the minimum.

```python
min_dist = infinity
for i in range(len(nums)):
    if nums[i] == target:
        min_dist = min(min_dist, abs(i - start))
```

### Optimization (not needed for small n)

Could expand outward from `start` and return immediately when target is found, but linear scan is sufficient for n ≤ 1000.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Target at start index → return 0
- Single element array → return 0
- Multiple occurrences of target → pick closest
- Target only at one end
