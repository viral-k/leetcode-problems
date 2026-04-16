# Approach

**Tags:** `Array`, `Hash Table`

## Intuition

Precompute the minimum distance to a same-value element for every index. Then queries are O(1) lookups.

## Solution

### Step 1: Group Indices by Value

```python
indices = defaultdict(list)
for i, num in enumerate(nums):
    indices[num].append(i)
```

### Step 2: Precompute Minimum Distances

For each value with 2+ occurrences:
- Indices are sorted (we add them in order)
- For each index, check distance to previous and next (circular)
- Store minimum in `min_dist[i]`

```python
for idx_list in indices.values():
    if len(idx_list) < 2:
        continue  # no same-value neighbor
    
    for k, i in enumerate(idx_list):
        prev = idx_list[k - 1]  # wraps around in Python
        nxt = idx_list[(k + 1) % len(idx_list)]
        
        dist_prev = min((i - prev) % n, (prev - i) % n)
        dist_next = min((nxt - i) % n, (i - nxt) % n)
        min_dist[i] = min(dist_prev, dist_next)
```

### Step 3: Answer Queries

```python
return [min_dist[q] for q in queries]
```

## Complexity

- **Time:** O(n + q) — precompute O(n), queries O(q)
- **Space:** O(n)

## Edge Cases

- Unique values → all -1
- All same value → check prev and next neighbors
- Two occurrences of a value → both point to each other
