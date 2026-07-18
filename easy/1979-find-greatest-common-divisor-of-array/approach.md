# Approach

**Tags:** `Array`, `Math`, `Number Theory`

## Intuition

The problem states exactly what to compute: only the minimum and maximum matter, so find them and take their GCD.

## Approach

1. Scan `nums` once, tracking the minimum and maximum values.
2. Return `gcd(min, max)` via the Euclidean algorithm (`gcd(a, b) = gcd(b, a % b)` until `b == 0`).

## Complexity

- **Time:** O(n + log V) — one pass plus the Euclidean algorithm
- **Space:** O(1)

## Edge Cases

- All elements equal → min == max → the GCD is that value itself (Example 3)
- Coprime min and max → 1 (Example 2)
- Min divides max → the answer is the min
- Array length is at least 2, so min and max always exist
