# Approach

**Tags:** `String`, `Two Pointers`

## Intuition

At each boundary between groups of 0s and 1s, count valid substrings. If previous group has `prev` chars and current has `curr` chars, we can form `min(prev, curr)` valid substrings centered at this boundary.

## Solution

1. **Track consecutive groups**: Count length of current group (`curr`) and previous group (`prev`).

2. **At each boundary**: When character changes, we can form `min(prev, curr)` valid substrings.
   - Example: `"000111"` → prev=3, curr=3 → valid: `"01"`, `"0011"`, `"000111"` = 3 substrings

3. **Update groups**: When character changes, `prev = curr` and reset `curr = 1`.

4. **Final boundary**: Don't forget to add `min(prev, curr)` after the loop for the last group.

### Why min(prev, curr)?

For groups of sizes `prev` and `curr`, valid substrings are:
- Size 1+1: `"01"` or `"10"`
- Size 2+2: `"0011"` or `"1100"`
- ...up to size `min(prev, curr)` from each side

## Complexity

- **Time:** O(n) — single pass through string
- **Space:** O(1) — only tracking two counters

## Edge Cases

- Single character → return 0 (need both 0 and 1)
- All same character → return 0
- Alternating `"010101"` → each boundary contributes 1
