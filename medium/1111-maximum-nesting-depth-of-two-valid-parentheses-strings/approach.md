# Approach

**Tags:** `String`, `Stack`, `Greedy`

## Intuition

Start from the lower bound. If `seq` has depth `D`, there is a moment when `D` brackets are simultaneously open. Every one of them must go to `A` or to `B`, and whichever group receives more of them is nested at least `ceil(D/2)` deep. So no split can beat `ceil(D/2)`.

Alternating by depth reaches that bound. Send every bracket sitting at an odd depth to one group and every bracket at an even depth to the other. The odd group then contains the depths `1, 3, 5, ...` up to `D`, nested `ceil(D/2)` deep, and the even group contains `2, 4, 6, ...`, nested `floor(D/2)` deep.

Both groups come out valid because a `(` and its matching `)` always sit at the same depth, so a pair is never split across groups, and the relative nesting inside a group is inherited from `seq`.

## Approach

1. Track `depth`, starting at 0.
2. For `(`: increment `depth` first, then record `depth % 2`.
3. For `)`: record `depth % 2`, then decrement.
4. Return the recorded labels.

Reading the depth before the decrement on `)` is what makes a pair agree: the closing bracket of a pair opened at depth `d` is itself at depth `d`.

## Complexity

- **Time:** O(n)
- **Space:** O(1) beyond the output

## Edge Cases

- Flat input `"()()()"` → depth 1, so one group takes everything and the other is empty; an empty VPS is allowed
- Fully nested `"((((()))))"` → labels alternate every character, giving depths 3 and 2 for `D = 5`
- Depth 0 (empty seq) → empty output
- The expected outputs in the statement are the complement of what this produces; swapping the two labels is always equally valid, and the problem permits any answer
- Correctness does not depend on where the deepest point occurs, so mixed shapes like `"()(())()"` need no special handling
