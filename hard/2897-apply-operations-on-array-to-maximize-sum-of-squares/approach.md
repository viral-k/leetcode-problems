# Approach

**Tags:** `Array`, `Hash Table`, `Greedy`, `Bit Manipulation`

## Intuition

Look at the operation one bit position at a time. Replacing `(a, b)` with `(a AND b, a OR b)` maps that bit's pair of values as `(1,1) -> (1,1)`, `(1,0) -> (0,1)`, `(0,1) -> (0,1)`, `(0,0) -> (0,0)`. In every case the number of set bits in the pair is unchanged. So for each bit position, the total count across the whole array is invariant: no operation can create or destroy a bit, only relocate it.

What the operation can do is gather. Applying it to a pair pushes shared bits toward the second index, so bits can be concentrated into chosen elements. That turns the problem into: given `cnt[b]` copies of bit `b`, distribute them into `n` numbers (each number uses a bit at most once) and pick `k` of them to maximise the sum of squares.

Convexity settles the distribution. For a fixed total, `x^2` rewards imbalance: splitting a value into two smaller ones lowers the sum of squares, since `(x + y)^2 > x^2 + y^2` for positive `x, y`. So pack bits as densely as possible. Build the numbers greedily, each one taking a single copy of every bit still in stock. The first number is the largest value reachable at all, the next is the largest from the remainder, and so on, which is exactly the order that maximises any prefix of `k` squares.

## Approach

1. Count `cnt[b]` for each of the 30 bit positions (`nums[i] < 2^30`).
2. Repeat `k` times:
   - build `value` by setting every bit `b` with `cnt[b] > 0`, decrementing each as it is used
   - add `value * value` to the answer, modulo `10^9 + 7`
3. Return the answer.

The loop naturally yields 0 once the bits run out, which is correct: with `k` larger than the number of non-zero values available, the remaining picks contribute nothing.

## Complexity

- **Time:** O((n + k) * 30)
- **Space:** O(1), just the 30 counters

## Edge Cases

- `k = 1` → the single largest reachable value, which is the OR of all elements
- `k = n` → every element is chosen, and since the bit pool is fixed the greedy packing still maximises the total
- All elements equal → no bit is shared unevenly, and each built number equals that value until the counts run out
- Disjoint bit patterns (Example 1) → the first value collects every bit, giving 15 from `[2,6,5,8]`
- Elements can become 0 after operations, and values beyond the available bits are 0; squaring them adds nothing
- Overflow: a value reaches `2^30 - 1`, so its square is about `1.15 * 10^18`. That fits in a signed 64-bit integer but not a 32-bit one, so Java must use `long` before taking the modulus
- The modulus must be applied to the accumulated sum, not to the value before squaring, or the squares would be wrong
