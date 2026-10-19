from heapq import heappop, heappush


class Solution:
    def getSkyline(self, buildings: list[list[int]]) -> list[list[int]]:
        """
        218. The Skyline Problem
        Time: O(n log n)
        Space: O(n)
        """
        # (x, -h, right) for a left edge, (x, 0, 0) for a right edge.
        # Sorting by -h puts starts before ends at a shared x, and taller
        # starts before shorter ones, so no point is emitted off the contour.
        events = []
        for left, right, height in buildings:
            events.append((left, -height, right))
            events.append((right, 0, 0))
        events.sort()

        skyline = []
        live = []  # max-heap of (-height, right), with lazy deletion
        for x, neg_height, right in events:
            while live and live[0][1] <= x:
                heappop(live)  # no longer covers x
            if neg_height:
                heappush(live, (neg_height, right))

            current = -live[0][0] if live else 0
            if not skyline or skyline[-1][1] != current:
                skyline.append([x, current])

        return skyline
