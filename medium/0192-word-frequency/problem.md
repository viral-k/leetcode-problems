# Word Frequency

**Difficulty:** Medium  
**LeetCode Link:** [Word Frequency](https://leetcode.com/problems/word-frequency/)

## Description

Write a bash script to calculate the frequency of each word in a text file `words.txt`.

For simplicity's sake, you may assume:

- `words.txt` contains only lowercase characters and space `' '` characters.
- Each word must consist of lowercase characters only.
- Words are separated by one or more whitespace characters.

## Examples

### Example
Assume that `words.txt` has the following content:
```
the day is sunny the the
the sunny is is
```

Your script should output the following, sorted by descending frequency:
```
the 4
is 3
sunny 2
day 1
```

## Constraints / Notes

- Don't worry about handling ties; each word's frequency count is guaranteed unique.
- Bonus: write it as a one-liner using Unix pipes.
