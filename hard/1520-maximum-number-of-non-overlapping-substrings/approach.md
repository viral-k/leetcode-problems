# Approach

**Tags:** `String`, `Greedy`

## Intuition

Condition 2 says a chosen substring is closed under "if you contain one `c`, you contain every `c`". For a given character `c`, the shortest closed substring that starts at `first[c]` is forced: start at `first[c]`, and every character `x` you encounter while scanning pushes the right end out to at least `last[x]`. If some `x` inside has `first[x] < first[c]`, the substring cannot be closed without extending left past `first[c]`, so no valid substring starts there.

Two closed substrings can never partially overlap. If they shared a character, each would have to contain all occurrences of it, and then each would have to contain the other's whole extent. So the candidate intervals form a laminar family: any two are either disjoint or nested. In that setting, the standard interval-scheduling greedy (sort by right end, take an interval whenever it starts after the last taken one) maximises the count and, since nested intervals appear inner-first, also minimises total length.

## Approach

1. Record `first[c]` and `last[c]` for all 26 letters.
2. For each letter `c` present, build the candidate starting at `left = first[c]`: set `right = last[c]`, scan `i` from `left` to `right` (extending `right` to `max(right, last[s[i]])` as you go), and abort if `first[s[i]] < left`. If the scan finishes, keep `[left, right]`.
3. Sort the kept intervals by `right`. Walk them, appending each interval whose `left` is beyond the previous `right`.
4. Return the corresponding substrings.

Only a valid interval that is minimal for its start position is ever produced, and the greedy by right end picks the innermost available one from each nested chain, which gives the unique minimum-length answer.

## Complexity

- **Time:** O(26 * n) — each of at most 26 candidates scans up to the whole string
- **Space:** O(1) beyond the output (26 intervals)

## Edge Cases

- Single character `"a"` → `["a"]`
- All the same letter `"aaaa"` → one substring, the whole string
- All distinct letters → every single character is its own substring, answer has `n` entries
- A character whose span contains a character that also appears before it (`"abab"` for `b`) → candidate for `b` is dropped; the answer is the whole string
- Nested spans like `"abba"` → `bb` wins over `abba` because the greedy prefers the earlier right end
- Output order does not matter, but the solution emits them left to right
