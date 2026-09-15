# Approach

**Tags:** `String`, `Greedy`, `Dynamic Programming`, `Two Pointers`

## Intuition

The hard-looking part is that palindromes can be arbitrarily long, so a full search would consider O(n^2) candidate substrings. Two facts collapse that.

**Only lengths `k` and `k+1` matter.** Take any palindrome of length `L >= k`. Removing its first and last character leaves a palindrome of length `L - 2`. Repeat until the length is `k` or `k+1` (parity decides which). That shorter palindrome sits strictly inside the original, so any selection using the long one can swap in the short one without creating a conflict, and possibly free up room for more. So an optimal selection can always be built from palindromes of length exactly `k` or `k+1`.

**Earliest end first is optimal.** With candidate intervals fixed, maximising the count of non-overlapping ones is classic interval scheduling: always take the interval that ends soonest, then continue after it. Any solution that skips the earliest-ending interval can be exchanged to include it without losing a pick.

Scanning left to right and grabbing the first `k`- or `k+1`-length palindrome that starts at the current position is exactly that greedy. A `k`-length one starting at `i` ends at `i+k-1`, the smallest possible end among anything not yet passed; if only the `k+1` version exists at `i`, its end `i+k` ties with a `k`-length one starting at `i+1`, so either choice leaves the same remainder.

## Approach

1. Set `i = 0`, `count = 0`.
2. While `i + k <= n`:
   - If `s[i : i+k]` is a palindrome, increment `count` and set `i += k`.
   - Else if `s[i : i+k+1]` fits and is a palindrome, increment `count` and set `i += k + 1`.
   - Else `i += 1`.
3. Return `count`.

Each palindrome test compares up to `k` characters, and there are at most `n` starting positions.

## Complexity

- **Time:** O(n * k) — never worse than the O(n^2) full-table alternative, and much better when `k` is small
- **Space:** O(1) — no palindrome table is needed, since only two lengths are ever tested

## Edge Cases

- `k = 1` → every character is a palindrome, so the answer is `n`
- No palindrome of length `>= k` anywhere → 0 (Example 2)
- `k` equal to `n` → at most one pick, only if the whole string is a palindrome
- A run of identical characters like `"aaaa"` with `k = 2` → greedy takes `"aa"`, `"aa"` for 2, which is optimal
- The `k+1` check must confirm the substring actually fits within the string before testing it
