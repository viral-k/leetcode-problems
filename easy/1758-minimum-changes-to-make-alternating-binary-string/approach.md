# Approach

**Tags:** `String`, `Greedy`

## Intuition

An alternating binary string can only have two valid patterns:
1. Start with `'0'`: `010101...`
2. Start with `'1'`: `101010...`

Count mismatches for both patterns and return the minimum.

## Solution

**Pattern 1 (starting with '0'):**
- Index `i` even → expected `'0'`
- Index `i` odd → expected `'1'`

**Pattern 2 (starting with '1'):**
- Index `i` even → expected `'1'`
- Index `i` odd → expected `'0'`

Count how many characters differ from each pattern in a single pass. The answer is the minimum of the two counts.

**Key insight:** If a character mismatches pattern 1, it matches pattern 2, and vice versa. So `change_start0 + change_start1 = n`.

## Complexity

- **Time:** O(n) — single pass through the string
- **Space:** O(1) — only two counters

## Edge Cases

- Already alternating → return 0
- All same characters → return n/2
- Single character → return 0
