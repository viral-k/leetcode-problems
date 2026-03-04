# Approach

**Tags:** `Array`, `Hash Table`, `Sorting`

## Intuition

We need to find the maximum square that can be formed by selecting two horizontal fences and two vertical fences such that the distance between them is equal. The boundary fences (at positions 1 and m for horizontal, 1 and n for vertical) are always present and cannot be removed.

## Solution

1. **Include boundary fences**: Add positions 1 and m to horizontal fences, add 1 and n to vertical fences.

2. **Compute all possible distances**: For horizontal fences, compute all pairwise distances and store them in a set.

3. **Find common distances**: For each pairwise distance in vertical fences, check if the same distance exists in the horizontal set.

4. **Track maximum**: Keep track of the maximum distance that exists in both sets — this gives the maximum side length.

5. **Return result**: If a common distance exists, return `side²` mod `10^9 + 7`. Otherwise, return -1.

### Why This Works

- Removing fences between two positions creates a gap equal to their distance
- A square requires equal horizontal and vertical gaps
- We enumerate all possible gaps and find the largest common one

## Complexity

- **Time:** O(h² + v²) where h = len(hFences), v = len(vFences) — generating all pairwise distances
- **Space:** O(h²) — storing horizontal distances in a set

## Edge Cases

- No common distance exists → return -1
- Only boundary fences can form a square
- Large values require modulo operation on area (not side)
