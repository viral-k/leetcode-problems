from typing import List
from collections import deque


class Solution:
    def minMoves(self, classroom: List[str], energy: int) -> int:
        """
        3568. Minimum Moves to Clean the Classroom
        Time: O(m * n * 2^L)
        Space: O(m * n * 2^L)
        """
        m, n = len(classroom), len(classroom[0])

        litter = {}
        sr = sc = 0
        for r in range(m):
            for c in range(n):
                ch = classroom[r][c]
                if ch == "S":
                    sr, sc = r, c
                elif ch == "L":
                    litter[(r, c)] = len(litter)

        full = (1 << len(litter)) - 1
        if full == 0:
            return 0

        # best[r][c][mask] = highest energy seen there; more energy is never worse.
        best = [[[-1] * (full + 1) for _ in range(n)] for _ in range(m)]
        best[sr][sc][0] = energy
        dq = deque([(sr, sc, 0, energy)])

        moves = 0
        while dq:
            for _ in range(len(dq)):
                r, c, mask, e = dq.popleft()
                if e == 0:
                    continue  # cannot move without energy
                for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    nr, nc = r + dr, c + dc
                    if not (0 <= nr < m and 0 <= nc < n):
                        continue
                    ch = classroom[nr][nc]
                    if ch == "X":
                        continue

                    ne = e - 1
                    nmask = mask
                    if ch == "L":
                        nmask |= 1 << litter[(nr, nc)]
                    if ch == "R":
                        ne = energy  # reset area refills to capacity

                    if nmask == full:
                        return moves + 1
                    if ne > best[nr][nc][nmask]:
                        best[nr][nc][nmask] = ne
                        dq.append((nr, nc, nmask, ne))
            moves += 1

        return -1
