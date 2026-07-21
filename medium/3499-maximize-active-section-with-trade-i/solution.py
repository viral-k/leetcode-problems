class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        """
        3499. Maximize Active Section with Trade I
        Time: O(n)
        Space: O(1)
        """
        t = "1" + s + "1"
        base = s.count("1")

        best_gain = 0
        prev_zero = 0  # length of the previous 0-run
        i = 0
        n = len(t)
        while i < n:
            if t[i] == "0":
                j = i
                while j < n and t[j] == "0":
                    j += 1
                run = j - i
                if prev_zero:  # adjacent zero-runs -> a valid trade
                    best_gain = max(best_gain, prev_zero + run)
                prev_zero = run
                i = j
            else:
                i += 1

        return base + best_gain
