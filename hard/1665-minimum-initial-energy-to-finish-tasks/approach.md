# Approach

**Tags:** `Array`, `Greedy`, `Sorting`

## Intuition

Each task has two values:

- `actual`: energy consumed
- `minimum`: energy required before starting

The risky tasks are those with large unused requirement, meaning `minimum - actual` is large. These tasks need a high energy level to start but do not consume as much as they require. Doing them earlier preserves feasibility for the rest.

So sort tasks by descending `minimum - actual`.

## Greedy Reasoning

Consider two tasks `A` and `B`.

If we do `A` before `B`, the required initial energy must cover:

`max(A.minimum, A.actual + B.minimum)`

If we do `B` before `A`, it must cover:

`max(B.minimum, B.actual + A.minimum)`

Doing `A` first is no worse when:

`A.minimum - A.actual >= B.minimum - B.actual`

Therefore tasks should be ordered by descending `minimum - actual`.

## Approach

1. Sort tasks by descending `minimum - actual`.
2. Track:
   - `initial`: total initial energy added so far
   - `current`: current available energy during simulation
3. For each task:
   - if `current < minimum`, add the difference to both `initial` and `current`
   - complete the task by subtracting `actual` from `current`
4. Return `initial`.

## Complexity

- **Time:** O(n log n) — sorting dominates
- **Space:** O(1) extra, ignoring sorting implementation details

## Edge Cases

- One task -> answer is its `minimum`
- Tasks where `actual == minimum`
- Large number of tasks -> sorting is required, simulation is linear
