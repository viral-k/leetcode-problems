# Approach

**Tags:** `Array`, `Depth-First Search`, `Breadth-First Search`, `Matrix`

## Intuition

Each island is a connected group of positive cells, so one flood fill per island
finds all of its cells. The only thing we need from each island is its total
value, and only modulo `k`.

The total can be as large as 10^5 cells times 10^6, which is 10^11. That does not
fit a Java `int`. Keeping the running total modulo `k` avoids the problem: the
stored remainder is below `k <= 10^6`, and adding one more cell keeps it under
2 * 10^6. Whether a number is divisible by `k` depends only on its remainder, so
this changes nothing about the answer.

## Approach

1. Scan every cell. When a cell is positive, start a flood fill from it using an
   explicit stack. Take its value mod `k` as the island's running remainder and
   set the cell to 0 so it is not visited again.
2. For each cell popped, look at its neighbours (up, down, left, right). For each
   positive one, add its value to the remainder mod `k`, set it to 0, and push it.
3. When the stack is empty, count the island if the remainder is 0.

A cell's value is added at the moment it is pushed, because that is the last
time it is read before being set to 0.

## Complexity

- **Time:** O(m * n) — each cell is pushed at most once
- **Space:** O(m * n) in the worst case for the stack; the grid itself records
  which cells have been visited

## Edge Cases

- `k = 1` → every island counts
- No land → 0
- A single island covering the whole grid with total up to 10^11 → the remainder
  stays small because it is reduced every step
- Cells with value 0 are water, not land with zero value, so they never join or
  split anything
- Diagonal neighbours do not connect cells; example 2 has six single-cell
  islands for this reason
- One island can have 10^5 cells, so a recursive fill would exceed Python's
  recursion limit
- The input grid is modified in place
