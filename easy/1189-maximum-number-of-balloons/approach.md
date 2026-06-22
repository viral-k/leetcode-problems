# Approach

**Tags:** `Hash Table`, `String`, `Counting`

## Intuition

Forming the word "balloon" repeatedly is limited by whichever required letter runs out first. So count the letters in `text` and see how many copies of "balloon" the supply supports. The word uses `l` and `o` twice each, so their available counts must be halved before comparing.

## Approach

1. Count the frequency of each character in `text`.
2. "balloon" requires `b:1, a:1, l:2, o:2, n:1`. The number of words each letter can support is:
   - `count['b']`, `count['a']`, `count['n']`
   - `count['l'] // 2`, `count['o'] // 2`
3. The answer is the minimum of these five values (the bottleneck letter).

## Complexity

- **Time:** O(n) — one pass to count
- **Space:** O(1) — fixed-size frequency map (26 letters)

## Edge Cases

- A required letter missing entirely -> minimum is `0`
- Only one of the doubled letters present once -> `// 2` makes it `0`
- Extra irrelevant characters -> ignored, do not affect the count
