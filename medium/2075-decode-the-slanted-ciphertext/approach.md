# Approach

**Tags:** `String`, `Matrix`, `Simulation`

## Intuition

The encoding places characters diagonally and reads row by row. To decode, reconstruct the matrix from row-wise data and read diagonally.

## Solution

### Step 1: Calculate Dimensions

```
cols = len(encodedText) / rows
```

### Step 2: Reconstruct Matrix

The encodedText is the matrix read row by row, so:
- Row `i` contains `encodedText[i * cols : (i + 1) * cols]`

### Step 3: Read Diagonally

For each starting column `c` (0 to cols-1):
- Read characters at positions `(0, c), (1, c+1), (2, c+2), ...`
- Stop when row or column goes out of bounds

### Step 4: Strip Trailing Spaces

The original text has no trailing spaces.

### Visual Example

```
encodedText = "ch   ie   pr", rows = 3, cols = 4

Matrix:
  c=0 c=1 c=2 c=3
r=0: c   h   ' ' ' '
r=1: ' ' i   e   ' '
r=2: ' ' ' ' p   r

Diagonal reads:
Start c=0: (0,0)→c, (1,1)→i, (2,2)→p = "cip"
Start c=1: (0,1)→h, (1,2)→e, (2,3)→r = "her"
Start c=2: (0,2)→' ', (1,3)→' ' = "  "
Start c=3: (0,3)→' ' = " "

Combined: "cipher  " → strip → "cipher"
```

## Complexity

- **Time:** O(n) where n = len(encodedText)
- **Space:** O(n) for result string (or O(1) if using index math directly)

## Edge Cases

- `rows = 1` → return encodedText stripped
- Empty string → return empty
- All spaces except diagonal → still works
