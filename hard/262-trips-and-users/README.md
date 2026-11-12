# 262. Trips and Users

**Difficulty:** Hard  
**Topics:** `Database`  
**Complexity:** time O(n log n) for the grouping (O(n) with hash joins and hash aggregation), space O(n)

- **Write-up:** [yral.dev/leetcode/trips-and-users](https://yral.dev/leetcode/trips-and-users)
- **Problem:** [Trips and Users on LeetCode](https://leetcode.com/problems/trips-and-users/)

## Idea

A trip counts only if both its client and its driver are unbanned. That is two lookups into the same `Users` table, so join it twice under different aliases, once on `client_id` and once on `driver_id`, with `banned = 'No'` in each join condition. Inner joins drop every trip that fails either check, and what remains is exactly the set of requests the rate is defined over.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.sql](solution.sql) | SQL solution |
| [problem.md](problem.md) | Problem statement |
