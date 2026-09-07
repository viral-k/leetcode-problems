# Approach

**Tags:** `String`, `Dynamic Programming`, `Counting`

## Intuition

Counting subsequences is easy; counting **distinct** ones is the hard part, because a repeated letter regenerates subsequences that were already counted. The fix is to bucket the count by **last character**.

Let `ending[c]` = the number of distinct subsequences that end in character `c`. Every distinct non-empty subsequence ends in exactly one letter, so the answer is `sum(ending)` — the buckets partition the set, no double counting by construction.

Now process `s` left to right. When the current character is `c`, the subsequences ending in `c` that can exist using everything seen so far are:

- every distinct subsequence built so far, with `c` appended → `total` of them, and
- the single-character subsequence `"c"` itself.

so `ending[c] = total + 1`.

The key move is that this **overwrites** `ending[c]` rather than adding to it. Any subsequence ending in `c` that an earlier occurrence of `c` produced is produced again here (the earlier occurrence's reachable set is a subset of this one's), so replacing the bucket discards exactly the duplicates. That single assignment is what makes the count distinct — and it's why `"aaa"` gives 3 rather than 7.

## Approach

1. Keep `ending[26]` (all zero) and a running `total = 0`.
2. For each character `c` in `s`:
   - `updated = total + 1`
   - `total = total - ending[c] + updated` (subtract the stale bucket, add the new one)
   - `ending[c] = updated`
3. Return `total` modulo `10^9 + 7`.

All arithmetic is done mod `10^9 + 7`; because the update subtracts, add the modulus before taking the remainder to avoid a negative value.

## Complexity

- **Time:** O(n) — one pass, O(1) work per character
- **Space:** O(26) = O(1)

## Edge Cases

- All identical characters (Example 3) → each step overwrites the same bucket, giving exactly `n`
- Single character → 1
- All distinct characters → `2^n - 1` (every non-empty subset is distinct)
- The empty subsequence is excluded, which is why the `+1` counts only `"c"` itself and no empty seed is added
- The subtraction step must be modulus-safe: `(total - ending[c] + MOD) % MOD`
