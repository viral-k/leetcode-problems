# Approach

**Tags:** `Hash Table`, `String`

## Intuition

For each letter, we need two facts:

- whether it appears in uppercase, and where the first uppercase occurrence is
- where its last lowercase occurrence is

A letter is special only if both cases appear and the last lowercase occurrence comes before the first uppercase occurrence.

## Approach

1. Create an array `lastLowercase` of size `26`, initialized to `-1`.
2. Create an array `firstUppercase` of size `26`, initialized to `n`.
3. Scan `word` from left to right:
   - for a lowercase character, update its last lowercase index
   - for an uppercase character, keep the minimum uppercase index
4. For each of the `26` letters, count it when:
   - `lastLowercase[letter] != -1`
   - `firstUppercase[letter] != n`
   - `lastLowercase[letter] < firstUppercase[letter]`

## Complexity

- **Time:** O(n) — scan the string once, then check 26 letters
- **Space:** O(1) — two fixed-size arrays

## Edge Cases

- Only lowercase letters -> answer is `0`
- Only uppercase letters -> answer is `0`
- Uppercase before lowercase -> not special
- Lowercase both before and after uppercase -> not special because not every lowercase appears before the first uppercase
