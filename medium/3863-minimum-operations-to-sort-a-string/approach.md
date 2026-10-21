# Approach

**Tags:** `String`

## Intuition

The answer is never more than 3, and which of `0, 1, 2, 3, -1` it is can be read
straight off the string. No search is needed.

**One operation.** Sorting a window `[i, j]` turns `s` into `sorted(s)` exactly
when the window covers every position where `s` disagrees with `sorted(s)`: the
part outside is untouched, so it must already be correct, and the part inside
then holds the right multiset and gets sorted. So let `L` be the first index
with `s[L] != sorted(s)[L]` and `R` the last. Sorting any window containing
`[L, R]` works, and no window missing `L` or `R` can, since that position would
keep its wrong character. One operation is available iff some *proper* window
contains `[L, R]`, that is iff `[L, R] != [0, n-1]`, that is iff `L > 0` or
`R < n-1`. Since `sorted(s)[0] = min(s)` and `sorted(s)[n-1] = max(s)`, this is
just `s[0] == min(s)` or `s[n-1] == max(s)`.

**Two operations.** Past that case, `s[0] > min(s)` and `s[n-1] < max(s)`. Two
windows of length `n - 1` are usually enough:

- Sort `[0, n-2]`, then `[1, n-1]`. After the first op index 0 holds
  `min(s[0..n-2])` and the second sorts everything to its right, so the result
  is `sorted(s)` iff `min(s[0..n-2]) == min(s)`, i.e. iff `min(s)` appears at
  some index `<= n-2`.
- Sort `[1, n-1]`, then `[0, n-2]`. By the mirror argument this works iff
  `max(s)` appears at some index `>= 1`.

**Three operations.** Both of those fail only when `min(s)` occurs *only* at
index `n-1` and `max(s)` occurs *only* at index 0. Two operations are then
impossible for a reason that does not depend on the two strategies above.
Write `m = min(s)` and `M = max(s)`, both unique. Because `M` is the unique
maximum, any window containing it leaves it at that window's right end, so `M`
can only arrive at index `n-1` through a window ending at `n-1`; a proper such
window starts at index `>= 1`, so `M` must have been moved off index 0 by an
earlier operation. Symmetrically `m` can only arrive at index 0 through a window
starting at 0, which is proper only if it ends at `<= n-2`, so `m` must have
been moved off index `n-1` earlier. That is two relocations, and no single
proper window can perform both, because a window containing index 0 and index
`n-1` is the whole string. So two operations cannot finish, and the answer is at
least 3.

Three is enough: sort `[1, n-1]`, which pulls `m` to index 1 and leaves
`max(s[1..n-1])` at the end. The uniqueness condition is now broken — `min` sits
at index 1 — so the first two-operation strategy applies and finishes the job.

**Impossible.** Only `n == 2` while unsorted. Every proper substring then has
length 1 and sorting it changes nothing. `n == 1` is already sorted, and for
`n >= 3` the construction above always succeeds, so -1 never occurs there.

## Approach

1. If `s` is non-decreasing, return 0.
2. If `n == 2`, return -1. (`n == 1` already returned 0.)
3. If `s[0] == min(s)` or `s[n-1] == max(s)`, return 1.
4. If `s[0] == max(s)` with `max` occurring once, and `s[n-1] == min(s)` with
   `min` occurring once, return 3.
5. Otherwise return 2.

## Complexity

- **Time:** O(n) — one sortedness scan plus `min`, `max` and two occurrence
  counts
- **Space:** O(1)

## Edge Cases

- `n == 1` → already sorted, 0, and the `n == 2` branch is never reached
- The `n == 2` check must come *before* the 3-branch: `"ba"` has a unique max at
  index 0 and a unique min at the end, so it would otherwise be reported as 3
  instead of -1
- Constant strings are sorted, so the `max == min` situation never reaches the
  later branches
- `"zaz"` → `s[n-1] == max(s)`, so 1; the minimal window is `[0, 1]`, which is
  proper
- `"zab"` → neither end is correct, but `min` sits at index 1 rather than at the
  end, so sorting `[0, n-2]` then `[1, n-1]` gives 2
- `"zba"` → unique max at index 0, unique min at index 2, so 3; the path is
  `zba -> zab -> azb -> abz`
- `"gf"` → -1, the only unsortable shape
- Duplicates matter in step 4: `"zzab"` has its max at indices 0 and 1, so a
  window ending at `n-1` can collect a copy of the max without first relocating
  the one at index 0, and the answer drops to 2
