# Approach

**Tags:** `Array`, `Prefix Sum`

## Intuition

Removing index `i` shifts every element after `i` one position left, which **flips its parity** (even index ↔ odd index). Elements before `i` keep their parity. So the fairness of the resulting array depends only on four running sums: even/odd sums of the prefix (before `i`) and even/odd sums of the suffix (after `i`) — with the suffix contributions swapped because of the parity flip.

## Approach

1. Compute total even-index sum and odd-index sum of the whole array.
2. Sweep `i` from left to right, maintaining `preEven`, `preOdd` = even/odd sums strictly before `i`.
3. The suffix sums after `i` are `sufEven = totalEven - preEven - (nums[i] if i even)` and likewise for odd — i.e. remove the prefix and `nums[i]` itself from the totals.
4. After removal, the new sums are:
   - `newEven = preEven + sufOdd` (suffix parity flips)
   - `newOdd  = preOdd + sufEven`
   Count `i` where `newEven == newOdd`.
5. Update the running prefix with `nums[i]` before moving on.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Single element → removing it leaves an empty (fair) array → count 1
- All equal values (Example 2) → every removal is fair
- Sums up to ~10^9 fit in 32-bit, but `long` in Java is safe
- `nums[i]` itself must be excluded from both prefix and suffix at index `i`
