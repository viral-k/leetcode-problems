from typing import List


class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        """
        1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
        Time: O(m × n × log(min(m, n)))
        Space: O(m × n)
        """
        m, n = len(mat), len(mat[0])

        pref = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pref[i][j] = (
                    mat[i - 1][j - 1]
                    + pref[i - 1][j]
                    + pref[i][j - 1]
                    - pref[i - 1][j - 1]
                )

        def possible(L: int) -> bool:
            for i in range(m - L + 1):
                for j in range(n - L + 1):
                    total = (
                        pref[i + L][j + L]
                        - pref[i][j + L]
                        - pref[i + L][j]
                        + pref[i][j]
                    )
                    if total <= threshold:
                        return True
            return False

        low, high = 0, min(m, n)
        ans = 0

        while low <= high:
            mid = (low + high) // 2
            if possible(mid):
                ans = mid
                low = mid + 1
            else:
                high = mid - 1

        return ans
