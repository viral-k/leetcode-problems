from typing import List


class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        """
        2452. Words Within Two Edits of Dictionary
        Time: O(Q * D * N)
        Space: O(1)
        """

        def matches(q: str, d: str) -> bool:
            diff = 0
            for c1, c2 in zip(q, d):
                if c1 != c2:
                    diff += 1
                    if diff > 2:
                        return False
            return True

        result = []
        for query in queries:
            if any(matches(query, word) for word in dictionary):
                result.append(query)

        return result
