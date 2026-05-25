# Approach

**Tags:** `String`, `Dynamic Programming`, `Prefix Sum`, `Sliding Window`

## Intuition

Let `reachable[i]` mean index `i` can be reached from index `0`.

For an index `i`, the possible previous indices are:

```
i - maxJump <= previous <= i - minJump
```

So `i` is reachable if `s[i] == '0'` and at least one index in that previous range is already reachable.

Checking that whole range for every index would be too slow. Instead, keep a sliding count of reachable previous indices that are currently allowed to jump into `i`.

## Approach

1. Set `reachable[0] = true`.
2. Iterate `i` from `1` to `n - 1`.
3. Add `reachable[i - minJump]` into the sliding window when that index becomes close enough to jump to `i`.
4. Remove `reachable[i - maxJump - 1]` when that index becomes too far away.
5. If `s[i] == '0'` and the sliding count is greater than `0`, mark `reachable[i] = true`.
6. Return `reachable[n - 1]`.

## Complexity

- **Time:** O(n) — each index enters and leaves the sliding window once
- **Space:** O(n) — for the reachable array

## Edge Cases

- Last index is `'1'` -> cannot be reached
- `minJump == maxJump` -> the window has at most one jump distance
- Long runs of `'1'` -> reachable count may be positive, but landing is still blocked
- Large input -> avoids O(n * jumpRange) scanning
