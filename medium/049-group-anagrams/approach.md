# Approach

**Tags:** `Array`, `Hash Table`, `String`, `Sorting`

## Intuition

Anagrams have the same character frequency. Use character count as a key to group strings together.

## Solution

1. **Character count as key**: For each string, compute a frequency array of 26 integers (one per letter).

2. **Convert to hashable key**: Convert the frequency array to a tuple (Python) or string (Java) to use as a hash map key.

3. **Group by key**: Strings with the same key are anagrams — append them to the same list.

4. **Return all groups**: Return all values from the hash map.

### Why Character Count over Sorting?

- Sorting each string: O(k log k) per string
- Character count: O(k) per string
- For long strings, counting is faster

## Complexity

- **Time:** O(n × k) where n = number of strings, k = max string length
- **Space:** O(n × k) — storing all strings in the hash map

## Edge Cases

- Empty string `""` → valid anagram group of its own
- Single character strings
- All strings are anagrams → single group
- No anagrams → each string is its own group
