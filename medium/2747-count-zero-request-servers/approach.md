# Approach

**Tags:** `Array`, `Hash Table`, `Sliding Window`, `Sorting`

## Intuition

Each query asks how many distinct servers appear in the time window `[q - x, q]`, and the answer is `n` minus that. Handled one by one, each query would scan the logs. But every window has the same length, so if the queries are answered in increasing order, each window's start and end only move right. One sliding window over the sorted logs can answer all of them, as long as the results go back to each query's original position.

## Approach

1. Sort the logs by time, and sort the query indices by query value.
2. Keep `count[server]` for requests inside the window, and `active`, the number of servers with a non-zero count.
3. For each query `q` in sorted order:
   - add logs with `time <= q`, raising `active` when a count goes from 0 to 1;
   - remove logs with `time < q - x`, lowering `active` when a count goes from 1 to 0;
   - store `n - active` at the query's original index.

Every log with `time < q - x` also has `time <= q`, so it has already been added and the left pointer can't pass the right one.

## Complexity

- **Time:** O(m log m + q log q + n), where `m = len(logs)` and `q = len(queries)`. Each log is added and removed at most once
- **Space:** O(n + m + q)

## Edge Cases

- Both ends of the interval are inclusive: `time == q - x` and `time == q` both count, which is why removal uses `<` and addition uses `<=`
- A server with several requests in the window must count once, which is why `active` changes only on the 0 and 1 transitions
- No logs in the window: the answer is `n`
- Duplicate query values get the same answer and keep their own positions
- Query order differs from input order: answers are written back by original index
- Server ids are 1-based, so `count` has size `n + 1`
- A log later than every query is never added
