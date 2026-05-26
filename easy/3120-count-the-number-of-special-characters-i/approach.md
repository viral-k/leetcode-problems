# Approach

**Tags:** `Hash Set`, `String`

## Intuition

A letter is special only when its lowercase form and uppercase form both appear somewhere in the string.

So we can track lowercase letters in one set and uppercase letters converted to lowercase in another set. The special letters are exactly the letters present in both sets.

## Approach

1. Create an empty set for lowercase letters.
2. Create an empty set for uppercase letters, stored as lowercase.
3. Scan every character in `word`:
   - if it is lowercase, add it to the lowercase set
   - otherwise, convert it to lowercase and add it to the uppercase set
4. Return the size of the intersection of the two sets.

## Complexity

- **Time:** O(n) — scan the string once
- **Space:** O(1) — at most 26 lowercase and 26 uppercase letters are stored

## Edge Cases

- All lowercase letters -> answer is `0`
- All uppercase letters -> answer is `0`
- Repeated letters -> sets count each letter once
- Mixed case for the same letter -> counted once
