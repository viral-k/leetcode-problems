# Approach

**Tags:** `Array`, `Bit Manipulation`, `Greedy`, `Math`

## Intuition

Start from the largest candidate — the whole array — and only shrink if forced.

Let `total` be the XOR of every element.

- If `total != 0`, the full array already works, so the answer is `n`.
- If `total == 0`, we must drop something. Dropping a single element `x` leaves XOR `total XOR x = 0 XOR x = x`. So dropping **any non-zero element** immediately gives a non-zero XOR, and the answer is `n - 1`. Dropping a zero would leave the XOR at 0, which is why the dropped element must be non-zero.
- If `total == 0` **and** every element is `0`, then every subsequence XORs to 0 — no valid subsequence exists, so return `0`.

There's never a reason to drop two or more elements: one removal already suffices whenever any non-zero value exists.

## Approach

1. Compute `total` = XOR of all elements.
2. If `total != 0` → return `n`.
3. Otherwise, if any element is non-zero → return `n - 1`.
4. Otherwise (all zeros) → return `0`.

## Complexity

- **Time:** O(n) — one pass (the XOR and the all-zero check fold into the same scan)
- **Space:** O(1)

## Edge Cases

- All elements zero → `0` (the only case with no answer)
- Single non-zero element → `total != 0` → `1`
- Single zero element → `0`
- `total == 0` with a mix of zeros and non-zeros → still `n - 1` (drop a non-zero one)
- Note: `total == 0` does **not** imply all zeros, e.g. `[1, 1]`
