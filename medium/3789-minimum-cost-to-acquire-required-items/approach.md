# Approach

**Tags:** `Math`, `Greedy`

## Intuition

Only the number of type 3 items matters. Once that number `k` is fixed, the rest is forced: buy type 1 items for whatever of `need1` is still missing, and type 2 items for whatever of `need2` is still missing. So the cost is a function of one variable:

`f(k) = k * costBoth + max(0, need1 - k) * cost1 + max(0, need2 - k) * cost2`

Every term is linear or a `max(0, linear)`, so `f` is convex and piecewise linear. Its slope only changes at `k = need1` and `k = need2`, and going past `max(need1, need2)` only adds cost. A convex piecewise linear function on an interval reaches its minimum at an endpoint or a breakpoint.

## Approach

1. Let `lo = min(need1, need2)` and `hi = max(need1, need2)`.
2. Evaluate `f(0)`, `f(lo)` and `f(hi)`.
3. Return the smallest.

In greedy terms, `f(lo)` beats `f(0)` when `costBoth < cost1 + cost2`. Then `f(hi)` beats `f(lo)` when `costBoth` is also cheaper than the single-type item still needed for the leftover. Taking the min of the three covers all of these cases without branching.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Edge Cases

- `need1 = need2 = 0`: every candidate is `f(0) = 0`
- One need is 0: `lo = 0`, so the choice is between buying no type 3 items and covering everything with them
- `costBoth` cheaper than one single item (example 1): type 3 items also cover the leftover of the larger need, so `k = hi`
- `costBoth >= cost1 + cost2` (example 2): never buy type 3, so `k = 0`
- The answer can reach about `10^9 * 2 * 10^6 = 2 * 10^15`, so Java must use `long` for every product
