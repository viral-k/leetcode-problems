# Approach

**Tags:** `Array`, `Binary Search`, `Bit Manipulation`, `Math`, `Number Theory`, `Combinatorics`

## Intuition

Since denominations can't be mixed, coin `c` produces exactly the multiples of `c`. The set of reachable amounts is therefore the **union of the multiple-sets** of all coins.

`k` reaches 2 * 10^9, so the amounts can't be enumerated. But the number of reachable amounts `<= x` is easy to compute in closed form, and it's **monotone non-decreasing** in `x` — so binary search the smallest `x` whose count reaches `k`.

Counting the union needs **inclusion-exclusion**, because a value like 6 is counted by both coin 2 and coin 3. An amount is divisible by every coin in a subset `S` exactly when it's a multiple of `lcm(S)`, giving:

```
count(x) = sum over non-empty S of  (-1)^(|S|+1) * floor(x / lcm(S))
```

## Approach

1. **Prune redundant coins.** If coin `c` is a multiple of another coin `d`, every multiple of `c` is already a multiple of `d`, so `c` contributes nothing. (`[3,6,9]` collapses to `[3]`.) This matters a lot — the largest possible surviving set is an antichain under divisibility, which for values `1..25` is at most 13 coins, capping the subsets at 2^13 instead of 2^15.
2. **Search bound.** The smallest coin alone already yields `k` multiples by `k * min(coin)`, so that's a valid upper bound (at most 5 * 10^10).
3. **Precompute subset LCMs once**, pairing each with its inclusion-exclusion sign. Any subset whose LCM exceeds the upper bound contributes `floor(x / lcm) = 0` for every candidate `x`, so drop it during precomputation (this also stops the LCM from overflowing).
4. **Binary search** `x` in `[1, k * min(coin)]` for the smallest value with `count(x) >= k`.

## Complexity

- **Time:** O(2^m * log(k * minCoin)) where `m <= 13` is the pruned coin count — about 8191 * 36 ≈ 3 * 10^5 operations
- **Space:** O(2^m) — the precomputed LCM/sign terms

## Edge Cases

- A coin equal to `1` makes every integer reachable → answer is exactly `k`
- Single coin `c` → answer is `c * k` (up to 25 * 2 * 10^9 = 5 * 10^10)
- Coins that are multiples of one another (Example 1) → pruned away entirely
- **The answer exceeds 32-bit** (up to 5 * 10^10), so the return type and all intermediates must be `long`
- LCMs can overflow if computed unguarded; cap them against the search bound
