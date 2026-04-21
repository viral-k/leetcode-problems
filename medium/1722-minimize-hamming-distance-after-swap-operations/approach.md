# Approach

**Tags:** `Array`, `Union Find`, `Hash Table`

## Intuition

If indices can swap (directly or transitively), elements at those indices can be freely rearranged. Use Union-Find to identify connected components of indices.

## Solution

1. **Union-Find**: Build connected components from allowedSwaps
2. **Group by component**: Collect source and target values for each component
3. **Match greedily**: For each component, count how many target values exist in source values

```python
# Union-Find to group swappable indices
for a, b in allowedSwaps:
    union(a, b)

# Group indices by root
groups = defaultdict(list)
for i in range(n):
    groups[find(i)].append(i)

# For each group, count unmatched positions
hamming = 0
for indices in groups.values():
    source_count = Counter(source[i] for i in indices)
    for i in indices:
        if source_count[target[i]] > 0:
            source_count[target[i]] -= 1
        else:
            hamming += 1
```

## Why This Works

- Connected indices form a group where any permutation is achievable
- For each group, we optimally match source values to target values
- Unmatched positions contribute to Hamming distance

## Complexity

- **Time:** O(n × α(n)) where α is inverse Ackermann (near-constant)
- **Space:** O(n)

## Edge Cases

- No allowed swaps → count mismatches directly
- All indices connected → full flexibility
- Duplicate values in arrays
