# Approach

**Tags:** `Array`, `Dynamic Programming`, `Greedy`

## Intuition

Buying an item type `i` for the first time is worth `1 + g_i` copies, where `g_i` is the number of other items whose factor is a multiple of `factor_i`. Every further copy of `i` is worth exactly `1`. So the purchase splits into two parts:

- **First copies:** a 0/1 choice per item, value `1 + g_i`, cost `price_i`. That is a 0/1 knapsack.
- **Extra copies:** each is worth 1, so the leftover budget should go to the cheapest item, `p_min`, giving `leftover // p_min` more copies.

For a set `S` of item types bought, the total is at most `value(S) + (budget - cost(S)) // p_min`, since every extra copy costs at least `p_min`. That bound is always reached by spending the leftover on the cheapest item. If the cheapest item isn't in `S`, its first copy is worth even more than 1, and that case is covered by the set that includes it. So the answer is the best value of that expression over all sets `S`.

## Approach

1. Count how many items have each factor value: `cnt[v]`.
2. `g_i = (sum of cnt[m] over multiples m of factor_i) - 1`, where the `-1` removes the item itself. Items with the same factor count each other, because `j != i` only excludes `i` itself.
3. 0/1 knapsack: `dp[c]` = the largest total of `1 + g_i` over chosen items with total price `<= c`.
4. Answer = `max over c of dp[c] + (budget - c) // p_min`.

## Complexity

- **Time:** O(n · budget + F log F), where `F = 1500` is the largest factor (harmonic sum over multiples)
- **Space:** O(budget + F)

## Edge Cases

- Nothing affordable (every price `> budget`): `dp` is all 0 and `budget // p_min = 0`, so the answer is 0
- Duplicate factors: two items with the same factor each give a free copy of the other
- Factor 1 divides everything, so that item's first copy is worth `n` copies
- Spending everything on the cheapest item can beat any first-copy bonus (cheap item, large budget). The `(budget - c) // p_min` term covers this.
