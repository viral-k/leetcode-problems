# Approach

**Tags:** `Array`, `String`

## Intuition

For each occurrence of target, compute the minimum of clockwise and counter-clockwise distances. Return the overall minimum.

## Solution

For a circular array of length `n`, the distance from `start` to index `i`:
- Clockwise: `(i - start + n) % n`
- Counter-clockwise: `(start - i + n) % n`
- Shortest: `min(clockwise, n - clockwise)`

```python
for i, word in enumerate(words):
    if word == target:
        clockwise = (i - startIndex + n) % n
        min_dist = min(min_dist, clockwise, n - clockwise)
```

## Complexity

- **Time:** O(n × m) where m = average word length (for string comparison)
- **Space:** O(1)

## Edge Cases

- Target not in array → return -1
- Target at startIndex → return 0
- Multiple occurrences of target → pick closest
- Single element array with target → return 0
