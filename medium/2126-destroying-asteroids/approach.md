# Approach

**Tags:** `Array`, `Greedy`, `Counting Sort`

## Intuition

Destroying an asteroid only increases the planet's mass. Therefore, it is always safe to destroy the smallest remaining asteroid first.

If the planet cannot destroy the smallest remaining asteroid, then it cannot destroy any larger remaining asteroid either. No valid order exists in that case.

The asteroid masses are bounded by `10^5`, so we do not need comparison sorting. Instead, count how many asteroids have each mass and process possible masses in ascending order.

## Approach

1. Create a frequency array where `frequency[value]` is the number of asteroids with that mass.
2. Iterate possible asteroid masses in ascending order.
3. For each mass with at least one asteroid:
   - if the planet's current mass is smaller, return `false`
   - otherwise, destroy all asteroids of this mass and add `mass * frequency[mass]` to the planet
4. Return `true` after all masses are processed.

## Complexity

Let `M` be the maximum asteroid mass. Here, `M <= 10^5`.

- **Time:** O(n + M) — build the frequency array, then scan possible masses
- **Space:** O(M) — for the frequency array

## Edge Cases

- Planet mass exactly equals an asteroid's mass -> collision succeeds
- The smallest asteroid is too large -> return `false` immediately
- Multiple asteroids have the same mass -> absorb them as one batch
- One asteroid -> compare it directly with the planet's mass
- Large accumulated mass -> use a wide integer type in Java
