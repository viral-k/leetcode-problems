# Minimum Distance to Type a Word Using Two Fingers

**Difficulty:** Hard  
**LeetCode Link:** [Minimum Distance to Type a Word Using Two Fingers](https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/)

## Description

You have a keyboard layout in the X-Y plane, where each English uppercase letter is located at some coordinate.

```
A B C D E F
G H I J K L
M N O P Q R
S T U V W X
Y Z
```

- Letter 'A' is at coordinate (0, 0)
- Letter 'B' is at coordinate (0, 1)
- Letter 'P' is at coordinate (2, 3)
- Letter 'Z' is at coordinate (4, 1)

Given the string `word`, return the **minimum total distance** to type such string using only two fingers.

The distance between coordinates `(x1, y1)` and `(x2, y2)` is `|x1 - x2| + |y1 - y2|`.

**Note:** The initial positions of your two fingers are considered **free** so do not count towards your total distance. Your two fingers do not have to start at the first letter or the first two letters.

## Examples

### Example 1
```
Input: word = "CAKE"
Output: 3
Explanation:
- Finger 1 on 'C' → cost = 0
- Finger 1 on 'A' → cost = distance(C, A) = 2
- Finger 2 on 'K' → cost = 0
- Finger 2 on 'E' → cost = distance(K, E) = 1
Total = 3
```

### Example 2
```
Input: word = "HAPPY"
Output: 6
Explanation:
- Finger 1 on 'H' → cost = 0
- Finger 1 on 'A' → cost = distance(H, A) = 2
- Finger 2 on 'P' → cost = 0
- Finger 2 on 'P' → cost = 0
- Finger 1 on 'Y' → cost = distance(A, Y) = 4
Total = 6
```

## Constraints

- `2 <= word.length <= 300`
- `word` consists of uppercase English letters
