# Approach

**Tags:** `Bit Manipulation`

## Intuition

To flip all bits, XOR with a mask of all 1s. The mask must match the binary length of `n`, not the full integer width.

## Solution

1. Build a mask with all 1s matching `n`'s bit length
2. XOR the mask with `n` to flip all bits

**Building the mask:**
- Start with `mask = 1`
- Left shift until `mask > n`
- `mask - 1` gives all 1s of the correct length

**Example:** `n = 5` (binary `101`)
- mask shifts: 1 → 2 → 4 → 8 (stops when > 5)
- `mask - 1 = 7` (binary `111`)
- `7 XOR 5 = 111 XOR 101 = 010 = 2`

**Special case:** `n = 0` → complement is `1`

## Complexity

- **Time:** O(log n) — shift operations proportional to bit length
- **Space:** O(1)

## Edge Cases

- `n = 0` → return 1
- `n = 1` → return 0
- All 1s like `n = 7` → return 0
