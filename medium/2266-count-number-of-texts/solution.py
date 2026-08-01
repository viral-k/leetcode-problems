class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        """
        2266. Count Number of Texts
        Time: O(n)
        Space: O(n)
        """
        MOD = 10**9 + 7
        n = len(pressedKeys)

        # dp3: tile length i with pieces 1..3; dp4: pieces 1..4.
        dp3 = [0] * (n + 1)
        dp4 = [0] * (n + 1)
        dp3[0] = dp4[0] = 1
        for i in range(1, n + 1):
            dp3[i] = (dp3[i - 1] + (dp3[i - 2] if i >= 2 else 0) + (dp3[i - 3] if i >= 3 else 0)) % MOD
            dp4[i] = (dp4[i - 1] + (dp4[i - 2] if i >= 2 else 0)
                      + (dp4[i - 3] if i >= 3 else 0) + (dp4[i - 4] if i >= 4 else 0)) % MOD

        ans = 1
        i = 0
        while i < n:
            j = i
            while j < n and pressedKeys[j] == pressedKeys[i]:
                j += 1
            run = j - i
            table = dp4 if pressedKeys[i] in "79" else dp3
            ans = ans * table[run] % MOD
            i = j
        return ans
