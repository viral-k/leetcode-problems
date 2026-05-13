# Approach

**Tags:** `Array`, `Prefix Sum`

## Intuition

For each mirrored pair `(a, b)`, every target sum from `2` to `2 * limit` has a cost:

- `0` moves if the target is `a + b`
- `1` move if changing one value can reach the target
- `2` moves otherwise

The one-move range is:

`1 + min(a, b)` through `limit + max(a, b)`

So we can use a difference array over possible sums and add each pair's cost contribution as ranges.

## Approach

For each pair `(a, b)`:

1. Start with cost `2` for all possible sums.
2. Subtract `1` over the one-move range:
   - `[1 + min(a, b), limit + max(a, b)]`
3. Subtract another `1` at the exact current sum:
   - `[a + b, a + b]`

After processing all pairs, prefix-sum the difference array. The minimum value over sums `2..2 * limit` is the answer.

## Complexity

- **Time:** O(n + limit)
- **Space:** O(limit)

## Edge Cases

- Already complementary -> some target sum has cost `0`
- `limit` is small -> valid sums are still only `2..2 * limit`
- Duplicate pair sums -> exact-sum zero-move updates accumulate
