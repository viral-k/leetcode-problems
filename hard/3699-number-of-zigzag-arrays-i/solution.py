class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        """
        3699. Number of ZigZag Arrays I
        Time: O(n * m) where m = r - l + 1
        Space: O(m)
        """
        MOD = 10**9 + 7
        m = r - l + 1

        # up[v]/down[v]: sequences ending at value v with last step up/down.
        up = [1] * m
        down = [1] * m

        for _ in range(2, n + 1):
            new_up = [0] * m
            new_down = [0] * m

            prefix = 0  # sum of down[u] for u < v
            for v in range(m):
                new_up[v] = prefix
                prefix = (prefix + down[v]) % MOD

            suffix = 0  # sum of up[u] for u > v
            for v in range(m - 1, -1, -1):
                new_down[v] = suffix
                suffix = (suffix + up[v]) % MOD

            up, down = new_up, new_down

        return (sum(up) + sum(down)) % MOD
