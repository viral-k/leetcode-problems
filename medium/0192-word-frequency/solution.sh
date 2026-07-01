# 192. Word Frequency
# Read from the file words.txt and output the word frequency list to stdout.
# Time: O(w log w)  Space: O(w)

grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -rn | awk '{print $2, $1}'
