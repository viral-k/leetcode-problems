# Approach

**Tags:** `String`, `Simulation`

## Intuition

The grammar looks fiddly, but every rule is **local** — whether a character is legal depends only on what has been seen so far, never on what comes later. That means one left-to-right scan carrying three booleans is enough, with no backtracking and no regex.

The three pieces of state:

- `seenDigit` — has a digit appeared in the current mantissa/exponent section?
- `seenDot` — has a decimal point appeared?
- `seenExp` — has `e`/`E` appeared?

Two rules carry most of the weight:

- **A dot is illegal once an exponent has started.** The exponent must be an *integer*, which is what rejects `"99e2.5"`.
- **`e` resets `seenDigit`.** The exponent needs digits of its own, so after consuming `e` the flag goes back to false — that single reset is what rejects `"1e"` while still accepting `"2e10"`.

A sign is legal only in two spots: the very start, or directly after `e`/`E`. That covers `"3e+7"` while rejecting `"--6"` and `"-+3"`.

## Approach

Scan each character:

- **digit** → set `seenDigit`.
- **`+` or `-`** → valid only at index `0` or when the previous character is `e`/`E`; otherwise return false.
- **`.`** → return false if `seenDot` or `seenExp`; otherwise set `seenDot`.
- **`e` or `E`** → return false if `seenExp` or not `seenDigit`; otherwise set `seenExp` and clear `seenDigit`.
- **anything else** → return false.

Finally return `seenDigit`, which guarantees the string ended with at least one digit in its last section.

## Complexity

- **Time:** O(n) — one pass
- **Space:** O(1) — three booleans

## Edge Cases

- `"."` → a dot with no digits → `seenDigit` is false at the end → invalid
- `"e"` / `"e3"` → exponent with no preceding digit → invalid
- `"1e"` → exponent with no following digit; caught by the `seenDigit` reset → invalid
- `"4."` and `"-.9"` → both valid; a dot may lead or trail as long as some digit exists
- `"99e2.5"` → dot after exponent → invalid
- `"--6"`, `"-+3"` → sign not at the start or after `e` → invalid
- Uppercase `E` behaves identically to `e` (`"-90E3"`)
