from typing import List


class Solution:
    def concatenateAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        """
        3756. Concatenate Non-Zero Digits and Multiply by Sum II
        Time: O(m + q)
        Space: O(m)
        """
        MOD = 10**9 + 7
        m = len(s)

        # Powers of 10 and inverse powers of 10, indexed by non-zero-digit count.
        pow10 = [1] * (m + 1)
        for i in range(1, m + 1):
            pow10[i] = pow10[i - 1] * 10 % MOD
        inv10 = pow(10, MOD - 2, MOD)
        inv10pow = [1] * (m + 1)
        for i in range(1, m + 1):
            inv10pow[i] = inv10pow[i - 1] * inv10 % MOD

        # Prefix arrays.
        cnt = [0] * (m + 1)       # non-zero-digit count in s[0..i-1]
        sum_pref = [0] * (m + 1)  # digit-value sum in s[0..i-1]
        w_pref = [0] * (m + 1)    # sum of weights w_q for q < i
        for i in range(m):
            d = ord(s[i]) - 48
            nz = 1 if d != 0 else 0
            cnt[i + 1] = cnt[i] + nz
            sum_pref[i + 1] = sum_pref[i] + d
            # w_q = d * 10^{-cnt[q+1]}; zero digits contribute 0
            w = d * inv10pow[cnt[i + 1]] % MOD if d != 0 else 0
            w_pref[i + 1] = (w_pref[i] + w) % MOD

        ans = []
        for l, r in queries:
            S = (w_pref[r + 1] - w_pref[l]) % MOD
            x = pow10[cnt[r + 1]] * S % MOD
            total = sum_pref[r + 1] - sum_pref[l]
            ans.append(x * (total % MOD) % MOD)
        return ans
