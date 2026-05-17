from collections import deque
from typing import List


class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        """
        1306. Jump Game III
        Time: O(n)
        Space: O(n)
        """
        n = len(arr)
        visited = [False] * n
        queue = deque([start])
        visited[start] = True

        while queue:
            index = queue.popleft()

            if arr[index] == 0:
                return True

            for next_index in (index + arr[index], index - arr[index]):
                if 0 <= next_index < n and not visited[next_index]:
                    visited[next_index] = True
                    queue.append(next_index)

        return False
