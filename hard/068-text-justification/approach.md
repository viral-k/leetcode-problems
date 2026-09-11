# Approach

**Tags:** `Array`, `String`, `Simulation`, `Greedy`

## Intuition

Two independent jobs: deciding which words share a line, and spacing a line once its words are fixed. Keeping them separate is what stops this from turning into tangled index arithmetic.

**Packing** is greedy and the problem says so: keep adding words while they fit. The fit test has to account for the minimum single space before each added word, so a line holding `k` words of total length `L` occupies `L + (k - 1)` characters at its tightest. Written incrementally, the next word fits when `currentLen + k + wordLen <= maxWidth`, where `k` is the count already on the line.

**Spacing** splits into two shapes:

- A normal line with at least two words spreads `maxWidth - totalWordLen` spaces over `k - 1` gaps. Integer division gives the base gap width, and the remainder is handed out one extra space at a time starting from the left, which is exactly the "left slots get more" rule.
- A line that cannot be spread gets single spaces and right padding. That covers two distinct cases which behave identically: the **last line**, and any line holding a **single word** (no gaps exist to absorb the padding).

Missing that single-word case is the usual bug here; Example 2's `"acknowledgment  "` is a middle line, not the last one, yet it is still left-justified.

## Approach

1. Walk the words, accumulating a current line and its running word-length total.
2. Before adding `word`, test `currentLen + len(line) + len(word) <= maxWidth`. If it fails, flush the line and start a new one with `word`.
3. Flushing a **fully justified** line (2+ words, not the last):
   - `spaces = maxWidth - currentLen`, `gaps = len(line) - 1`
   - `base, extra = divmod(spaces, gaps)`
   - Join, giving the first `extra` gaps `base + 1` spaces and the rest `base`.
4. Flushing a **left-justified** line (last line, or a single word):
   - `" ".join(line)` then right-pad with spaces to `maxWidth`.
5. Return the collected lines.

## Complexity

- **Time:** O(total characters) — each word is examined once and copied into one line
- **Space:** O(maxWidth) of working buffer, plus the output

## Edge Cases

- **Single-word line in the middle** of the text is left-justified, not stretched (Example 2)
- **Last line** is always left-justified even when it holds several words
- A word exactly `maxWidth` long occupies its own line
- One word total → a single left-justified, right-padded line
- Every returned line must measure exactly `maxWidth`, including the padded ones
- The remainder distribution goes left-to-right; reversing it produces Example 1's spacing incorrectly
