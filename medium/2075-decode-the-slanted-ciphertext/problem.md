# Decode the Slanted Ciphertext

**Difficulty:** Medium  
**LeetCode Link:** [Decode the Slanted Ciphertext](https://leetcode.com/problems/decode-the-slanted-ciphertext/)

## Description

A string `originalText` is encoded using a slanted transposition cipher to a string `encodedText` with the help of a matrix having a fixed number of rows.

`originalText` is placed first in a **top-left to bottom-right diagonal** manner in the matrix. All empty cells are filled with `' '`. The number of columns is chosen such that the rightmost column will not be empty after filling in `originalText`.

`encodedText` is then formed by appending all characters of the matrix in a **row-wise** fashion.

Given the encoded string `encodedText` and number of rows `rows`, return the original string `originalText`.

**Note:** `originalText` does not have any trailing spaces `' '`. The test cases are generated such that there is only one possible `originalText`.

## Examples

### Example 1
```
Input: encodedText = "ch   ie   pr", rows = 3
Output: "cipher"
Explanation: The matrix is:
c h   
  i e 
    p r
Reading diagonally gives "cipher".
```

### Example 2
```
Input: encodedText = "iveo    eed   l te   olc", rows = 4
Output: "i love leetcode"
```

### Example 3
```
Input: encodedText = "coding", rows = 1
Output: "coding"
Explanation: Since there is only 1 row, both originalText and encodedText are the same.
```

## Constraints

- `0 <= encodedText.length <= 10^6`
- `encodedText` consists of lowercase English letters and `' '` only
- `encodedText` is a valid encoding of some `originalText` that does not have trailing spaces
- `1 <= rows <= 1000`
- The testcases are generated such that there is only one possible `originalText`
