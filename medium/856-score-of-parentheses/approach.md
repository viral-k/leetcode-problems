# Approach

**Tags:** `String`, `Stack`

## Intuition

Unfold the two composition rules. `AB` adds, and `(A)` doubles, so the total score is a sum of contributions from the innermost `"()"` pairs, each weighted by how deeply it is nested. A core sitting inside `d` enclosing pairs has been doubled `d - 1` times, so it contributes `2^(d-1)` where `d` is its own depth.

Every `"()"` in the string is exactly one such core, and nothing else contributes anything: a `)` that closes a pair containing other pairs adds no score of its own, because the doubling it applies is already baked into the weights of the cores inside it.

So the whole problem reduces to finding the `"()"` occurrences and summing powers of two. No stack, no recursion.

## Approach

1. Keep `depth = 0` and `total = 0`.
2. Walk the string. On `(`, increment `depth`. On `)`, decrement `depth`, and if the previous character was `(` add `1 << depth` (the depth after decrementing is `d - 1`).
3. Return `total`.

Checking `s[i-1] == '('` is what identifies a core; it is the only condition needed.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

The usual stack-of-scores solution is also O(n) time but O(n) space. The depth-counting version is preferred here since it is strictly better on space and no harder to follow.

## Edge Cases

- `"()"` → one core at depth 1, contributing `2^0 = 1`
- `"(())"` → one core at depth 2, contributing `2^1 = 2`; the outer pair adds nothing itself
- `"()()"` → two cores at depth 1, total 2
- Maximum nesting `"(((...)))"` with length 50 → depth 25, so the single core contributes `2^24`; comfortably inside 32-bit `int`
- Maximum score comes from full nesting, not from many siblings: 25 sibling pairs score 25, while depth-25 nesting scores 16,777,216
- Input is guaranteed balanced, so `depth` never goes negative and needs no guard
