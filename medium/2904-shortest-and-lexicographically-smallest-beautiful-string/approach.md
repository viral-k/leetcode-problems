# Approach

**Tags:** `String`, `Sliding Window`, `Greedy`, `Two Pointers`

## Intuition

A beautiful substring can always be trimmed so it **starts and ends on a `1`**: stripping leading or trailing zeros keeps the count of ones the same while shortening the string, which is strictly better for the primary objective. So every candidate worth considering is delimited by two ones.

That means only the positions of the ones matter. If `ones` lists those indices, then choosing `k` ones necessarily means choosing `k` *consecutive* entries `ones[i .. i+k-1]`, and the tightest substring containing them runs from `ones[i]` to `ones[i+k-1]`.

So there are only `len(ones) - k + 1` candidates to compare — one per window of `k` ones.

## Approach

1. Collect `ones` = indices where `s[i] == '1'`. If `len(ones) < k`, return `""`.
2. For each `i` in `0 .. len(ones) - k`:
   - The candidate spans `[ones[i], ones[i + k - 1]]`, with length `ones[i + k - 1] - ones[i] + 1`.
   - Track the best: shorter length wins; on equal length, the lexicographically smaller substring wins.
3. Return the best candidate.

## Complexity

- **Time:** O(n^2) worst case — O(n) windows, each substring extraction/comparison up to O(n)
- **Space:** O(n) — the `ones` list plus the current best substring

## Edge Cases

- Fewer than `k` ones in `s` → `""` (Example 3)
- `k == 1` → the answer is `"1"` whenever any one exists
- Equal-length candidates must be compared lexicographically, not just by position (Example 1 picks `"11001"` over other length-5 windows)
- Candidates always begin and end with `1`, so no trimming is needed afterward
- All-ones string → answer is `k` ones
