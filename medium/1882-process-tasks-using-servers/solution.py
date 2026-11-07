import heapq


class Solution:
    def assignTasks(self, servers: list[int], tasks: list[int]) -> list[int]:
        """
        1882. Process Tasks Using Servers
        Time: O((n + m) log n)
        Space: O(n + m)
        """
        # Keys pack (major, index) into one int: indices are below 2^18.
        SHIFT = 18
        MASK = (1 << SHIFT) - 1

        free = [(w << SHIFT) | i for i, w in enumerate(servers)]  # (weight, index)
        heapq.heapify(free)
        busy = []  # (free time, index)

        ans = []
        t = 0
        for j, duration in enumerate(tasks):
            # Task j starts no earlier than it arrives or than task j - 1 started.
            t = max(t, j)
            if not free:
                t = max(t, busy[0] >> SHIFT)
            while busy and busy[0] >> SHIFT <= t:
                i = heapq.heappop(busy) & MASK
                heapq.heappush(free, (servers[i] << SHIFT) | i)

            i = heapq.heappop(free) & MASK
            ans.append(i)
            heapq.heappush(busy, ((t + duration) << SHIFT) | i)

        return ans
