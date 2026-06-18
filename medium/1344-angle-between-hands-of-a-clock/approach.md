# Approach

**Tags:** `Math`, `Geometry`

## Intuition

Each hand has a fixed angular speed, so we can compute the exact angle of each hand from the 12 o'clock position and take the difference. The only subtlety is that the hour hand also moves as the minutes pass — it is not fixed at the hour mark.

## Approach

1. The minute hand sweeps a full `360°` in 60 minutes, so it sits at `6 * minutes` degrees.
2. The hour hand sweeps `360°` in 12 hours = `30°` per hour, plus `0.5°` per minute. Using `hour % 12` (so `12` maps to `0`), it sits at `30 * (hour % 12) + 0.5 * minutes` degrees.
3. Take the absolute difference of the two angles.
4. The hands form two angles summing to `360°`; return the smaller one: `min(diff, 360 - diff)`.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Edge Cases

- `hour = 12` -> treat as `0` via `hour % 12`
- `minutes = 0` -> hour hand exactly on the hour mark
- Difference exactly `180°` -> both `diff` and `360 - diff` are `180`, returns `180`
- Hour hand past the mark (e.g. 3:30) -> the `0.5 * minutes` term accounts for it
