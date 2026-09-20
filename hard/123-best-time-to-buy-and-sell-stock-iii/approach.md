# Approach

**Tags:** `Array`, `Dynamic Programming`

## Intuition

At most two transactions means the trader passes through at most five states in order: nothing, holding the first share, sold it, holding the second share, sold it. Track the best cash balance reachable in each of the four action states, and update all four as each day's price arrives. Cash after a buy is negative (you paid), cash after a sell adds the price back.

The order of the updates within a day matters only in that it lets a later state read the same day's earlier state. That allows buying and selling on the same day, which nets 0 and never changes the optimum, so it is harmless and keeps the code to a single pass with no lookback.

## Approach

For each price `p`:

```
buy1  = max(buy1,  -p)
sell1 = max(sell1, buy1 + p)
buy2  = max(buy2,  sell1 - p)
sell2 = max(sell2, buy2 + p)
```

Start `buy1 = buy2 = -inf` and `sell1 = sell2 = 0`. Return `sell2`. Since a second transaction of zero profit is always available, `sell2 >= sell1 >= 0`, so it already covers doing one or zero transactions.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- Single day → no transaction possible, 0
- Strictly decreasing prices → 0 (Example 3)
- Strictly increasing → one long transaction beats splitting it (Example 2)
- Two separate rises with a dip between → two transactions (Example 1)
- Price 0 is allowed; `buy` states can be exactly 0 and still valid
- `-inf` initial values must not be added to a price before being replaced; the `max` with `-p` on day one handles that
