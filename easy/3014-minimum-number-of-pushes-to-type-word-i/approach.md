# Approach

**Tags:** `Math`, `Greedy`

## Intuition

There are 8 usable keys (2–9). Each key's first assigned letter costs 1 push, its second costs 2, its third costs 3, etc. To minimize total pushes, fill all 8 keys with one letter each (cost 1) before giving any key a second letter (cost 2), and so on. Since all letters in `word` are distinct, only the *count* of letters matters — not which letters they are.

So the letter placed at index `i` (0-based) lands in "tier" `i // 8`, costing `i // 8 + 1` pushes.

## Approach

1. Let `n = len(word)`.
2. Sum `i // 8 + 1` for `i` from `0` to `n - 1`.

A closed form also works: full tiers of 8 plus the remainder, but the direct sum is clearest for `n <= 26`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- `n <= 8` → every letter costs 1 → answer `n` (Example 1)
- `n = 26` → 8 letters at cost 1, 8 at cost 2, 8 at cost 3, 2 at cost 4
- Distinctness is guaranteed, so no letter frequency to weigh (that's part II)
