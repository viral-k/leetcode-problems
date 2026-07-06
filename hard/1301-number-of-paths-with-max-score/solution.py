from typing import List


class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        """
        1301. Number of Paths with Max Score
        Time: O(n^2)
        Space: O(n^2)
        """
        MOD = 10**9 + 7
        n = len(board)
        NEG = float("-inf")

        best = [[NEG] * n for _ in range(n)]
        cnt = [[0] * n for _ in range(n)]
        best[n - 1][n - 1] = 0  # start at 'S'
        cnt[n - 1][n - 1] = 1

        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                ch = board[i][j]
                if ch == "X" or (i == n - 1 and j == n - 1):
                    continue
                if ch == "S":
                    continue
                # gather best over the three predecessors
                bmax = NEG
                for pi, pj in ((i + 1, j), (i, j + 1), (i + 1, j + 1)):
                    if pi < n and pj < n and best[pi][pj] > bmax:
                        bmax = best[pi][pj]
                if bmax == NEG:
                    continue  # unreachable
                ways = 0
                for pi, pj in ((i + 1, j), (i, j + 1), (i + 1, j + 1)):
                    if pi < n and pj < n and best[pi][pj] == bmax:
                        ways = (ways + cnt[pi][pj]) % MOD
                val = 0 if ch == "E" else int(ch)
                best[i][j] = bmax + val
                cnt[i][j] = ways

        if best[0][0] == NEG:
            return [0, 0]
        return [best[0][0], cnt[0][0] % MOD]
