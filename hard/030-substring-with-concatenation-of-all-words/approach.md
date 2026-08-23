# Approach

**Tags:** `Hash Table`, `String`, `Sliding Window`

## Intuition

Every word has the same length `L`, which makes the problem far more structured than a general permutation search: a valid window is always exactly `L * m` characters long (`m = len(words)`), and it must start at an index whose position **mod `L`** stays fixed throughout the window. So the string splits into `L` independent "tracks", one per starting offset, and within a track the text is just a sequence of `L`-sized blocks.

That lets a sliding window advance a whole word at a time instead of a character at a time, and lets the window state be a simple count map compared against the required counts (duplicates in `words` matter, which is why counts are used rather than a set).

Three situations arise as the right edge takes in a new word:

- **Unknown word** — no valid window can span it, so drop everything and restart just past it.
- **Known but now over-counted** — shrink from the left, one word at a time, until the excess is gone.
- **Window complete** (`m` words) — record the start index, then slide the left edge forward by one word to look for the next match.

## Approach

1. Let `L = len(words[0])`, `m = len(words)`, and build `need` = a count map of `words`. If `L * m > len(s)`, return `[]`.
2. For each `offset` in `0 .. L-1`:
   - Set `left = offset`, `count = 0`, and an empty `window` count map.
   - For `right` stepping from `offset` by `L`:
     - Take `word = s[right : right + L]`.
     - If `word` is not in `need`: clear `window`, set `count = 0`, `left = right + L`.
     - Else: increment `window[word]` and `count`; while `window[word] > need[word]`, remove the word at `left` and advance `left` by `L`; then if `count == m`, append `left` to the results and slide the left edge one word forward.
3. Return the collected indices.

## Complexity

- **Time:** O(n * L) — across all offsets there are O(n / L) * L = O(n) window steps, each extracting/hashing an `L`-character substring
- **Space:** O(m * L) — the two count maps

## Edge Cases

- `L * m > len(s)` → no window can fit → `[]`
- Duplicate words (Example 2's two `"word"`s) → counts, not sets, are required
- Overlapping answers (Example 3 returns 6, 9, 12) → sliding by one word after a hit finds them
- An unknown word must reset the window entirely, not merely shrink it
- Single word in `words` → degenerates to finding all occurrences of that word
