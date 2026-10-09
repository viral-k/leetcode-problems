# Approach

**Tags:** `Array`, `Dynamic Programming`

## Intuition

At most `k` transactions means a trader passes through `2k + 1` states in order: idle, holding share 1, sold share 1, holding share 2, and so on. Track the best cash balance reachable in each state and update them all as every price arrives. Cash goes negative on a buy and recovers on a sell, so the final answer is the balance after the last completed sale.

This is problem 123 with `k` as a parameter instead of a hard-coded 2, and the recurrence is the same shape: the j-th buy can only be funded by the proceeds of the (j-1)-th sale, which is what chains the transactions and forbids overlap.

One case deserves separating out. A transaction needs at least two days, so `n` days admit at most `n / 2` of them. Once `k` reaches that, the cap is no longer a constraint and the problem collapses to "take every rise", which is the sum of positive consecutive differences. Without that branch the DP would allocate and sweep `k` states per day while most of them can never be used.

## Approach

1. If `prices` is shorter than 2, return 0.
2. If `k >= n // 2`, return `sum(max(0, prices[i] - prices[i-1]))` over all `i`.
3. Otherwise keep `buy[1..k]` initialised to negative infinity and `sell[0..k]` to 0. For each price `p`, for `j` from 1 to `k`:
   - `buy[j] = max(buy[j], sell[j-1] - p)`
   - `sell[j] = max(sell[j], buy[j] + p)`
4. Return `sell[k]`.

`sell[0]` stays 0 and represents doing nothing, which is what lets the first buy start from a zero balance. Since each `sell[j]` can always decline to trade, `sell[k] >= sell[k-1] >= ... >= 0`, so the answer already covers using fewer than `k` transactions.

## Complexity

- **Time:** O(n * k), or O(n) when the unlimited branch applies
- **Space:** O(k)

## Edge Cases

- Single day, or `prices` of length 1 → 0, no transaction is possible
- Strictly decreasing prices → 0
- Strictly increasing prices → one transaction captures the whole rise; splitting it gains nothing
- `k` larger than `n / 2` → the unlimited branch; e.g. `k = 100` with 3 prices
- `k = 1` reduces to the single-transaction problem
- Price 0 is allowed, so a `buy` state can legitimately hold the value 0
- The `-inf` initial buy values must not be added to a price before being replaced; taking `max` with `sell[j-1] - p` on day one handles that
- Max profit here is bounded by `1000 * 500`, comfortably inside `int`
