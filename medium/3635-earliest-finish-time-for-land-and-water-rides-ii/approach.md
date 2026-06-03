# Approach

**Tags:** `Array`, `Binary Search`, `Sorting`, `Prefix Minimum`, `Suffix Minimum`

## Intuition

If the first ride finishes at time `t`, then the best second ride from another category has two cases:

- rides already open at or before `t`: finish time is `t + duration`, so choose the minimum duration among those rides
- rides opening after `t`: finish time is `start + duration`, so choose the minimum finish time among those rides

This means each category can be preprocessed into a structure that answers:

```
best finish time if this category is taken after time t
```

Then try every land ride as the first ride and query the best water ride after it, and every water ride as the first ride and query the best land ride after it.

## Approach

For one ride category:

1. Pair each ride as `(start, duration)` and sort by `start`.
2. Build `starts`, the sorted start times.
3. Build `prefixMinDuration`, where `prefixMinDuration[i]` is the minimum duration among rides `0..i`.
4. Build `suffixMinFinish`, where `suffixMinFinish[i]` is the minimum `start + duration` among rides `i..end`.

To answer a query time `t`:

1. Binary search the last ride with `start <= t`.
2. If such a ride exists, candidate finish is `t + prefixMinDuration[index]`.
3. If there is a later ride, candidate finish is `suffixMinFinish[index + 1]`.
4. Return the smaller candidate.

Finally:

1. Preprocess land rides and water rides separately.
2. For each land ride, compute its finish time and query the water structure.
3. For each water ride, compute its finish time and query the land structure.
4. Return the minimum result.

## Complexity

- **Time:** O((n + m) log(n + m)) — sorting plus binary searches for all first rides
- **Space:** O(n + m) — preprocessed arrays for both categories

## Edge Cases

- All second-category rides are already open -> prefix minimum duration handles this
- No second-category ride is open yet -> suffix minimum finish handles waiting
- First ride finish exactly equals a second ride's start -> it counts as already open
- Only one ride in either category -> query helper still works
