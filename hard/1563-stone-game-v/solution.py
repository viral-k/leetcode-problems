from typing import List


class Solution:
    def stoneGameV(self, stoneValue: List[int]) -> int:
        """
        1563. Stone Game V
        Time: O(n^2)
        Space: O(n^2)
        """
        n = len(stoneValue)
        if n < 2:
            return 0

        # Prefix sums: sum(i..j) = P[j+1] - P[i]
        P = [0] * (n + 1)
        for i, x in enumerate(stoneValue):
            P[i + 1] = P[i] + x

        dp = [[0] * n for _ in range(n)]
        mL = [[0] * n for _ in range(n)]  # mL[i][k] = max_{k'<=k} (sum(i..k') + dp[i][k'])
        mR = [[0] * n for _ in range(n)]  # mR[k][j] = max_{k'>=k} (sum(k'..j) + dp[k'][j])

        for i in range(n - 1, -1, -1):
            mL[i][i] = stoneValue[i]
            mR[i][i] = stoneValue[i]
            p = i  # monotone split threshold for this i
            for j in range(i + 1, n):
                total = P[j + 1] - P[i]
                # smallest k in [i, j-1] with 2 * sum(i..k) >= total (else p == j)
                while p < j and 2 * (P[p + 1] - P[i]) < total:
                    p += 1

                # a tie at k == p lets Alice also keep the left side
                lb = p if (p <= j - 1 and 2 * (P[p + 1] - P[i]) == total) else p - 1

                best = 0
                if lb >= i:
                    best = mL[i][lb]
                if p + 1 <= j and mR[p + 1][j] > best:
                    best = mR[p + 1][j]
                dp[i][j] = best

                span = total + best  # sum(i..j) + dp[i][j]
                mL[i][j] = mL[i][j - 1] if mL[i][j - 1] > span else span
                mR[i][j] = mR[i + 1][j] if mR[i + 1][j] > span else span

        return dp[0][n - 1]
