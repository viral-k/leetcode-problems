# Approach

**Tags:** `Hash Table`, `String`, `Sliding Window`

## Intuition

Count valid substrings by their **right endpoint**. A substring ending at index `i` contains all three characters iff its start is at or before the most recent position where the *rarest-so-far* of the three was last seen. Concretely, if `last[a]`, `last[b]`, `last[c]` are the most recent indices of each character up to `i`, then any start `j` with `0 <= j <= min(last[a], last[b], last[c])` yields a valid substring.

## Approach

1. Keep `last = [-1, -1, -1]` for the last seen index of `a`, `b`, `c`.
2. Sweep `i` over `s`, updating `last[s[i]]`.
3. If all three are `>= 0`, every start `0..min(last)` works, so add `min(last) + 1` to the answer.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Before all three have appeared → `min(last) = -1` contributes 0
- All same character → never valid → 0 (though constraints guarantee length ≥ 3, content can still lack a letter)
- Answer can reach ~n²/2 (≈ 1.25 * 10^9) → fits in a 64-bit int; use `long` in Java
