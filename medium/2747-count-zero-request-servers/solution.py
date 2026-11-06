from typing import List


class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        """
        2747. Count Zero Request Servers
        Time: O(m log m + q log q + n)
        Space: O(n + m + q)
        """
        logs = sorted(logs, key=lambda log: log[1])
        m = len(logs)

        count = [0] * (n + 1)  # server ids are 1-based
        active = left = right = 0
        answer = [0] * len(queries)

        # Answer queries in increasing order so the window only moves right.
        for i in sorted(range(len(queries)), key=queries.__getitem__):
            q = queries[i]
            while right < m and logs[right][1] <= q:
                server = logs[right][0]
                if count[server] == 0:
                    active += 1
                count[server] += 1
                right += 1
            while left < right and logs[left][1] < q - x:
                server = logs[left][0]
                count[server] -= 1
                if count[server] == 0:
                    active -= 1
                left += 1
            answer[i] = n - active

        return answer
