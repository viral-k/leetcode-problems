# Approach

**Tags:** `Array`, `Math`, `Dynamic Programming`, `Prefix Sum`, `Game Theory`, `Suffix Maximum`

## Intuition

The rules look like they mutate the row, but they don't really. Removing the leftmost `x` stones and pushing back a stone worth their sum leaves the row as:

```
[ P[x-1], stones[x], stones[x+1], ... ]
```

where `P[i]` is the prefix sum of `stones[0..i]`. The untouched suffix never changes, and the single replacement stone is always exactly a prefix sum. So no matter how the game unfolds, the state is captured by **one number: how far into the prefix we've consumed**.

That turns the game into something much simpler: a move is "advance to index `i` and score `P[i]`", and the opponent must then advance to some `j > i`. Alice's first move needs `x > 1`, so she starts from index `1`.

Since the same option set carries forward when a player declines to stop at `i`, the recurrence needs only a max over two choices.

## Approach

Let `dp[i]` = the best achievable score difference (current player minus opponent) when the player to move may pick any index `>= i`.

- **Base:** `dp[n-1] = P[n-1]` — at the last index the player must take everything remaining.
- **Transition:** `dp[i] = max(P[i] - dp[i+1], dp[i+1])`
  - `P[i] - dp[i+1]`: stop here, bank `P[i]`, and subtract whatever the opponent then achieves.
  - `dp[i+1]`: don't stop here; the position simply passes to the next index with the same player to move.

Answer: `dp[1]`.

Sweeping `i` from `n-2` down to `1` means only `dp[i+1]` is ever needed, so a single rolling variable replaces the array.

## Complexity

- **Time:** O(n) — one prefix-sum pass and one backward sweep
- **Space:** O(1) — a running prefix sum plus one rolling DP value (O(n) if prefix sums are materialized)

## Edge Cases

- `n == 2` → Alice is forced to take both stones (Example 3), so the answer is the total sum, possibly negative
- All-negative stones → Alice may still be forced into a negative score; the DP handles it
- Taking everything in one move can be optimal (Example 2)
- Sums stay within `int` (`10^5 * 10^4 = 10^9`), but `long` in Java is safer for the accumulation
- The starting index is `1`, not `0` — `x > 1` forbids removing a single stone
