class Solution:
    def smallestNumber(self, num: str, t: int) -> str:
        """
        3348. Smallest Divisible Digit Product II
        Time: O(n)
        Space: O(n)
        """
        # Reduce t to its 2/3/5/7 exponents; any leftover prime is impossible.
        exp = {2: 0, 3: 0, 5: 0, 7: 0}
        for p in (2, 3, 5, 7):
            while t % p == 0:
                t //= p
                exp[p] += 1
        if t != 1:
            return "-1"
        A2, A3, A5, A7 = exp[2], exp[3], exp[5], exp[7]

        # Per-digit (2,3,5,7) exponent contributions.
        C = {
            1: (0, 0, 0, 0), 2: (1, 0, 0, 0), 3: (0, 1, 0, 0), 4: (2, 0, 0, 0),
            5: (0, 0, 1, 0), 6: (1, 1, 0, 0), 7: (0, 0, 0, 1), 8: (3, 0, 0, 0),
            9: (0, 2, 0, 0),
        }

        def leftover(r2: int, r3: int):
            # smallest digits covering r2 twos (0..2) and r3 threes (0..1)
            if r2 == 1 and r3 == 1:
                return [6]
            if r2 == 2 and r3 == 1:
                return [2, 6]
            if r2 == 1 and r3 == 0:
                return [2]
            if r2 == 2 and r3 == 0:
                return [4]
            if r2 == 0 and r3 == 1:
                return [3]
            return []

        def build_digits(x2, x3, x5, x7):
            n9, r3 = divmod(x3, 2)
            n8, r2 = divmod(x2, 3)
            ds = [9] * n9 + [8] * n8 + leftover(r2, r3) + [5] * x5 + [7] * x7
            ds.sort()
            return ds

        def mincount(x2, x3, x5, x7):
            n9, r3 = divmod(x3, 2)
            n8, r2 = divmod(x2, 3)
            return n9 + n8 + len(leftover(r2, r3)) + x5 + x7

        S = build_digits(A2, A3, A5, A7)
        S_str = "".join(map(str, S))
        min_c = len(S)

        n = len(num)
        digs = [ord(c) - 48 for c in num]

        # First zero index (kept prefix must be zero-free).
        z = n
        for i, d in enumerate(digs):
            if d == 0:
                z = i
                break

        # Cumulative exponent contribution of num[0..i-1] (valid for i <= z).
        pref = [(0, 0, 0, 0)] * (n + 1)
        cur = (0, 0, 0, 0)
        for i in range(n):
            if i < z:
                c = C[digs[i]]
                cur = (cur[0] + c[0], cur[1] + c[1], cur[2] + c[2], cur[3] + c[3])
            pref[i + 1] = cur

        def remaining(contrib):
            return (max(0, A2 - contrib[0]), max(0, A3 - contrib[1]),
                    max(0, A5 - contrib[2]), max(0, A7 - contrib[3]))

        # Candidate: num itself (zero-free and already covers t).
        if z == n:
            f = pref[n]
            if f[0] >= A2 and f[1] >= A3 and f[2] >= A5 and f[3] >= A7:
                return num

        # Same length: bump at the largest feasible position.
        hi = z if z < n else n - 1
        for i in range(hi, -1, -1):
            base = pref[i]
            avail = n - 1 - i
            for d in range(digs[i] + 1, 10):
                cd = C[d]
                contrib = (base[0] + cd[0], base[1] + cd[1], base[2] + cd[2], base[3] + cd[3])
                r2, r3, r5, r7 = remaining(contrib)
                need = mincount(r2, r3, r5, r7)
                if need <= avail:
                    suf = build_digits(r2, r3, r5, r7)
                    suffix = "1" * (avail - need) + "".join(map(str, suf))
                    return num[:i] + str(d) + suffix

        # No same-length answer: use the smallest longer covering number.
        L = max(n + 1, min_c)
        return "1" * (L - min_c) + S_str
