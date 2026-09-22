# Approach

**Tags:** `Array`, `Math`, `Segment Tree`

## Intuition

After dropping the prefix, the remaining choices are the non-empty prefixes of `nums[start..]`. So each query asks: among prefixes of a suffix of the array, how many have product `≡ x (mod k)`? With point updates mixed in, that calls for a structure whose segments can be merged.

The information a segment needs is small because `k <= 5`: its total product mod `k`, and a histogram of the residues of its own prefix products. Two adjacent segments merge cleanly. The left segment's prefixes are unchanged. Each prefix of the right segment becomes a prefix of the combined segment after being multiplied by the left segment's full product, which just permutes (or collapses) its residue.

## Approach

Segment tree over `nums`, each node holding `prod` and `cnt[0..k-1]`.

- **Leaf** for value `v`: `prod = v % k`, `cnt[prod] = 1`.
- **Merge** `(L, R)`: `prod = L.prod * R.prod % k`; `cnt = copy of L.cnt`; for each residue `x`, `cnt[L.prod * x % k] += R.cnt[x]`.
- **Update** `index -> value`: rewrite the leaf, recompute ancestors.
- **Query** `[start, n-1]`: fold the covering nodes left to right with the same merge (order matters since multiplication by `L.prod` is applied to the right part only), then answer `cnt[x]`.

The iterative bottom-up tree keeps a left accumulator and a right accumulator so the fold stays ordered without recursion.

## Complexity

- **Time:** O((n + q) * k * log n) — build is O(n * k), each update and query touches O(log n) nodes with an O(k) merge
- **Space:** O(n * k) for the tree

## Edge Cases

- `k = 1` → every prefix has residue 0, answer is `n - start` when `x = 0`
- `start = n - 1` → only the single-element choice remains
- Updates that do not change the value still run through the same path; no special case needed
- Values up to `10^9` are reduced mod `k` at the leaf so products never grow
- A residue of 0 anywhere in the retained prefix pins all longer prefixes to 0; the merge handles this automatically via `L.prod = 0`
- Counts fit in `int` (at most `n = 10^5` per query), unlike the sister problem which counts all subarrays
