# Approach

**Tags:** `Array`, `Greedy`, `Sorting`

## Intuition

To minimize the total payment, we want the free candies to be as expensive as possible.

Sort candy costs from highest to lowest. In each group of three, pay for the two most expensive candies and take the third candy for free. The free candy is valid because its cost is less than or equal to both candies bought before it.

## Approach

1. Sort `cost` in descending order.
2. Iterate through the sorted costs.
3. Add a candy's cost to the answer unless its index is the third position in a group, where `index % 3 == 2`.
4. Return the total.

## Complexity

- **Time:** O(n log n) — sorting dominates
- **Space:** O(1) extra, ignoring sorting implementation details

## Edge Cases

- Fewer than three candies -> pay for all candies
- Exactly three candies -> cheapest candy is free
- Number of candies is not divisible by three -> remaining one or two candies must be paid for
- Equal candy costs -> any valid grouping gives the same result
