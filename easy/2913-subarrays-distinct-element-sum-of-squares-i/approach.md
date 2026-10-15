# Approach

**Tags:** `Array`, `Hash Table`

## Intuition

Recomputing the distinct count for each of the `O(n^2)` subarrays from scratch would be cubic. But the counts for subarrays sharing a left endpoint are related: extending `nums[i..j]` to `nums[i..j+1]` either introduces a value not yet in the window, raising the count by one, or repeats one already present and leaves it unchanged.

So fix the left endpoint, sweep the right endpoint rightward, and carry the distinct count along. Each extension is O(1), which makes the whole thing quadratic with a tiny constant.

Because `nums[i] <= 100`, membership is a direct array lookup rather than a hash set, so there is no hashing overhead and the inner loop is a couple of array accesses.

## Approach

1. `total = 0`.
2. For each start `i`:
   - reset a `seen` array of 101 booleans and `distinct = 0`
   - for each `j` from `i` to `n - 1`:
     - if `nums[j]` is unseen, mark it and increment `distinct`
     - add `distinct * distinct` to `total`
3. Return `total`.

## Complexity

- **Time:** O(n^2), about 5,050 inner steps at the limit
- **Space:** O(V) where `V = 100` is the value range

The hard version of this problem (2916) raises `n` to `10^5` and needs a segment tree with lazy propagation maintaining both the sum and the sum of squares of distinct counts over the left endpoints. That is the right tool there and the wrong one here: the constraints on this version admit the quadratic sweep directly, and the simpler code is easier to trust.

## Edge Cases

- Single element → 1, the only subarray has one distinct value
- All elements identical → every subarray has distinct count 1, so the answer is the number of subarrays, `n(n+1)/2` (Example 2 gives 3 for `n = 2`)
- All elements distinct → the count equals the subarray length, so the answer is `sum over L of (n - L + 1) * L^2`
- A repeat that does not raise the count (`[1,2,1]`, where `[1,2,1]` still has 2 distinct values) is what the `seen` check handles (Example 1)
- Resetting `seen` per start is required; carrying it over would merge windows
- Maximum answer at `n = 100` all distinct is about `8.4 * 10^6`, comfortably inside `int`
