# Approach

**Tags:** `Database`

## Intuition

A trip counts only if both its client and its driver are unbanned. That is two lookups into the same `Users` table, so join it twice under different aliases, once on `client_id` and once on `driver_id`, with `banned = 'No'` in each join condition. Inner joins drop every trip that fails either check, and what remains is exactly the set of requests the rate is defined over.

After that it is a per-day average. In MySQL a comparison evaluates to 1 or 0, so `AVG(status <> 'completed')` is the number of cancelled trips divided by the number of trips that day. There is no need for two `COUNT`s and a division.

## Approach

1. Join `Trips` to `Users AS c` on `c.users_id = client_id AND c.banned = 'No'`.
2. Join to `Users AS d` on `d.users_id = driver_id AND d.banned = 'No'`.
3. Keep `request_at BETWEEN '2013-10-01' AND '2013-10-03'`. The dates are `YYYY-MM-DD` strings, so string comparison matches date order.
4. `GROUP BY request_at` and select `ROUND(AVG(status <> 'completed'), 2)` as `` `Cancellation Rate` ``.

## Complexity

- **Time:** O(n log n) for the grouping (O(n) with hash joins and hash aggregation)
- **Space:** O(n)

## Edge Cases

- A banned driver excludes the trip just like a banned client; the example only shows banned clients
- Both cancellation statuses count: `status <> 'completed'` covers `cancelled_by_driver` and `cancelled_by_client`
- A day whose trips all involve a banned user has no rows after the joins, so it does not appear in the output (not as `0.00`)
- A day with no cancellations shows `0.00`, not a missing row
- Days outside `2013-10-01` to `2013-10-03` are ignored even if they have trips
- The output column name contains a space, so it needs backticks in MySQL
