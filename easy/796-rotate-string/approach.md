# Approach

**Tags:** `String`, `String Matching`

## Intuition

Every rotation of `s` appears inside `s + s`. For example, if `s = "abcde"`, then `s + s = "abcdeabcde"`, which contains rotations like `"bcdea"` and `"cdeab"`.

So the problem becomes string matching: check whether `goal` appears in `s + s`. To make the O(n) time guarantee explicit, use KMP instead of relying on a built-in substring search.

## Approach

1. If the lengths are different, return `false`.
2. Build `text = s + s`.
3. Build the KMP `lps` array for `goal`.
   - `lps[i]` stores the length of the longest proper prefix of `goal[0..i]` that is also a suffix.
4. Scan `text` with KMP.
   - When characters match, advance the match length.
   - When they do not match, fall back using the `lps` array instead of restarting from scratch.
5. If the full `goal` string is matched, return `true`.
6. Otherwise, return `false`.

## Complexity

- **Time:** O(n) — build `lps` in O(n), then scan `s + s` in O(2n)
- **Space:** O(n) — the doubled string and `lps` array use extra space

## Edge Cases

- Different lengths → impossible to rotate into each other
- Same string → zero shifts are allowed, so return `true`
- Repeated characters → substring check still covers all rotations
