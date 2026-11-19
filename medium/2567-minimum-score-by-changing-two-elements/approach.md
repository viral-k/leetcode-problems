# Approach

**Tags:** `Array`, `Greedy`, `Sorting`

## Intuition

The low score is a distraction. Whatever two elements get changed, set them to a value that is still in the array and lies between the remaining min and max. That makes a duplicate, so the low score is 0, and it doesn't widen the range. So the score is just `max - min` of the elements left untouched, and the question is which two elements to "remove" to make that range as small as possible.

Removing an element from the middle never shrinks the range. The two removals should come from the ends of the sorted order, which leaves three choices:

- remove the two smallest: `s[n-1] - s[2]`
- remove the two largest: `s[n-3] - s[0]`
- remove the smallest and the largest: `s[n-2] - s[1]`

## Approach

1. Find the three smallest values `a0 <= a1 <= a2` and the three largest `b0 >= b1 >= b2`. In sorted terms, `a_i = s[i]` and `b_i = s[n-1-i]`.
2. Return `min(b0 - a2, b2 - a0, b1 - a1)`.

Sorting does it in O(n log n), but only six values matter, so one pass is enough. Python uses `heapq.nsmallest(3)` and `nlargest(3)`, which are linear for a fixed count. Java keeps the six values in a single loop. The `<=` / `>=` comparisons make duplicates fill several slots.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- `n = 3` (example 2): change two elements to equal the third, answer 0. The formula gives `s[2] - s[2] = 0`.
- All values equal: every option is 0
- Duplicates among the extremes (`[1, 1, 1, 9, 9]`): removing the two 9s leaves all 1s, answer 0. The one-pass tracker has to record repeated values in separate slots.
- Which ends to drop depends on where the big gaps are: `[1, 2, 100, 101]` drops the low pair, `[1, 50, 100, 1000]` drops the high pair, and `[1, 10, 11, 20]` drops one from each end
- Differences stay below `10^9`, so `int` is fine
