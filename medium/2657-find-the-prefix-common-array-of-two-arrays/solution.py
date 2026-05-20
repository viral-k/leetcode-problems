from typing import List


class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        """
        2657. Find the Prefix Common Array of Two Arrays
        Time: O(n)
        Space: O(n)
        """
        n = len(A)
        seen = [0] * (n + 1)
        answer = []
        common = 0

        for a, b in zip(A, B):
            seen[a] += 1
            if seen[a] == 2:
                common += 1

            seen[b] += 1
            if seen[b] == 2:
                common += 1

            answer.append(common)

        return answer
