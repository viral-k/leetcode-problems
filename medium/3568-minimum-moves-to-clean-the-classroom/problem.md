# Minimum Moves to Clean the Classroom

**Difficulty:** Medium  
**LeetCode Link:** [Minimum Moves to Clean the Classroom](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/)

## Description

You are given an `m x n` grid `classroom` where a student volunteer is tasked with cleaning up litter scattered around the room. Each cell in the grid is one of the following:

- `'S'`: Starting position of the student
- `'L'`: Litter that must be collected (once collected, the cell becomes empty)
- `'R'`: Reset area that restores the student's energy to full capacity, regardless of their current energy level (can be used multiple times)
- `'X'`: Obstacle the student cannot pass through
- `'.'`: Empty space

You are also given an integer `energy`, representing the student's maximum energy capacity. The student starts with this energy from the starting position `'S'`.

Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. If the energy reaches 0, the student can only continue if they are on a reset area `'R'`, which resets the energy to its maximum capacity `energy`.

Return the minimum number of moves required to collect all litter items, or `-1` if it's impossible.

## Examples

### Example 1
```
Input: classroom = ["S.", "XL"], energy = 2
Output: 2
Explanation: (0,0) -> (0,1) -> (1,1), collecting the litter in 2 moves.
```

### Example 2
```
Input: classroom = ["LS", "RL"], energy = 4
Output: 3
Explanation: (0,1) -> (0,0) collects litter, -> (1,0) resets energy, -> (1,1) collects litter.
```

### Example 3
```
Input: classroom = ["L.S", "RXL"], energy = 3
Output: -1
Explanation: No valid path collects all 'L'.
```

## Constraints

- `1 <= m == classroom.length <= 20`
- `1 <= n == classroom[i].length <= 20`
- `classroom[i][j]` is one of `'S'`, `'L'`, `'R'`, `'X'`, or `'.'`
- `1 <= energy <= 50`
- There is exactly one `'S'` in the grid.
- There are at most 10 `'L'` cells in the grid.
