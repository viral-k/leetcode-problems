# Approach

**Tags:** `String`, `Hash Table`, `Brute Force`

## Intuition

A balanced substring has all distinct characters appearing the same number of times. If we have `d` distinct characters each appearing `f` times, the length is `d * f`. So we check if `distinct * maxFreq == length`.

## Solution

1. **Enumerate all substrings**: For each starting index `i`, expand `j` from `i` to `n-1`.

2. **Track frequencies**: Maintain frequency array for 26 lowercase letters.

3. **Track distinct count and max frequency**:
   - `distinct` = number of characters with freq > 0
   - `maxFreq` = highest frequency among all characters

4. **Check balance condition**: If `distinct * maxFreq == length`, all characters appear exactly `maxFreq` times (balanced).

### Why This Works

If substring length = `distinct * maxFreq`, it means:
- We have exactly `distinct` unique characters
- Total characters = `distinct * maxFreq`
- This is only possible if each distinct character appears exactly `maxFreq` times

## Complexity

- **Time:** O(n²) — enumerate all substrings
- **Space:** O(1) — fixed size frequency array (26 chars)

## Edge Cases

- Single character → return 1 (trivially balanced)
- All same character → entire string is balanced
- All distinct characters → any substring is balanced
