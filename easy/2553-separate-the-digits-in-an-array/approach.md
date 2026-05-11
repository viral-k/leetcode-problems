# Approach

**Tags:** `Array`, `Simulation`

## Intuition

The result must preserve both orders:

1. the order of numbers in `nums`
2. the left-to-right order of digits inside each number

Converting each number to a string gives the digits directly in the required order.

## Approach

1. Initialize an empty result array.
2. For each number in `nums`:
   - convert it to a string
   - iterate over its characters
   - convert each character back to an integer and append it
3. Return the result.

## Complexity

- **Time:** O(d) — where `d` is the total number of digits across all numbers
- **Space:** O(d) — for the returned answer

## Edge Cases

- Single-digit numbers remain unchanged
- Multi-digit numbers are expanded in-place order
- Values like `100000` include zero digits in the result
