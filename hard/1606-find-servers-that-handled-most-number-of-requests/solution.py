import heapq


class Solution:
    def busiestServers(self, k: int, arrival: list[int], load: list[int]) -> list[int]:
        """
        1606. Find Servers That Handled Most Number of Requests
        Time: O(n log k)
        Space: O(k)
        """
        # A free server id is stored as the first request number >= i that maps
        # to it: i + (id - i) % k. Every key stays in [i, i + k), so the minimum
        # is the first free server clockwise from i % k.
        free = list(range(k))
        busy = []  # (end time, server)
        count = [0] * k

        for i, (a, l) in enumerate(zip(arrival, load)):
            while busy and busy[0][0] <= a:
                _, server = heapq.heappop(busy)
                heapq.heappush(free, i + (server - i) % k)
            if not free:
                continue  # every server is busy: drop the request
            server = heapq.heappop(free) % k
            count[server] += 1
            heapq.heappush(busy, (a + l, server))

        best = max(count)
        return [s for s in range(k) if count[s] == best]
