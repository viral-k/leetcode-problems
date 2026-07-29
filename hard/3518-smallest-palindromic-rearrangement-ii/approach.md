# Approach

**Tags:** `String`, `Combinatorics`, `Greedy`, `Counting`, `Math`

## Intuition

A palindrome is fully determined by its **left half** plus a fixed middle character (the one with an odd count, if any). Two palindromes compare lexicographically exactly as their left halves do, since the left half is a prefix. So "k-th smallest palindrome" is precisely "k-th smallest permutation of the left-half multiset", where each character contributes `count // 2` copies.

Finding the k-th permutation of a multiset is the classic **digit-by-digit combinatorial ranking**: at each position, try the smallest available character; the number of ways to complete the rest is the multiset-permutation count of the remaining characters. If `k` fits within that block, commit the character; otherwise subtract the block and try the next character.

The permutation counts are astronomically large, but `k <= 10^6`, so we only ever need them **capped** at `10^6 + 1` — anything at least that big is "definitely >= k". Capping with early exit keeps every count cheap.

## Approach

1. Count characters; the left-half multiset uses `count[c] // 2` of each. The odd-count character (if any) is the fixed middle.
2. `perms_capped(counts)` = distinct permutations of a multiset, as a product of binomial coefficients `C(n, c1) * C(n-c1, c2) * ...`, each computed with early exit and capped at `CAP = 10^6 + 1`.
3. **Feasibility:** if `perms_capped(left counts) < k`, return `""`.
4. **Build the left half:** for each position, scan characters `a..z`; tentatively place `c` (decrement its count), compute `w = perms_capped(remaining)`:
   - if `k <= w`, keep `c` and move to the next position;
   - else `k -= w`, restore the count, try the next character.
5. Return `left + middle + reverse(left)`.

## Complexity

- **Time:** O(L · Σ · early-exit) where L = half length, Σ = 26 — the capped counts short-circuit, so each is effectively O(Σ)
- **Space:** O(Σ + n) — counts plus the output

## Edge Cases

- `k` exceeds the number of distinct palindromes → `""` (Example 2)
- Odd-length input → exactly one character has an odd count → the middle
- Single character → the middle itself; only `k = 1` is valid
- All identical characters → only one palindrome; `k > 1` → `""`
- Capping must use `CAP > max k` so a saturated count always reads as `>= k`
