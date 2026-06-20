# Approach

**Tags:** `Array`, `Math`, `Greedy`

## Intuition

Because adjacent buildings can differ by at most 1, the height at a building is bounded by how far it is from any fixed-height constraint. Each restricted building acts as a "checkpoint": the height anywhere can rise or fall at most 1 per step away from a checkpoint.

Once all checkpoints have their true effective caps (after propagating constraints in both directions), the highest point achievable between any two consecutive checkpoints is determined purely by climbing from both ends and meeting in the middle.

## Approach

1. **Anchor**: add `[1, 0]` to the restrictions (building 1 is always 0) and sort by building id.
2. **Forward pass**: propagate the left-side reachability cap to each checkpoint:
   ```
   h[i] = min(h[i], h[i-1] + (id[i] - id[i-1]))
   ```
3. **Backward pass**: propagate from the right:
   ```
   h[i] = min(h[i], h[i+1] + (id[i+1] - id[i]))
   ```
4. **Peak between consecutive checkpoints** `(id1, h1)` and `(id2, h2)`: climb from both sides and meet at the top:
   ```
   peak = (h1 + h2 + (id2 - id1)) // 2
   ```
5. **Tail** from the last checkpoint to building `n` (no upper bound on the right):
   ```
   last_h + (n - last_id)
   ```
6. Return the maximum over all peaks and the tail.

## Complexity

- **Time:** O(r log r) — sorting the `r` restrictions; passes are O(r)
- **Space:** O(r) — the sorted restriction list

## Edge Cases

- No restrictions -> only `[1, 0]` anchor; answer is `n - 1`
- Last restriction is on building `n` -> tail contributes 0 beyond the last checkpoint
- `h1 + h2 + gap` can reach ~3 × 10^9 — use 64-bit integers in Java for this intermediate value
- Restriction cap higher than reachable height -> forward pass trims it to the true reachable value
