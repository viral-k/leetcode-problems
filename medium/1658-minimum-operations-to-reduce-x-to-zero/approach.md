# Approach

**Tags:** `Array`, `Hash Table`, `Binary Search`, `Sliding Window`, `Prefix Sum`

## Intuition

The elements removed are always some prefix plus some disjoint suffix, and their order does not matter to the total. So the question is which prefix/suffix pair sums to `x`, and among those, which uses the fewest elements. What is left behind is a contiguous middle subarray summing to `total - x`. Fewest removals means longest middle, so the problem flips into: find the longest subarray with sum exactly `total - x`.

All values are at least 1, which makes prefix sums strictly increasing and a two-pointer window valid: for each right end there is exactly one left end where the window sum drops to or below the target, and sliding never needs to go back.

## Approach

1. `target = sum(nums) - x`. If `target < 0`, return -1 (even removing everything undershoots).
2. Slide a window: add `nums[right]`, shrink from the left while the sum exceeds `target`.
3. On equality, record `best = max(best, right - left + 1)`.
4. Return `-1` if no window matched, else `n - best`.

`target == 0` matches the empty window, which the loop captures with `best = 0` (initialised to 0 and only overwritten by longer matches), giving the answer `n`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- `x` greater than the total sum → `target < 0` → -1 (Example 2 has total 35 but no prefix/suffix hitting 4)
- `x` equal to the total sum → `target = 0`, answer `n`
- No subarray hits the target even though `target >= 0` → -1
- Single element: `x == nums[0]` → 1, otherwise -1
- Sums up to `10^5 * 10^4 = 10^9` fit in `int`, but Java uses `long` for the running window to stay clear of the `x <= 10^9` subtraction
- The best middle subarray may be empty (remove all) or the entire array minus nothing (impossible since `x >= 1`)
