# Approach

**Tags:** `String`, `Stack`, `Greedy`, `Monotonic Stack`, `Hash Table`

## Intuition

We must keep exactly one copy of each distinct character, and want the result as small as possible lexicographically. Scanning left to right, a character already placed should be **dropped in favour of a smaller one** if we can safely re-add it later — i.e. if it occurs again further right. That "pop while the top is bigger and reappears later" rule is exactly a monotonic stack.

## Approach

1. Record `last[c]` = the last index where character `c` appears.
2. Maintain a stack (the answer being built) and an `inStack` set.
3. For each index `i` with character `c`:
   - If `c` is already in the stack, skip it (each character appears once).
   - Otherwise, while the stack is non-empty, its top is **greater than** `c`, and that top's last occurrence is **after `i`** (so we can re-add it later), pop the top and remove it from `inStack`.
   - Push `c` and mark it in `inStack`.
4. Join the stack into the result string.

The two pop conditions matter equally: `top > c` makes the result smaller, and `last[top] > i` guarantees we don't lose a character permanently.

## Complexity

- **Time:** O(n) — each character is pushed and popped at most once
- **Space:** O(26) = O(1) — stack and set hold distinct lowercase letters only

## Edge Cases

- All distinct characters already ascending (`"abc"`) → nothing pops, output unchanged
- All same character (`"aaaa"`) → one `a`
- Popping must stop at the last occurrence: `"cbacdcbc"` keeps the final `b` (its earlier copies were poppable, the last one is not)
- Single character → itself
