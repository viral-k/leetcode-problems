# Approach

**Tags:** `String`, `Greedy`, `Counting`, `Sorting`

## Intuition

A palindrome is completely determined by its **left half** plus (for odd `n`) a single middle character:

```
P = L + mid + reverse(L)
```

A palindromic permutation of `s` exists only when at most one letter has an odd count — and that letter is forced to be `mid`. Everything else splits evenly, so `L` ranges over the permutations of the **half-multiset** `count[c] // 2`. Choosing `L` chooses `P` entirely.

Since the first `h = n/2` characters of `P` are exactly `L`, comparing `P` to `target` splits into three cases against `tpre = target[:h]`:

- **`L < tpre`** → `P < target`. Useless.
- **`L > tpre`** → `P > target` already decided by the prefix, whatever the mirrored tail says. The smallest such `P` comes from the smallest such `L`.
- **`L == tpre`** → the prefix ties, and the comparison falls through to `mid + reverse(L)` versus `target[h:]`. There is exactly **one** palindrome in this case, and if it clears `target` it beats every `L > tpre` candidate.

So check the tie case first, then fall back to "smallest permutation of the half-multiset strictly greater than `tpre`" — which is exactly the sibling problem 3720 applied to the half.

## Approach

1. Count letters of `s`. If more than one letter has an odd count (or the parity disagrees with `n`), no palindrome exists → `""`.
2. `mid` = the odd-count letter (empty for even `n`); `half[c] = count[c] / 2`; `h = n / 2`; `tpre = target[:h]`.
3. **Tie case:** if `tpre` is exactly spellable from `half` (using all `h` slots), build `P0 = tpre + mid + reverse(tpre)`. If `P0 > target`, return it — it is optimal.
4. **Greedy case:** find the smallest permutation `L` of `half` with `L > tpre`:
   - Consume `tpre` greedily from `half` to get the longest matchable prefix.
   - Walk `p` downward (returning characters to the pool), and at each `p` take the smallest available letter `> tpre[p]`, then append the remaining letters in ascending order.
   - A longer shared prefix always yields a smaller `L`, hence the descending search.
5. Return `L + mid + reverse(L)`, or `""` if no `L` exists.

## Complexity

- **Time:** O(26n) — the greedy scans at most 26 letters per position, plus O(n) to assemble
- **Space:** O(n) — counts and the output string

## Edge Cases

- Two or more odd-count letters → no palindromic permutation at all (Example 3)
- `target` is itself a palindromic permutation of `s` → the tie case produces `P0 == target`, which fails the strict test and correctly falls through (Example 1)
- Largest palindromic permutation still `<= target` → `""` (Example 2)
- `n == 1` → `h == 0`, `L` is empty, `P` is the single middle character
- Only the first `h` characters drive the comparison unless `L` ties with `tpre`; the mirrored tail matters only in that one case
