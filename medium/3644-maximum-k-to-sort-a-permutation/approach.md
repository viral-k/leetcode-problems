# Approach

**Tags:** `Array`, `Bit Manipulation`

## Intuition

Let `S` be the set of misplaced values, `{nums[i] : nums[i] != i}`. Misplaced
positions in a permutation form cycles of length at least 2, so the values
sitting at misplaced positions are the same integers as those positions — `S` is
one well-defined set, usable as both. An empty `S` means the array is sorted and
the statement asks for 0.

**Upper bound.** Every misplaced value has to move, so it takes part in at least
one swap. A swap involving `v` requires `v AND u == k`, which forces every bit
of `k` to be present in `v`. So `k` is a submask of every `v` in `S`, hence a
submask of `AND(S)`. The largest integer that is a submask of `AND(S)` is
`AND(S)` itself, so no answer can exceed it.

**The bound is always attained.** Consider the value `k = AND(S)` as an element
of the array. It is there to be found: `k` is a submask of every element of `S`,
so `k <= min(S) <= n - 1`. And because `k` is a submask of every `v` in `S`,
`k AND v == k` for all of them — the element `k` can legally swap with *every*
misplaced element. It is a universal carrier.

This matters because elements of `S` often cannot swap with each other. With
`S = {3, 7}` and `k = 3 AND 7 = 3`, the pair gives `3 AND 7 = 3`, which happens
to work, but `S = {3, 5, 7}` has `k = 1` while `3 AND 7 = 3 != 1`. Pairing
elements up directly is not generally possible; routing everything through the
carrier is.

The carrier yields a two-swap-per-element construction, so the answer is exactly
the AND of the misplaced values.

Note why `k = 0` is never a dead end: `0 AND x == 0` for every `x`, so the value
`0` is a universal carrier whenever `k = 0`, and `0` is always present. That is
the base case that makes the answer well defined for any permutation.

## Approach

1. Walk the array once with an accumulator of all 1 bits.
2. For every `i` with `nums[i] != i`, AND `nums[i]` into the accumulator.
3. If nothing was ever ANDed in, the array was sorted — return 0. Otherwise
   return the accumulator.

The sorting procedure that justifies the value, using `k` as the carrier, places
value `t` at position `t` in two swaps:

- Swap the carrier into position `t`. Legal because `nums[t]` is displaced, and
  the only values that ever move are `k` and members of `S`, so `nums[t]` is in
  `S` and shares all of `k`'s bits.
- Swap position `t`, now holding `k`, with wherever value `t` sits. Legal
  because `t` is a displaced position, so `t` is in `S`.

Skip `t == k` in that loop and let the carrier settle last: once every other
position is correct, `k` has nowhere left to be but position `k`.

## Complexity

- **Time:** O(n) — a single pass
- **Space:** O(1)

## Edge Cases

- Already sorted → nothing is ANDed in, return 0 as the statement requires,
  not the all-ones accumulator
- `n = 1` → `[0]` is sorted, so 0
- Fully reversed, e.g. `[3,2,1,0]` → every value is misplaced and the AND
  includes 0, so the answer is 0
- Whenever `0` is misplaced the answer is 0, since `0` kills the accumulator
- A single transposition of `a` and `b` → the answer is `a AND b`, which is also
  exactly the condition for that one swap
- The accumulator must start as all ones rather than 0, and -1 works as that
  sentinel in both Python and Java; after the first AND with a non-negative
  value it can never be -1 again, so -1 unambiguously means "nothing misplaced"
- Values are bounded by `n - 1 <= 10^5 - 1 < 2^17`, so the result fits an `int`
  with room to spare
