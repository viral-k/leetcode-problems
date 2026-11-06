# Approach

**Tags:** `Array`, `Sliding Window`, `Heap (Priority Queue)`

## Intuition

A heap gives O(n log n), but most of what it stores is useless. If a new element `b` arrives and an older element `a` in the window has `a <= b`, then `a` can never be a maximum again: `b` is at least as large and stays in the window longer. So only elements with nothing as large to their right matter. Those form a strictly decreasing sequence, and its first element is the window's maximum.

## Approach

Keep a deque of indices whose values strictly decrease from front to back. For each index `i`:

1. Pop the front if it has left the window, meaning it equals `i - k`.
2. Pop from the back while `nums[back] <= nums[i]`.
3. Push `i` on the back.
4. Once `i >= k - 1`, record `nums[front]`.

## Complexity

- **Time:** O(n), since each index is pushed once and popped at most once
- **Space:** O(k) for the deque, plus the output

## Edge Cases

- `k == 1`: every element is its own window, and the deque never holds more than one index
- `k == n`: a single window, so the output has one value
- Duplicates: popping on `<=` keeps the newer copy, which stays in the window longer
- Increasing input: each new element clears the deque
- Decreasing input: the deque fills to `k` and only the front expiry removes elements
