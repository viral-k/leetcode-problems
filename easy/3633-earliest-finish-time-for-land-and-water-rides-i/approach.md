# Approach

**Tags:** `Array`, `Brute Force`, `Simulation`

## Intuition

For each selected land ride and water ride, there are only two possible orders:

1. land ride, then water ride
2. water ride, then land ride

Once the order is fixed, starting the first ride as early as possible is always optimal. The second ride starts either immediately after the first finishes or when it opens, whichever is later.

## Approach

1. Initialize the answer to infinity.
2. For every land ride `i` and water ride `j`:
   - calculate the finish time when taking land ride `i` first:
     ```
     max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j]
     ```
   - calculate the finish time when taking water ride `j` first:
     ```
     max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i]
     ```
   - update the answer with the smaller finish time
3. Return the answer.

## Complexity

- **Time:** O(n * m) — check each land-water pair
- **Space:** O(1)

## Edge Cases

- One ride opens after the other has already finished -> wait until it opens
- Second ride is already open -> board immediately after the first ride
- Multiple pairs give the same earliest finish time
- One land ride and one water ride -> compare the two possible orders
