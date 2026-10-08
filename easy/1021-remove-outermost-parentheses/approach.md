# Approach

**Tags:** `String`, `Stack`

## Intuition

The primitive decomposition never has to be built. A primitive piece is exactly a stretch that starts when the running depth leaves 0 and ends when it returns to 0, because that is precisely when the prefix so far is balanced and cannot be split further. So the brackets to drop are the ones straddling depth 0: the `(` that moves the depth from 0 to 1, and the `)` that moves it from 1 back to 0.

Every other bracket sits strictly inside some primitive and survives. That turns the whole problem into a depth counter with one comparison per character, no stack and no segmentation pass.

The asymmetry in the two checks comes from where the character sits relative to its own depth change. An opening bracket is outermost when the depth *before* it is 0; a closing bracket is outermost when the depth *after* it is 0. Taking the decrement first for `)` makes both tests read `depth > 0`.

## Approach

1. `depth = 0`, and an output buffer.
2. For each character:
   - `(` → append it if `depth > 0`, then `depth += 1`
   - `)` → `depth -= 1`, then append it if `depth > 0`
3. Join the buffer.

## Complexity

- **Time:** O(n)
- **Space:** O(n) for the output, O(1) beyond it

## Edge Cases

- `"()()"` → every bracket is outermost, so the result is empty (Example 3)
- A single primitive `"(())"` → `"()"`, dropping only the first and last characters
- Deep nesting `"((((()))))"` → one level is peeled off, leaving `"(((())))"`
- Many primitives in a row, each contributing independently (Example 2)
- Input is guaranteed valid, so `depth` never goes negative and needs no guard
- Building with a list and one join keeps the pass linear; repeated string concatenation would be quadratic at the 10^5 limit
