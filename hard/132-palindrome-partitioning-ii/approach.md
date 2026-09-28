# Approach

**Tags:** `String`, `Dynamic Programming`

## Intuition

Minimum cuts is a shortest-path style DP over positions: `cuts[i]` is the answer for the suffix starting at `i`, and the choice at `i` is where the first palindromic piece ends. So `cuts[i] = 1 + min(cuts[j+1])` over all `j` such that `s[i..j]` is a palindrome, with 0 when the whole suffix is already a palindrome.

That leaves the palindrome test. Checking each substring directly would cost O(n^3) overall. Instead precompute a table by expanding around centers: for each of the `2n-1` centers (`n` single characters and `n-1` gaps), walk outward while the characters match and mark `isPal[left][right]` as you go. Every true cell is written exactly once, so the whole table costs O(n^2).

Center expansion is preferable to the interval-length recurrence here because it stops the moment a center fails, doing no work on cells that are false.

## Approach

1. Build `isPal[n][n]`, all false. For each center (both odd and even), expand while in bounds and `s[left] == s[right]`, setting `isPal[left][right] = True`.
2. `cuts[n] = -1` as a sentinel, so that a palindromic prefix reaching the end yields `1 + (-1) = 0` cuts.
3. For `i` from `n-1` down to 0: `cuts[i] = min(1 + cuts[j+1])` over every `j >= i` with `isPal[i][j]`.
4. Return `cuts[0]`.

The `-1` sentinel removes the separate "whole suffix is a palindrome" branch; the same `min` handles it.

## Complexity

- **Time:** O(n^2)
- **Space:** O(n^2) for the palindrome table (`2000^2` booleans is comfortable)

## Edge Cases

- Single character → 0 cuts (Example 2)
- Already a palindrome (`"racecar"`, `"aaaa"`) → 0
- All distinct characters (`"abcde"`) → `n - 1` cuts, the maximum possible
- Even-length palindromes need the gap centers, not just the character centers
- A greedy "take the longest palindrome first" is wrong: on `"aabb"` it takes `"aa"` then `"bb"` for 1 cut, which is right, but on cases like `"cabababcbc"` the longest first piece leads to more cuts than an optimal split, so the DP is required
- `cuts[i]` starts at infinity and the loop always finds at least `j = i` (a single character is a palindrome), so it is never left unset
