# Approach

**Tags:** `String`, `Stack`, `Greedy`

## Intuition

Insertions are free to place anywhere, so the only thing that matters is how many brackets end up with no partner. Walk the string keeping a count of unmatched `(`. A `)` either pairs with one of those, or it has nothing before it to pair with and is therefore stranded, which forces inserting a `(` somewhere to its left.

Stranded closers and leftover openers are independent: a `)` with no opener available can never be fixed by a `(` that appears later in the string, since the opener has to come first. So the two kinds of deficit simply add.

A stack would work here, but the only thing it would ever hold is a run of identical `(` characters, so its depth is the entire content. A counter replaces it.

## Approach

1. `open = 0`, `adds = 0`.
2. For each character:
   - `(` → `open += 1`
   - `)` → if `open > 0`, `open -= 1`; else `adds += 1`
3. Return `adds + open`.

Matching a `)` against a pending `(` whenever one exists is optimal: leaving it unmatched would cost an insertion now and still leave the opener needing one later, which is strictly worse.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Already valid (`"()"`, `"()()"`, `"(())"`) → 0
- All openers (`"((("`) → 3, all from the final `open` count (Example 2)
- All closers (`")))"`) → 3, all from `adds`
- Both deficits at once (`")("`) → 2, one of each kind; this is the case that shows they cannot cancel
- Single character → 1 either way
- Maximum answer is `n` (1000), reached when the string is entirely one bracket type
