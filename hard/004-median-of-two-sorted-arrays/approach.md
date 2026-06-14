# Approach

**Tags:** `Array`, `Binary Search`, `Divide and Conquer`

## Intuition

The median splits the combined array into a left half and a right half of (almost) equal size, where every element on the left is `<=` every element on the right. We do not need to merge the arrays — we only need to find *where* to cut each one.

Fix how many elements come from `nums1` (call it `i`); then the count from `nums2` is forced: `j = half - i`, where `half` is the size of the combined left part. So there is really only one degree of freedom, and the cut is monotonic, which means we can binary search for it. Searching the *shorter* array keeps it `O(log(min(m, n)))`.

## Approach

1. Ensure `nums1` is the shorter array (swap if needed) so the binary search range is small.
2. Let `half = (m + n + 1) // 2` — the number of elements in the combined left half.
3. Binary search `i` in `[0, m]`; set `j = half - i`. Define the four boundary values:
   - `left1 = nums1[i-1]` (or `-inf` if `i == 0`), `right1 = nums1[i]` (or `+inf` if `i == m`)
   - `left2 = nums2[j-1]` (or `-inf` if `j == 0`), `right2 = nums2[j]` (or `+inf` if `j == n`)
4. The cut is correct when `left1 <= right2` and `left2 <= right1`:
   - odd total -> median is `max(left1, left2)`
   - even total -> median is `(max(left1, left2) + min(right1, right2)) / 2`
5. Otherwise adjust: if `left1 > right2`, we took too many from `nums1` (move `hi` left); else too few (move `lo` right).

The `±inf` sentinels let the empty-side cases fall through the same comparisons without special handling.

## Complexity

- **Time:** O(log(min(m, n))) — binary search over the shorter array
- **Space:** O(1)

## Edge Cases

- One array empty -> sentinels make it reduce to the median of the other
- Odd vs even combined length -> handled by the `(m + n) % 2` branch
- All elements of one array smaller than the other -> cut lands at an array boundary (`i == 0` or `i == m`)
- Duplicate values across the two arrays -> the `<=` comparisons keep the partition valid

## Note

A naive merge (or "find the kth element by walking") is `O(m + n)`; the binary-search partition is what achieves the required `O(log(m + n))`. A median-comparison "trim half each side" recursion is easy to get subtly wrong on even-length inputs, because the two middle elements straddle the median and must not be discarded.
