# Approach

**Tags:** `String`, `Dynamic Programming`

## Intuition

At each step, decide which finger types the current character. Use DP to track the positions of both fingers and minimize total distance.

## Solution

### Key Insight

One finger always just typed the previous character. So we only need to track where the "other" finger is.

### State Definition

`dp[i][j]` = minimum cost to type first `i` characters where:
- One finger is at `word[i-1]` (just typed it)
- Other finger is at letter `j` (or `j = 26` means unused/free)

### Transition

For typing `word[i]`:

**Option 1:** Use the finger that typed `word[i-1]`
```
dp[i+1][j] = dp[i][j] + dist(word[i-1], word[i])
```

**Option 2:** Use the other finger (currently at position j)
```
dp[i+1][word[i-1]] = dp[i][j] + dist(j, word[i])  // if j != 26
dp[i+1][word[i-1]] = dp[i][j] + 0                 // if j == 26 (free)
```

### Letter to Coordinate

```python
def pos(c):
    idx = ord(c) - ord('A')
    return (idx // 6, idx % 6)
```

### Distance

Manhattan distance: `|x1 - x2| + |y1 - y2|`

## Complexity

- **Time:** O(n × 27) = O(n)
- **Space:** O(27) = O(1) with space optimization

## Edge Cases

- Same consecutive letters → 0 distance
- All same letters → 0 total distance
- Two distinct letters alternating → one finger each
