class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        """
        3700. Number of ZigZag Arrays II
        Time: O(m^3 log n) where m = r - l + 1
        Space: O(m^2)
        """
        MOD = 10**9 + 7
        m = r - l + 1

        # Transition matrix: new_up[v] = sum_{w >= m - v} up[w].
        M = [[1 if w >= m - v else 0 for w in range(m)] for v in range(m)]

        def mul(A, B):
            B_cols = list(zip(*B))
            return [
                [sum(a * b for a, b in zip(row, col)) % MOD for col in B_cols]
                for row in A
            ]

        # Binary exponentiation of M to the (n - 1) power.
        result = [[int(i == j) for j in range(m)] for i in range(m)]
        power = n - 1
        base = M
        while power:
            if power & 1:
                result = mul(result, base)
            base = mul(base, base)
            power >>= 1

        # up at length n = result @ ones; total over v = sum of all entries.
        total_up = sum(sum(row) % MOD for row in result) % MOD
        return (2 * total_up) % MOD
