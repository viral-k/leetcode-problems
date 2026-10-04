# Approach

**Tags:** `String`, `Dynamic Programming`, `Stack`, `Greedy`

## Intuition

Without wildcards, a single running balance decides validity. With `'*'` the balance is no longer one number but a set of possible numbers, since each wildcard independently adds 1, subtracts 1, or does nothing.

That set is always a contiguous interval. Each character shifts it by at most one in either direction, so no gaps can open up, which means two bounds describe it completely:

- `lo`: the smallest reachable open count, taking every wildcard as `)` or empty
- `hi`: the largest, taking every wildcard as `(`

Two rules then follow from the prefix condition. `lo` is clamped at 0, because a negative open count is not a real state — a wildcard that would drive it below zero gets read as empty instead, which is always allowed. And if `hi` drops below 0, even the most generous reading has more `)` than available `(`, so the string is already dead.

At the end the string is valid exactly when 0 lies in the interval. Since `hi >= 0` is maintained throughout and `lo` is clamped to be non-negative, that reduces to `lo == 0`.

## Approach

1. `lo = hi = 0`.
2. For each character:
   - `(` → `lo += 1`, `hi += 1`
   - `)` → `lo -= 1`, `hi -= 1`
   - `*` → `lo -= 1`, `hi += 1`
   - if `hi < 0`, return false
   - `lo = max(lo, 0)`
3. Return `lo == 0`.

The O(n^2) DP over `(index, balance)` also works and is the more mechanical answer, but it carries no information the interval does not, so the greedy is strictly better at O(n) time and O(1) space.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- A single `(` or `)` → false; a single `*` → true, read as empty
- All wildcards → true for any length, since each can be empty
- `"(*))"` → `lo` dips and gets clamped, which is what lets the wildcard act as empty rather than forcing it negative
- `")("` → `hi` goes negative on the first character, caught immediately
- `"(("` → `lo` ends at 2, so false even though `hi` never went negative; the final `lo == 0` check is what rejects it
- Clamping `lo` before the next character, not after, matters: an unclamped `lo` would wrongly carry a negative deficit forward
- `"**(("` → false, since two wildcards cannot cancel two trailing opens
