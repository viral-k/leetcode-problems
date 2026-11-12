-- 262. Trips and Users
-- Time: O(n log n) for the grouping (O(n) with hash joins and hash aggregation)
-- Space: O(n)

SELECT
    t.request_at AS Day,
    -- the comparison is 1 for a cancelled trip and 0 for a completed one, so
    -- its average is cancelled / total for the day
    ROUND(AVG(t.status <> 'completed'), 2) AS `Cancellation Rate`
FROM Trips AS t
-- both joins are inner, so a trip with either side banned drops out here
JOIN Users AS c
    ON c.users_id = t.client_id AND c.banned = 'No'
JOIN Users AS d
    ON d.users_id = t.driver_id AND d.banned = 'No'
WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at;
