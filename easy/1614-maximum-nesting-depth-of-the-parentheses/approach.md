# Approach

**Tags:** `String`, `Stack`

## Intuition

Depth at any position is just the number of open brackets to its left minus the number of closed ones, so a single counter tracks it. The answer is the largest value the counter ever reaches. Since the input is guaranteed to be a valid parentheses string, brackets always match up and the counter can never dip below zero, which means an actual stack would only hold redundant information.

## Approach

1. Keep `depth = 0` and `best = 0`.
2. For each character: `(` increments `depth` and updates `best`; `)` decrements `depth`; anything else is ignored.
3. Return `best`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- No parentheses at all (`"1+2"`) → 0
- Flat sequence `"()()()"` → 1, since the groups do not nest
- Fully nested `"((((()))))"` → the depth equals the number of open brackets
- Mixed flat and nested groups, where the deepest group is not the first (Example 3)
- Digits and operators are irrelevant and only need skipping
- Checking `best` only on `(` is enough; depth never peaks anywhere else
