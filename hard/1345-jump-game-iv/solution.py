from collections import defaultdict, deque
from typing import List


class Solution:
    def minJumps(self, arr: List[int]) -> int:
        """
        1345. Jump Game IV
        Time: O(n)
        Space: O(n)
        """
        n = len(arr)
        if n == 1:
            return 0

        value_to_indices = defaultdict(list)
        for index, value in enumerate(arr):
            value_to_indices[value].append(index)

        visited = [False] * n
        visited[0] = True
        queue = deque([0])
        steps = 0

        while queue:
            for _ in range(len(queue)):
                index = queue.popleft()

                if index == n - 1:
                    return steps

                next_indices = value_to_indices[arr[index]]
                next_indices.append(index - 1)
                next_indices.append(index + 1)

                for next_index in next_indices:
                    if 0 <= next_index < n and not visited[next_index]:
                        visited[next_index] = True
                        queue.append(next_index)

                value_to_indices[arr[index]].clear()

            steps += 1

        return -1
