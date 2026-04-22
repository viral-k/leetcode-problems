# Approach

**Tags:** `Array`, `String`

## Intuition

Given small constraints (≤100 for all dimensions), brute force comparison works. For each query, check if any dictionary word differs by at most 2 characters.

## Solution

```python
def matches(q, d):
    diff = sum(c1 != c2 for c1, c2 in zip(q, d))
    return diff <= 2

result = []
for query in queries:
    if any(matches(query, word) for word in dictionary):
        result.append(query)
```

### Optimization

Early termination: stop counting differences once we exceed 2.

```python
def matches(q, d):
    diff = 0
    for c1, c2 in zip(q, d):
        if c1 != c2:
            diff += 1
            if diff > 2:
                return False
    return True
```

## Complexity

- **Time:** O(Q × D × N) where Q = queries, D = dictionary, N = word length
- **Space:** O(1) extra (excluding output)

## Edge Cases

- Exact match (0 edits)
- All queries match
- No queries match
- Single character words
