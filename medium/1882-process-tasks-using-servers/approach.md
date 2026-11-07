# Approach

**Tags:** `Array`, `Heap (Priority Queue)`

## Intuition

At any moment, two questions need fast answers: which idle server has the smallest `(weight, index)`, and when does the next busy server become free. Each is a heap. The queue itself never needs storing, because tasks are assigned strictly in order. Task `j` starts at whichever is later: its arrival second `j`, or the start time of task `j - 1`.

## Approach

1. Put every server in `free`, keyed by `(weight, index)`. `busy` starts empty and is keyed by `(free time, index)`.
2. Keep a clock `t = 0`. For each task `j`:
   - `t = max(t, j)`;
   - move every server in `busy` whose free time is `<= t` into `free`;
   - if `free` is still empty, jump `t` to the smallest free time in `busy` and move every server freeing at that second;
   - pop the best server from `free`, record its index, and push it to `busy` with free time `t + tasks[j]`.
3. Pack each key into a single integer (`major * 2^18 + index`, since indices are below `2^18`) so the heaps compare plain numbers.

## Complexity

- **Time:** O((n + m) log n): each task does one pop and one push, and each release is paid for by an earlier push
- **Space:** O(n + m) for the heaps and the answer

## Edge Cases

- A queued task starts late: if task `j - 1` waited until second `T > j`, task `j` starts at `T` too. Using `j` as its start would make its server look free too early
- Several servers free at the same second: all of them are released before choosing, so weight and index decide the order, not release order
- A server freeing exactly at second `t` is available at `t` (`<=`, not `<`)
- Equal weights: the lower index wins, which the packed key handles
- One server: every task waits for it
- Free times reach about `2 * 10^5 + 2 * 10^5 * 2 * 10^5 = 4 * 10^10`, and after packing about `10^16`, so Java uses `long`
