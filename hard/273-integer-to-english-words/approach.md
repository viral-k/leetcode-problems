# Approach

**Tags:** `Math`, `String`, `Recursion`

## Intuition

English reads numbers in groups of three digits. 1,234,567 is "one million", "two hundred thirty four thousand", "five hundred sixty seven". Each group is said the same way, as a number from 1 to 999, followed by its scale word. So the whole problem is a 1–999 converter plus a loop over at most four groups (`2^31 - 1` is just over two billion).

Inside a group, 1–19 are irregular names, 20–99 are a tens word plus an optional ones word, and a nonzero hundreds digit adds "X Hundred" in front.

The hard part is the spacing and the zeros, not the math.

## Approach

1. `0` is the only number whose answer contains "Zero"; return it directly.
2. For scale `3, 2, 1, 0` (Billion, Million, Thousand, none), take the chunk `num / 1000^scale % 1000`.
3. Skip a zero chunk entirely, so that 1,000,000 doesn't produce "One Million Thousand".
4. For a nonzero chunk, emit `ones[h] Hundred` if the hundreds digit `h` is nonzero. For the last two digits `r`, emit `ones[r]` if `r < 20`, else `tens[r / 10]` plus `ones[r % 10]`. Then emit the scale word.
5. Collect words in a list, drop the empty ones (`ones[0]`, `scales[0]`, the ones word of 20, 30, ...), and join with single spaces.

## Complexity

- **Time:** O(1). At most 4 chunks and a bounded number of words.
- **Space:** O(1)

## Edge Cases

- `0` → `"Zero"`, the only case that uses the word
- Zero chunks in the middle: 1,000,010 is "One Million Ten" (no "Thousand"), and 1,001,000 is "One Million One Thousand"
- Exact tens and hundreds (20, 100, 1000): no trailing "Zero" and no trailing space
- 10–19 inside a chunk (110 is "One Hundred Ten", not "One Hundred One Zero")
- No "and" anywhere: LeetCode expects "One Hundred One", not "One Hundred and One"
- `2^31 - 1` reaches the Billion chunk; the Java loop starts its divisor at `10^9`, which still fits in `int`
