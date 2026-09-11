from typing import List


class Solution:
    def totalNumbers(self, digits: List[int]) -> int:
        """
        3483. Unique 3-Digit Even Numbers
        Time: O(1)
        Space: O(1)
        """
        counts = [0] * 10
        for d in digits:
            counts[d] += 1

        total = 0
        for h in range(1, 10):            # no leading zero
            if counts[h] == 0:
                continue
            counts[h] -= 1
            for t in range(10):
                if counts[t] == 0:
                    continue
                counts[t] -= 1
                for u in (0, 2, 4, 6, 8):  # must be even
                    if counts[u] > 0:
                        total += 1
                counts[t] += 1
            counts[h] += 1

        return total
