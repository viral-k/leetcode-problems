# Approach

**Tags:** `Array`, `Graph`, `Prefix Maximum`, `Suffix Minimum`

## Intuition

For any pair `i < j`, jumps are possible in both directions exactly when `nums[i] > nums[j]`:

- from `i` to `j`, because `j > i` and `nums[j] < nums[i]`
- from `j` to `i`, because `i < j` and `nums[i] > nums[j]`

So indices connected through valid jumps are the connected components of the inversion graph.

A boundary between `i` and `i + 1` separates two components only if there is no inversion crossing it. That means every value on the left must be less than or equal to every value on the right:

`max(nums[0..i]) <= min(nums[i + 1..n - 1])`

If this condition is false, at least one inversion crosses the boundary, so both sides belong to the same reachable component.

## Approach

1. Build `suffix_min`, where `suffix_min[i]` is the minimum value from `i` to the end.
2. Scan from left to right while tracking:
   - `start`, the start index of the current component
   - `component_max`, the maximum value in the current component
3. At index `i`, the current component ends if:
   - `i` is the last index, or
   - `component_max <= suffix_min[i + 1]`
4. When a component ends, fill every answer in that component with `component_max`.

## Complexity

- **Time:** O(n) — one suffix pass and one scan
- **Space:** O(n) — for `suffix_min` and the answer array

## Edge Cases

- Strictly increasing array → no inversions, every index is its own component
- Strictly decreasing array → all indices are connected
- Duplicate values → equal values do not create jumps, so the split condition uses `<=`
