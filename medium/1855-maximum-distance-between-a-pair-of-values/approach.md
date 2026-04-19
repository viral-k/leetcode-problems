# Approach

**Tags:** `Array`, `Two Pointers`, `Binary Search`

## Intuition

Both arrays are sorted in descending order. Use two pointers: as nums1[i] decreases (increasing i), we can extend j further to find larger distances.

## Solution

### Two Pointers

```python
i, j = 0, 0
max_dist = 0

while i < n1 and j < n2:
    if nums1[i] <= nums2[j]:
        max_dist = max(max_dist, j - i)
        j += 1
    else:
        i += 1
```

### Why This Works

- If `nums1[i] <= nums2[j]`: valid pair, try to extend j for larger distance
- If `nums1[i] > nums2[j]`: need smaller nums1 value, so increment i
- Since arrays are non-increasing:
  - Moving i right → nums1[i] decreases → more likely to satisfy condition
  - Moving j right → nums2[j] decreases → condition may break

### Constraint i <= j

The algorithm naturally maintains i <= j because:
- When valid (i <= j maintained), we increment j
- When invalid and i increments past j, the condition will soon become valid again (or we exhaust arrays)

For safety, we can add: if i > j after incrementing i, skip.

## Complexity

- **Time:** O(n + m)
- **Space:** O(1)

## Edge Cases

- No valid pairs → return 0
- All pairs valid → return n2 - 1
- Single element arrays
