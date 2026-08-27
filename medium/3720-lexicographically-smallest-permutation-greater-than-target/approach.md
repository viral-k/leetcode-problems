# Approach

**Tags:** `String`, `Greedy`, `Counting`, `Sorting`

## Intuition

Only the **multiset** of letters in `s` matters, since any arrangement is allowed. Every candidate answer has the same shape:

```
target[0..p-1]  +  c  +  (everything left over, sorted ascending)
```

where the first `p` characters copy `target` exactly, `c` is strictly greater than `target[p]`, and the tail is sorted to make the suffix as small as possible.

**A longer shared prefix is always better.** Suppose one candidate deviates at position `p` and another at an earlier `p' < p`. At index `p'`, the first candidate holds `target[p']` while the second holds something strictly greater — so the first is smaller, regardless of what follows. Hence: maximize `p`.

That gives a clean search order — find the longest prefix of `target` that `s`'s letters can actually spell, then walk `p` downward until a valid deviation character exists.

## Approach

1. Count the letters of `s` into a 26-slot array.
2. **Longest match:** walk `target` left to right, consuming `target[i]` from the counts while it is available. Let `maxMatch` be how far this got.
3. **Search `p` from `maxMatch` down to `0`:**
   - Keep the counts in sync — moving from `p+1` to `p` means returning `target[p]` to the pool.
   - Skip `p == n` (a full match leaves no position to raise, and equal is not "strictly greater").
   - Look for the smallest available letter `c > target[p]`. If one exists, consume it and return `target[:p] + c + <remaining letters in ascending order>`.
4. If no `p` yields a deviation, return `""`.

## Complexity

- **Time:** O(26n) — each `p` scans at most 26 letters, plus O(n) to emit the answer
- **Space:** O(n) — the counts array and the output string

## Edge Cases

- `s` can spell `target` exactly (`maxMatch == n`) → must still deviate earlier, so start the search at `p = n - 1` (Example 3 exhausts every `p` and returns `""`)
- The largest permutation of `s` is `<= target` → `""`
- Deviating at `p = 0` is valid when the smallest letter greater than `target[0]` exists (Example 2)
- Duplicate letters are handled naturally by counts rather than a set
- The tail must be sorted ascending, not left in input order
