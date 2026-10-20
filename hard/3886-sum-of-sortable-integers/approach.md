# Approach

**Tags:** `Array`, `Math`, `Sorting`, `Enumeration`

## Intuition

A cyclic rotation permutes a block, so the multiset of values inside each block
never changes. That fixes the destination: a sortable `k` ends with an array
that is non-decreasing and has the same multiset as `nums`, so the result can
only be `sorted(nums)`. Block `i` therefore has to land exactly on
`sorted(nums)[i*k : (i+1)*k]`.

So `k` is sortable if and only if, for every block:

1. the block's multiset equals the matching segment of the sorted array, and
2. the block can be rotated into non-decreasing order.

Condition 1 is necessary because no rotation can change which values sit in the
block. Given condition 1, rotating the block into sorted order puts it exactly
on the required segment, because that segment is a contiguous piece of a sorted
array and is thus the sorted form of its own multiset. Together the two are
sufficient, and each reduces to an O(1) test after linear preprocessing.

**Condition 1 as a prefix test.** Requiring the block multisets to match the
sorted segments is the same as requiring the first `j*k` elements of `nums` to
be the `j*k` smallest, for every `j`. And a prefix of length `m` is the `m`
smallest exactly when `max(nums[:m]) <= min(nums[m:])`: if every prefix element
is at most every suffix element the prefix must be the `m` smallest, and if the
prefix is the `m` smallest the inequality follows. One prefix-max sweep and one
suffix-min sweep mark every cut position as a breakpoint or not.

**Condition 2 as a descent count.** A sequence of length `k` can be rotated into
non-decreasing order if and only if it has at most one *cyclic descent*, meaning
at most one `i` with `B[i] > B[(i+1) mod k]`. If the rotation starting at `s` is
sorted then the only descent can be at the wrap position `s-1`. Conversely, with
exactly one descent at `p`, rotating to start at `p+1` leaves no descent at all;
with zero descents every element is at most the next one cyclically, forcing all
of them equal, so any rotation is sorted. Internal descents over a range come
from a prefix sum of the adjacent-descent indicator, and the wrap-around is one
comparison, so a block costs O(1).

## Approach

1. `suf_min[m] = min(nums[m:])`, with `suf_min[n] = infinity`.
2. Sweep a running prefix maximum to fill `breakpoint[m] = run_max <= suf_min[m]`
   for `m = 1..n`. `breakpoint[n]` is always true.
3. `desc[i]` = number of `j` in `1..i` with `nums[j-1] > nums[j]`, as a prefix
   sum. Internal descents strictly inside `[l, r)` are `desc[r-1] - desc[l]`.
4. Enumerate the divisors of `n` by trial division up to `sqrt(n)`.
5. For each divisor `k`, walk the blocks `[l, l+k)`. Reject `k` as soon as a
   block fails `breakpoint[r]`, or its cyclic descent count
   `desc[r-1] - desc[l] + (nums[r-1] > nums[l])` exceeds 1.
6. Sum the surviving divisors.

## Complexity

- **Time:** O(n + sigma(n)), where sigma(n) is the sum of divisors. The
  per-divisor loop runs `n/k` times and `sum over k|n of n/k = sigma(n)`, which
  peaks near 4 * 10^5 for `n <= 10^5` (sigma(98280) = 403200). Divisor
  enumeration is O(sqrt(n)).
- **Space:** O(n)

The naive check for condition 2 searches the target segment inside
`block + block` with KMP, costing O(n) per divisor and O(n * d(n)) overall,
about 1.3 * 10^7 for the worst `n`. Counting descents gives the same answer in
constant time per block.

## Edge Cases

- `k = 1` needs no special case: one-element blocks have zero cyclic descents,
  so `k = 1` survives exactly when every cut is a breakpoint, which means `nums`
  is already sorted
- `k = n` is a single block, so only the descent count matters; the breakpoint at
  `n` is free
- Already sorted input → every divisor is sortable and the answer is sigma(n),
  as in example 3 where `n = 2` gives `1 + 2 = 3`
- A strictly increasing block has exactly one cyclic descent, at the wrap, which
  is why the bound is 1 rather than 0
- A constant block has zero cyclic descents and any rotation sorts it
- `n = 1` → the only divisor is 1, the array is trivially sorted, answer 1
- Duplicates are handled throughout: the prefix test uses `<=`, and the descent
  test uses strict `>`, so equal neighbours never count as a descent
- Blocks whose contents are individually rotatable but sit in the wrong part of
  the array are caught by the breakpoint test, e.g. `[3,4,1,2]` with `k = 2`
  passes the descent test on both blocks but fails `breakpoint[2]`
- The answer is at most sigma(n) < 4 * 10^5, so it fits an `int`
