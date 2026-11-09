# Approach

**Tags:** `Array`, `Heap (Priority Queue)`, `Simulation`

## Intuition

Each request needs two things fast: release the servers whose work has finished, and find the first free server going clockwise from `i % k`. The first is a min-heap on end time. The second is usually an ordered set with a `ceiling` lookup plus a wrap-around, but a plain min-heap also works if each free server is stored under a shifted key instead of its id.

When server `id` becomes free during request `i`, store it as `i + (id - i) mod k`: the first request number at or after `i` that would map straight to `id`. Every key in the free heap stays `>= i` while request `i` is handled. Released keys are pushed at `>= i`, and each request removes the smallest key, so the rest are larger and remain `>= i + 1` for the next one. Each key is also below `i + k` (it was pushed at some `i0 <= i` and is below `i0 + k`). So `key - i` is exactly the clockwise distance from `i % k` to the server, and the heap minimum is the server the rules ask for.

## Approach

1. `free` starts as `0, 1, ..., k - 1`, which are the keys for request 0. `busy` is a min-heap of `(end time, server)`.
2. For each request `i` with arrival `a` and load `l`:
   - pop every `busy` entry with end time `<= a` and push its server as `i + (id - i) % k`;
   - if `free` is empty, drop the request;
   - otherwise pop the smallest key, take server `key % k`, add 1 to its count, and push `(a + l, server)` to `busy`.
3. Return every server whose count equals the maximum.

## Complexity

- **Time:** O(n log k), where `n = len(arrival)`. Every request pushes and pops each heap at most once, and both heaps hold at most `k` entries
- **Space:** O(k)

## Edge Cases

- A server finishing exactly when a request arrives (`end == arrival`) is free for it
- All servers busy: the request is dropped and changes nothing
- Wrap-around: if every server from `i % k` to `k - 1` is busy, the search continues from server 0. The shifted keys handle this with no special case
- `k == 1`: every key is a multiple of 1, so it reduces to "is the server free"
- Ties for the most requests: return all of them, in any order
- End times reach `2 * 10^9`, past `int`, so Java packs `(end, server)` into a `long`
