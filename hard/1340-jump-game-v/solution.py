from functools import lru_cache
from typing import List


class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        """
        1340. Jump Game V
        Time: O(n * d)
        Space: O(n)
        """
        n = len(arr)

        @lru_cache(None)
        def dfs(index: int) -> int:
            best = 1

            for next_index in range(index + 1, min(n, index + d + 1)):
                if arr[next_index] >= arr[index]:
                    break
                best = max(best, 1 + dfs(next_index))

            for next_index in range(index - 1, max(-1, index - d - 1), -1):
                if arr[next_index] >= arr[index]:
                    break
                best = max(best, 1 + dfs(next_index))

            return best

        return max(dfs(index) for index in range(n))
