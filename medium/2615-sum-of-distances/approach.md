# Approach

**Tags:** `Array`, `Hash Table`, `Prefix Sum`

## Intuition

Group indices by value. For each group, use prefix sums to efficiently calculate the sum of distances for each index.

## Solution

For sorted indices `[i0, i1, ..., ik]` of the same value, at position `j`:
- **Left contribution:** `j * indices[j] - prefix_sum[j]`
- **Right contribution:** `(total_sum - prefix_sum[j+1]) - (count - j - 1) * indices[j]`

```python
# Group indices by value
groups = defaultdict(list)
for i, num in enumerate(nums):
    groups[num].append(i)

# For each group, calculate distances using prefix sum
for indices in groups.values():
    prefix = [0]
    for idx in indices:
        prefix.append(prefix[-1] + idx)
    
    n = len(indices)
    for j, idx in enumerate(indices):
        left = idx * j - prefix[j]
        right = (prefix[n] - prefix[j + 1]) - idx * (n - j - 1)
        arr[idx] = left + right
```

## Why This Works

For index at position `j` in sorted group:
- Left side: `(idx - i0) + (idx - i1) + ... + (idx - i_{j-1})`
  = `j * idx - (i0 + i1 + ... + i_{j-1})` = `j * idx - prefix[j]`
- Right side: `(i_{j+1} - idx) + ... + (ik - idx)`
  = `(sum of right) - (count of right) * idx`

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Edge Cases

- All distinct elements → all zeros
- All same elements → calculate full distances
- Single element → zero
