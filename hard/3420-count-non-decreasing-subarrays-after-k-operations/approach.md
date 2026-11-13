# Approach

**Tags:** `Array`, `Stack`, `Segment Tree`, `Sliding Window`, `Monotonic Stack`

## Intuition

Operations only increase values, so the cheapest way to make a subarray non-decreasing is to raise each element to the largest value before it. The cost of `nums[l..r]` is `Σ (max(nums[l..i]) - nums[i])` for `i` in `l..r`.

That cost only grows when the window extends to the right, and only shrinks when an element is dropped from the left (prefix maxes can only go down). So for each left end, the valid right ends form a prefix `l..R(l)`, and `R(l)` never increases as `l` moves left. That is a two-pointer setup.

The catch is updating the cost. Dropping the leftmost element changes the prefix max of a whole stretch after it, which is hard to undo. Adding an element on the left is easy, though: `nums[l]` becomes the prefix max of everything up to the next element bigger than it. So sweep `l` from right to left and only ever add on the left and remove on the right.

## Approach

1. Keep the window `nums[l..r]` as a deque of blocks `(value, count)`. Each block is a run of elements whose prefix max is `value`, and values increase from front to back. This is a monotonic stack of prefix maxima with run lengths attached.
2. For `l` from `n - 1` down to `0`:
   - **Add `nums[l]` on the left.** Pop every front block with `value <= nums[l]`. Its elements now have prefix max `nums[l]`, so add `(nums[l] - value) * count` to the cost. Push one block `(nums[l], 1 + popped counts)`.
   - **Shrink from the right while `cost > k`.** `nums[r]` belongs to the back block, and its contribution is `value - nums[r]`. Subtract that, decrement the back block's count (pop it at zero), and `r -= 1`.
   - **Count.** Every right end in `l..r` works, so add `r - l + 1`.
3. `r` never drops below `l`, because a single element costs 0 and `k >= 1`.

## Complexity

- **Time:** O(n). Each index is pushed once, merged away at most once, and removed from the right at most once.
- **Space:** O(n) for the blocks

## Edge Cases

- Already non-decreasing: the cost stays 0 and every subarray counts, `n(n+1)/2`
- One huge element followed by small ones (`[10, 1, 1, 1]` with `k = 1`): the cost grows by about `10^9` per element, so the window shrinks to `[10, 1]` and then `[10]`
- Equal values: popping uses `<=`, so equal neighbours merge into one block and add 0 to the cost
- The answer can reach about `n^2 / 2 ≈ 5 * 10^9`, so it needs `long`
- The cost before shrinking can reach about `10^5 * 10^9 = 10^14`, so the cost needs `long` too. In Java, `val` is a `long[]` so `(nums[l] - val[head]) * cnt[head]` is computed in 64 bits
