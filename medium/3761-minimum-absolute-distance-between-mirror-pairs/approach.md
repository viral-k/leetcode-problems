# Approach

**Tags:** `Array`, `Hash Table`

## Intuition

For a mirror pair (i, j) with i < j, we need `reverse(nums[i]) == nums[j]`. Process right to left, tracking the smallest index for each value seen so far.

## Solution

### Reverse Function

```python
def reverse(x):
    return int(str(x)[::-1])
```

Note: `reverse(120) = 21` (leading zeros dropped).

### One-Pass Algorithm (Right to Left)

- Maintain map: `value -> smallest index seen`
- For each index i (going right to left):
  - Compute `target = reverse(nums[i])`
  - If `target` in map, we found a j > i with `nums[j] == reverse(nums[i])`
  - Update minimum distance: `map[target] - i`
  - Store `nums[i] -> i` in map (smallest index for this value)

### Why Right to Left?

We want the smallest j > i. By going right to left and storing the smallest index seen for each value, when we process i, the map contains the smallest j > i for any value.

## Complexity

- **Time:** O(n × d) where d = max digits ≈ 10
- **Space:** O(n)

## Edge Cases

- No mirror pairs → return -1
- Palindrome numbers (reverse = self) need i < j with same value
- Numbers with trailing zeros (120 → 21)
