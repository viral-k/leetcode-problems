class Solution:
    def processStr(self, s: str, k: int) -> str:
        """
        3614. Process String with Special Operations II
        Time: O(n)
        Space: O(n)
        """
        CAP = 2 * 10**15  # above max k and max length; guards against overflow

        # Forward pass: length of the buffer after each step.
        lengths = []
        cur = 0
        for ch in s:
            if ch == "*":
                if cur > 0:
                    cur -= 1
            elif ch == "#":
                cur = min(cur * 2, CAP)
            elif ch == "%":
                pass
            else:
                cur = min(cur + 1, CAP)
            lengths.append(cur)

        if k >= cur:
            return "."

        # Backward pass: trace k to the letter that produced it.
        for i in range(len(s) - 1, -1, -1):
            ch = s[i]
            before = lengths[i - 1] if i > 0 else 0

            if ch == "*":
                continue
            elif ch == "#":
                if k >= before:
                    k -= before
            elif ch == "%":
                k = before - 1 - k
            else:
                if k == before:
                    return ch

        return "."
