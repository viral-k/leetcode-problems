# Approach

**Tags:** `Math`, `Dynamic Programming`

## Intuition

A number can only be good if every digit is valid after rotation. Digits `0`, `1`, and `8` stay the same, while `2`, `5`, `6`, and `9` change into another digit. Digits `3`, `4`, and `7` make the whole number invalid.

So a number is good when:

1. It contains no invalid digit.
2. It contains at least one digit that changes after rotation.

## Approach

Check every number from `1` to `n`.

For each number, inspect its digits:

- If any digit is one of `3`, `4`, or `7`, the number is invalid.
- If any digit is one of `2`, `5`, `6`, or `9`, the rotated number will differ from the original.

Count the number only when it is valid and has at least one changing digit.

## Complexity

- **Time:** O(n log n) — each number contributes work proportional to its number of digits
- **Space:** O(1) — only constant extra state is used

## Edge Cases

- `n = 1` → no good numbers
- Numbers containing only `0`, `1`, and `8` → valid but unchanged, so not good
- Numbers containing `3`, `4`, or `7` → invalid
- Numbers with at least one of `2`, `5`, `6`, or `9` and no invalid digits → good
