from typing import List
from collections import Counter, defaultdict


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        """
        30. Substring with Concatenation of All Words
        Time: O(n * L)
        Space: O(m * L)
        """
        n = len(s)
        L = len(words[0])
        m = len(words)
        total = L * m
        if total > n:
            return []

        need = Counter(words)
        result = []

        # Windows only align to L distinct offsets; scan each track separately.
        for offset in range(L):
            window = defaultdict(int)
            left = offset
            count = 0

            for right in range(offset, n - L + 1, L):
                word = s[right:right + L]

                if word not in need:
                    # No valid window can span an unknown word: restart past it.
                    window.clear()
                    count = 0
                    left = right + L
                    continue

                window[word] += 1
                count += 1

                # Too many copies of this word: shrink from the left.
                while window[word] > need[word]:
                    window[s[left:left + L]] -= 1
                    left += L
                    count -= 1

                if count == m:
                    result.append(left)
                    # Slide one word forward to look for the next match.
                    window[s[left:left + L]] -= 1
                    left += L
                    count -= 1

        return result
