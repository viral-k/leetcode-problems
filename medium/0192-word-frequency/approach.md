# Approach

**Tags:** `Shell`, `Sorting`, `Counting`

## Intuition

Word counting is a textbook Unix pipeline: get one word per line, group identical words together by sorting, let `uniq -c` tally them, then order by count.

## Approach

1. `grep -oE '[a-z]+'` — extract each maximal lowercase run onto its own line. This ignores all whitespace (including leading/trailing spaces and multiple separators), so no empty tokens can leak — more robust than `tr -s ' ' '\n'`, which emits an empty token for a leading space.
2. `sort` — bring identical words adjacent (required by `uniq`).
3. `uniq -c` — collapse runs into `count word`.
4. `sort -rn` — sort numerically, descending, by the leading count.
5. `awk '{print $2, $1}'` — swap to the required `word count` order.

## Complexity

- **Time:** O(w log w) — dominated by the sort of `w` words
- **Space:** O(w)

## Edge Cases

- Multiple spaces between words → `tr -s` squeezes them
- Trailing newline/spaces → squeezing avoids stray empty tokens
- Ties are guaranteed not to occur, so no tie-break rule is needed

## Note

This is a **bash-only** problem — the solution lives in `solution.sh` (no Python/Java equivalent).
