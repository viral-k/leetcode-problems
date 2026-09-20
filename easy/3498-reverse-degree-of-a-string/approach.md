# Approach

**Tags:** `String`, `Simulation`

## Intuition

The definition is already the algorithm. The only translation needed is from a character to its reversed-alphabet position: `'a'` is offset 0 from `'a'` and should map to 26, `'z'` is offset 25 and should map to 1, so the value is `26 - offset`.

## Approach

1. Walk the string with a 0-based index `i`.
2. For character `c`, compute `weight = 26 - (ord(c) - ord('a'))` and `position = i + 1`.
3. Accumulate `weight * position`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Single character `"a"` → 26, `"z"` → 1
- All `'z'` → sum of positions `n(n+1)/2`
- Maximum value: `n = 1000`, all `'a'` → `26 * 1000 * 1001 / 2 = 13,013,000`, fits in a 32-bit `int`
