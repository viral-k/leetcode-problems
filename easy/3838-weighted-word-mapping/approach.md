# Approach

**Tags:** `Array`, `String`, `Hash Table`

## Intuition

Each word maps to a single character through three direct steps: sum its letter weights, reduce modulo 26, then translate that index to a letter in reverse alphabetical order. There is nothing to optimize — just apply the rule to every word and concatenate.

## Approach

1. For each word, sum `weights[ord(ch) - ord('a')]` over its characters.
2. Reduce the sum modulo 26 to get an index `r` in `[0, 25]`.
3. Map `r` to a letter in reverse order: `0 -> 'z'`, ..., `25 -> 'a'`, i.e. `chr(ord('z') - r)`.
4. Concatenate all mapped characters in word order and return the result.

## Complexity

- **Time:** O(L) — where `L` is the total number of characters across all words
- **Space:** O(w) — the output string, one character per word

## Edge Cases

- Weight sum exactly divisible by 26 -> index `0` -> `'z'`
- Single-character word -> just that letter's weight modulo 26
- Single word -> output is a one-character string
