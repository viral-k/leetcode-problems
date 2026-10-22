# Approach

**Tags:** `Array`

## Intuition

Rotating left and reversing generate the dihedral group. Rotation has order `n`,
reversal is its own inverse, and the two interact by
`reverse . rotate-left = rotate-right . reverse`. Everything reachable from
`nums` is therefore one of only `2n` arrays: the `n` rotations of `nums`, and the
`n` rotations of `reverse(nums)`. Any permutation outside that orbit is
unreachable, which is the whole story behind -1.

**Deciding reachability.** The target `[0, 1, ..., n-1]` has distinct values, so
a rotation matching it is pinned down by where `0` ends up. Let `p` be the index
of `0` in `nums`. Then `nums` is a rotation of the sorted array exactly when
reading cyclically *forward* from `p` yields `0, 1, ..., n-1`, and it is a
rotation of the reversed sorted array exactly when reading cyclically *backward*
from `p` does. Two O(n) scans settle it, and each case admits at most one `k`.

**Counting operations.** Write `L` for rotate-left and `R` for reverse. Using
`R L^m R = Rot^{-m}`, every word normalizes to `Rot^k` or `Rot^k . R`, and the
cheapest word for each is short:

- Reaching `Rot^k(nums)`, which is the rotation case with `k = p`: either `L^k`
  at cost `k`, or `R L^{n-k} R` at cost `n - k + 2`. So the cost is
  `min(k, n - k + 2)`. The second branch is the interesting one — rotating left
  `n - 1` times costs 3 rather than `n - 1`, because reverse, rotate, reverse is
  a rotate-right.
- Reaching `Rot^k(reverse(nums))`, which is the reversal case with
  `k = n - 1 - p`: either `R L^k` at cost `k + 1`, or `L^{n-k} R` at cost
  `n - k + 1`. So the cost is `min(k + 1, n - k + 1)`.

Inserting another pair of `R`s costs 2 more and only negates the rotation being
conjugated, so it can never win; the same comparison rules out words with three
`R`s. Both cases can apply to the same input, so the answer is the minimum over
those that do rather than the first one found.

## Approach

1. `p = index of 0 in nums`.
2. `forward` = `nums[(p + i) % n] == i` for every `i`. If true, `nums` is
   `Rot^p` of the sorted array, costing `min(p, n - p + 2)`.
3. `backward` = `nums[(p - i) % n] == i` for every `i`. If true, `nums` is a
   rotation of the reversed sorted array with `k = n - 1 - p`, costing
   `min(k + 1, n - k + 1)`.
4. Return the smaller of the costs that apply, or -1 if neither does.

## Complexity

- **Time:** O(n) — one search for `0` plus two cyclic scans
- **Space:** O(1)

## Edge Cases

- Already sorted → `p = 0`, forward holds, `min(0, n + 2) = 0`
- `n = 1` → both scans hold; forward gives 0, which wins over the reversal
  case's 1
- `[1, 0]` → forward and backward both hold and both cost 1, so taking the
  minimum over all applicable cases matters rather than returning the first hit
- Reversed sorted, e.g. `[2, 1, 0]` → `p = n - 1`, backward holds with `k = 0`,
  cost `min(1, n + 1) = 1`, a single reverse
- `[1, 2, ..., n-1, 0]` → forward holds with `k = n - 1`, and the cost is
  `min(n - 1, 3) = 3` for `n >= 4`: reverse, rotate left once, reverse
- Unreachable permutations, e.g. `[2, 0, 1, 3]` → neither scan holds, so -1.
  Most permutations fall here, since only `2n` of the `n!` are reachable
- The cost never exceeds `n + 2`, so it fits an `int` comfortably at
  `n <= 10^5`
- Python's `%` on a negative left operand already returns a non-negative
  result, so `(p - i) % n` needs no adjustment; Java needs `+ n` first
