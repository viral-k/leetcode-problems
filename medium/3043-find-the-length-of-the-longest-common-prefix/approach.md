# Approach

**Tags:** `Array`, `Hash Table`

## Intuition

For any number, repeatedly removing its last digit gives all of its prefixes from longest to shortest.

If we store every prefix that appears in `arr1`, then for each value in `arr2` we can remove digits from the right until we find the longest prefix that also appears in `arr1`.

## Approach

1. Create a set `prefixes`.
2. For every number in `arr1`, add the number and every value formed by repeatedly dividing it by `10`.
3. For every number in `arr2`:
   - start from the full number
   - if it exists in `prefixes`, update the answer with its digit length and stop checking that number
   - otherwise divide by `10` and continue
4. Return the maximum length found.

## Complexity

Let `D` be the maximum number of digits in any value.

- **Time:** O((n + m) * D)
- **Space:** O(n * D)

Since values are at most `10^8`, `D` is at most `9`.

## Edge Cases

- No common leading digit -> return `0`
- A full number from `arr2` is a prefix from `arr1`
- Common prefix has trailing zeros, such as `100`
- Multiple values share prefixes -> the set naturally deduplicates them
