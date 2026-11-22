# Approach

**Tags:** `String`

## Intuition

Every `'a'` comes before every `'b'` exactly when the string has the shape `a...ab...b`. Either part can be empty. The only thing that breaks that shape is a `'b'` immediately followed by an `'a'`. If the string had a `'b'` somewhere before an `'a'` without that adjacent pair, it would have to switch from `b` back to `a` at some point, and that switch is the pair `"ba"`.

## Approach

Return `"ba" not in s`. A single scan checks each adjacent pair.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- No `'a'`s (`"bbb"`, example 3): vacuously true
- No `'b'`s (`"aaa"`): true
- Single character: true
- `'b'` before `'a'` but not next to each other (`"abba"`): the pair `"ba"` still shows up where it switches back, so false
