# Approach

**Tags:** `Math`, `Simulation`

## Intuition

Nobody makes a choice in this game. The amounts are fixed (10 for Alice, then 9, 8, 7 and so on), so all that matters is how many of those moves fit in the pile. The player who faces a move that doesn't fit loses. If an odd number of moves was made, Alice made the last one and Bob is stuck, so Alice wins.

## Approach

1. Start with `take = 10` and a move count of 0.
2. While `n >= take`, remove `take` stones, lower `take` by 1 and count the move.
3. Return `true` if the count is odd.

## Complexity

- **Time:** O(1). `10 + 9 + ... + 4 = 49` and the next move needs 3 more, so at most 7 moves happen for `n <= 50`.
- **Space:** O(1)

## Edge Cases

- `n < 10`: Alice can't make her first move and loses (example 2)
- `n = 10` to `18`: Alice takes 10, Bob needs 9 and can't, so Alice wins (example 1)
- Boundaries: `n = 19` lets Bob move, and `n = 27` gives Alice a second move. The comparison has to be `>=`, since removing the exact number of remaining stones is allowed.
- Above 55 the next amount would reach 0, but the constraints stop at 50
