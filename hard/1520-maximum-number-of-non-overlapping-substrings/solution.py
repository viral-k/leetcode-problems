from typing import List


class Solution:
    def maxNumOfSubstrings(self, s: str) -> List[str]:
        """
        1520. Maximum Number of Non-Overlapping Substrings
        Time: O(26 * n)
        Space: O(1) beyond the output
        """
        n = len(s)
        first = {}
        last = {}
        for i, ch in enumerate(s):
            if ch not in first:
                first[ch] = i
            last[ch] = i

        # one closed candidate per letter, starting at that letter's first
        # occurrence; dropped if some inner letter forces extension to the left
        candidates = []
        for ch in first:
            left = first[ch]
            right = last[ch]
            i = left
            valid = True
            while i <= right:
                x = s[i]
                if first[x] < left:
                    valid = False
                    break
                if last[x] > right:
                    right = last[x]
                i += 1
            if valid:
                candidates.append((right, left))

        # candidates are nested or disjoint, so earliest-end greedy picks the
        # most intervals and the innermost ones
        candidates.sort()
        result = []
        prev_end = -1
        for right, left in candidates:
            if left > prev_end:
                result.append(s[left:right + 1])
                prev_end = right
        return result
