# Approach

**Tags:** `Math`, `Dynamic Programming`, `Game Theory`

## Intuition

This is a standard impartial win/lose game. A position with `i` stones is a **winning** position for the player to move if there exists *any* legal move leading to a **losing** position for the opponent. A position is losing if every move hands the opponent a win.

The base case is `i = 0`: no move is possible, so the player to move loses.

## Approach

1. `win[0] = false` (no moves available → the player to move loses).
2. For `i` from 1 to `n`: try every square `k^2 <= i`. If any `win[i - k^2]` is `false`, then removing `k^2` stones leaves the opponent in a losing position, so `win[i] = true`. If no such square exists, `win[i] = false`.
3. Return `win[n]`.

## Complexity

- **Time:** O(n * sqrt(n)) — each `i` tries about `sqrt(i)` squares (≈ 2 * 10^7 at n = 10^5)
- **Space:** O(n) — the DP array

## Edge Cases

- `n = 1` → remove 1, opponent stuck → `true`
- `n = 2` → only move leaves 1 (a winning position for the opponent) → `false`
- Perfect squares → always `true` (take everything in one move)
- Break out of the inner loop on the first winning move found
