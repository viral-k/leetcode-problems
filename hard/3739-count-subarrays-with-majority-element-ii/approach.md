# Approach

**Tags:** `Array`, `Prefix Sum`, `Counting`

## Intuition

`target` is the majority of a subarray iff it appears strictly more than half the time. Map every element to `+1` if it equals `target`, else `-1`. Then in a subarray, `(#target) - (#non-target) > 0` exactly captures "strict majority". So a subarray is valid iff its **transformed sum is strictly positive**.

With prefix sums `s[0..n]` (`s[0] = 0`), the subarray `(j, k]` has sum `s[k] - s[j]`. It is valid iff `s[k] > s[j]`. The answer is therefore the number of index pairs `j < k` with `s[j] < s[k]`.

## Approach (O(n))

The prefix sum changes by exactly `±1` each step, so the count of "earlier prefixes strictly less than the current one" can be maintained incrementally instead of re-queried.

- `freq[v]` — how many prefix sums seen so far equal value `v` (shifted by `n` to stay a valid index). Start `freq[n] = 1` for `s[0] = 0`.
- `i` — the current prefix sum (shifted). Start `i = n` (`s = 0`).
- `pref` — the number of earlier prefixes strictly less than the current value. This is exactly the number of valid subarrays ending at the current position.

Each step:

- **`num == target`** (prefix goes up, `i → i+1`): the "strictly less" threshold loosens by one level, so prefixes equal to the old `i` now count: `pref += freq[i]; i += 1`.
- **`num != target`** (prefix goes down, `i → i-1`): the threshold tightens, so prefixes equal to the new level drop out: `i -= 1; pref -= freq[i]`.

Then register the current prefix (`freq[i] += 1`) and bank the count (`res += pref`).

Because each update touches a single bucket, the whole sweep is O(n).

## Complexity

- **Time:** O(n)
- **Space:** O(n) — the frequency array of size `2n + 1`

## Edge Cases

- `target` absent → all transformed values `-1`, prefix sums strictly decreasing, no valid pair → 0
- All equal `target` → strictly increasing prefix sums → every pair counts → n*(n+1)/2
- Single `[target]` → s = [0, 1], one valid pair → 1
- Use `long` for the answer and `pref` in Java (answer can reach ~5·10⁹ for n = 10⁵)

## Note

An equivalent O(n log n) version counts the same prefix-sum pairs with a Fenwick (BIT) tree. The O(n) method above is strictly better, relying on the fact that the prefix sum only moves by `±1` per step.
