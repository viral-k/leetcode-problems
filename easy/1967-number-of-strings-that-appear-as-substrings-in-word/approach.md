# Approach

**Tags:** `Array`, `String`, `String Matching`

## Intuition

Just count how many patterns occur as a substring of `word`. With everything bounded by 100, a direct substring check per pattern is more than fast enough.

## Approach

1. For each pattern, test whether it is a substring of `word` (`p in word` / `word.contains(p)`).
2. Count the ones that are.

## Complexity

- **Time:** O(n · |word| · |pattern|) worst case for naive substring search; trivially small here
- **Space:** O(1)

## Edge Cases

- Duplicate patterns each count separately (Example 3)
- Pattern longer than `word` → never a substring
- Single-character patterns → simple membership check
