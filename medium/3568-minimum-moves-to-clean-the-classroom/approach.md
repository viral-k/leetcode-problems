# Approach

**Tags:** `Array`, `BFS`, `Bit Manipulation`, `Matrix`, `Graph`

## Intuition

Position alone isn't a state here — revisiting a cell is often necessary (to detour through a reset area, or to reach litter from a different side). What actually determines the future is the triple **(position, which litter is collected, current energy)**. With at most 10 litter cells the collected set fits in a bitmask, so the state space is manageable.

Since every move costs exactly 1, plain **BFS** finds the minimum move count — no weights, no priority queue needed.

The key pruning: **more energy is never worse.** If we've already reached `(r, c, mask)` with energy `e`, arriving there later with energy `<= e` can't lead to anything new — any continuation available to the weaker arrival is also available to the stronger one. So instead of treating energy as part of the visited key (which would give `20 * 20 * 2^10 * 51 ≈ 2 * 10^7` states), record only the **best energy seen per `(r, c, mask)`** and skip weaker arrivals. That drops it to `20 * 20 * 2^10 ≈ 4 * 10^5`.

Stepping onto `'R'` refills to maximum, which also subsumes the "if energy reaches 0 you may only continue from `R`" rule — a cell with 0 energy simply has no outgoing moves unless the refill already happened on arrival.

## Approach

1. Locate `'S'` and index every `'L'` cell (bit position per litter). Let `full = (1 << litterCount) - 1`. If there is no litter, return `0`.
2. `best[r][c][mask]` = highest energy seen in that state, initialised to `-1`; seed the start with full energy.
3. BFS level by level (each level is one move):
   - Skip states with `0` energy (they cannot move).
   - For each of the four neighbours that isn't `'X'`: `ne = e - 1`; if the destination is `'R'`, set `ne = energy`; if it is `'L'`, set its bit in `nmask`.
   - If `nmask == full`, return `moves + 1`.
   - Push the neighbour only if `ne > best[nr][nc][nmask]`, updating that entry.
4. If the queue drains, return `-1`.

## Complexity

- **Time:** O(m * n * 2^L) states, each expanding 4 neighbours — about 1.6 * 10^6 transitions at the limits
- **Space:** O(m * n * 2^L) — the `best` table

## Edge Cases

- No litter in the grid → `0` moves
- Litter unreachable, or reachable only by running out of energy mid-route → `-1` (Example 3)
- Reset cells may be revisited any number of times, which the mask-based state naturally permits
- Energy must be checked *before* moving; a state at 0 energy is a dead end unless it arrived on an `'R'`
- Litter is collected on arrival, so a move that lands on the final `'L'` completes the run (hence returning `moves + 1`)
