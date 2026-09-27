# Approach

**Tags:** `Array`, `Hash Table`, `String`

## Intuition

Nothing about the replacement depends on context, so this is a single left-to-right pass with a lookup table. Since brackets are never nested, the parser only needs one bit of state: inside a key or not. Building the result as a list of chunks and joining once avoids the quadratic cost of repeated string concatenation.

## Approach

1. Build `lookup = {key: value}` from `knowledge`.
2. Walk `s`:
   - `(` → switch to key mode, clear the key buffer
   - `)` → switch back, append `lookup.get(key, "?")`
   - any other character → append it to the key buffer if in key mode, else straight to the output
3. Join the chunks.

## Complexity

- **Time:** O(n + m) where `n = len(s)` and `m = len(knowledge)`
- **Space:** O(n + m) for the lookup table and the output

## Edge Cases

- Empty `knowledge` → every bracket pair becomes `"?"`
- The same key used several times, including when unknown (Example 3)
- Letters outside brackets that happen to match a key are left alone (`"(a)(a)(a)aaa"` keeps the trailing `aaa`)
- A string with no brackets at all → returned unchanged
- Keys present in `knowledge` but never used in `s` → ignored
- Building with `"".join(parts)` rather than `+=` keeps the pass linear
