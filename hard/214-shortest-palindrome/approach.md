# Approach

**Tags:** `String`, `String Matching`

## Intuition

Characters may only be added in front, so the tail of `s` is fixed and whatever is prepended has to mirror a suffix of `s`. Concretely, if `s[0..k-1]` is a palindrome, then prepending `reverse(s[k..])` gives a palindrome of length `2n - k`. Making the result shortest means making `k` as large as possible, so the whole problem reduces to one question: what is the longest palindromic **prefix** of `s`?

That question has a neat string-matching form. A prefix `s[0..k-1]` is a palindrome exactly when it equals its own reverse, and the reverse of a prefix of `s` is a suffix of `reverse(s)`. So the longest palindromic prefix is the longest prefix of `s` that is also a suffix of `reverse(s)` — precisely what the KMP prefix function computes when the two strings are concatenated.

Build `t = s + '#' + reverse(s)` and run the prefix function over it. Its final value is the answer to that question.

The separator matters. Without it the border can extend past `len(s)` and report nonsense: for `s = "aaa"` the plain concatenation `"aaaaaa"` has a border of length 5, which is longer than `s` itself. Inserting a character that appears in neither string caps any border at `len(s)`, because no border may contain the separator.

## Approach

1. If `s` is empty, return `""`.
2. `t = s + "#" + s[::-1]`.
3. Compute the prefix function `pi` of `t`: for each position `i`, the length of the longest proper prefix of `t[0..i]` that is also a suffix of it, using the standard fallback loop.
4. `k = pi[-1]`, the longest palindromic prefix length.
5. Return `s[k:][::-1] + s`.

## Complexity

- **Time:** O(n) — the prefix function is linear, and `t` is about `2n` long
- **Space:** O(n) for `t` and `pi`

## Edge Cases

- Empty string → `""`; the constraints allow length 0, and `t` would otherwise be just the separator
- `s` already a palindrome → `k = n`, nothing is prepended, the string comes back unchanged
- All identical characters (`"aaa"`) → the case the separator exists to protect; without it `k` would exceed `n`
- No palindromic prefix beyond the first character (`"abcd"`) → `k = 1` and `n - 1` characters are prepended, giving length `2n - 1`
- A near-miss where the longest palindromic prefix is not the obvious one: in `"aacecaaa"` it is `"aacecaa"` of length 7, not the full string, so exactly one character is added
- Single character → already a palindrome, returned as is
- Result length is `2n - k`, never more than `2n - 1` for non-empty input
